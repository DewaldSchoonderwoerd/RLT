package base.web.pom;

import api.airtable.models.getallrecords.response.Record;
import base.web.WebPageHelper;
import base.web.utls.WebPropertyUtils;
import com.google.gson.Gson;
import model.member.Member;
import model.trn.playerprofile.GetTRNProfileResponse;
import model.trn.playerprofile.Segment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

public class RLTProfilePage extends WebPageHelper {

    private static final Logger LOG = LoggerFactory.getLogger(RLTProfilePage.class);

    public RLTProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goTo(String platform, String profile) {
        String baseUrl = WebPropertyUtils.getWebUrlDetails("rl.tracker.url");
        String fullUrl = baseUrl + "rocket-league/profile/" + platform + "/" + profile + "/overview";

        LOG.info("Full URL path: " + fullUrl);

        try {
            driver.navigate().to(fullUrl);
        } catch (WebDriverException e){
            LOG.info("Page load failed - retrying");
            driver.navigate().to(fullUrl);
        }
        LOG.info("Navigating to URL: " + baseUrl);
    }

    public void pullMmr(Record member) {
        LOG.info(" -- Attempting rank pull for memeber " + member.getFields().getGamertag());
        String mmr1v1 = null;
        String mmr2v2 = null;
        String mmr3v3 = null;

        String rowsXpath = "/html/body/div[1]/div[2]/div[2]/div/main/div[3]/div[3]/div[1]/div/div/div[1]/div[2]/table/tbody/tr";
        List<WebElement> rows = driver.findElements(By.xpath(rowsXpath));

        // Pull list of members
        // for each member pull ranks if not inactive
        // 

        if (rows == null || rows.isEmpty()){
            LOG.error("Unable to find rows");
        }

        for (WebElement row : Objects.requireNonNull(rows)) {
            String currentRowText = row.getText();

            if (currentRowText.contains("Ranked Duel 1v1")) {
                mmr1v1 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 1v1 MMR - " + mmr1v1);
                member.getFields().setSoloduel(Integer.parseInt(mmr1v1));
                continue;
            }
            if (currentRowText.contains("Ranked Doubles 2v2")) {
                mmr2v2 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 2v2 MMR - " + mmr2v2);
                member.getFields().setDoubles(Integer.parseInt(mmr2v2));
                continue;
            }
            if (currentRowText.contains("Ranked Standard 3v3")) {
                mmr3v3 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 3v3 MMR - " + mmr3v3);
                member.getFields().setStandard(Integer.parseInt(mmr3v3));
                continue;
            }

            if (mmr1v1 != null
            && mmr2v2 != null
            && mmr3v3 != null){
                LOG.info("Found all relative ranks");
                break;
            }

            if (mmr1v1 == null) {
                LOG.info(member.getFields().getGamertag() + " has no 1v1 rank");
                member.getFields().setSoloduel(0);
            }

            if (mmr2v2 == null) {
                LOG.info(member.getFields().getGamertag() + " has no 2v2 rank");
                member.getFields().setStandard(0);
            }

            if (mmr3v3 == null) {
                LOG.info(member.getFields().getGamertag() + " has no 3v3 rank");
                member.getFields().setStandard(0);
            }

        }

        LOG.info("Ranks pull attempt completed");
    }

    public void newPullMmr(Record member){
        LOG.info(" -- Attempting rank pull for member " + member.getFields().getGamertag());
        int mmr1v1;
        int mmr2v2;
        int mmr3v3;

        String url = "https://api.tracker.gg/api/v2/rocket-league/standard/profile/" + member.getFields().getPlatform()
                + "/" + member.getFields().getGamertag();
        driver.navigate().to(url);
        LOG.info("URL: " + url);
        String profileJson = driver.findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();
        GetTRNProfileResponse getTRNProfileResponse = new Gson().fromJson(profileJson, GetTRNProfileResponse.class);

        if (getTRNProfileResponse.getData() == null){
            LOG.error("Name check: " + member.getFields().getGamertag());
            return;
        }

        for (Segment currentSegment : getTRNProfileResponse.getData().getSegments()){



            if (currentSegment.getMetadata().getName().equals("Ranked Duel 1v1")){
                mmr1v1 = currentSegment.getStats().getRating().getValue();
                LOG.info("Solo MMR: " + mmr1v1);
                member.getFields().setSoloduel(mmr1v1);
                continue;
            }

            if (currentSegment.getMetadata().getName().equals("Ranked Doubles 2v2")){
                mmr2v2 = currentSegment.getStats().getRating().getValue();
                LOG.info("Doubles MMR: " + mmr2v2);
                member.getFields().setDoubles(mmr2v2);
                continue;
            }

            if (currentSegment.getMetadata().getName().equals("Ranked Standard 3v3")){
                mmr3v3 = currentSegment.getStats().getRating().getValue();
                LOG.info("Standards MMR: " + mmr3v3);
                member.getFields().setStandard(mmr3v3);
                continue;
            }
        }
        LOG.info("Ranks pull attempt completed for member " + member.getFields().getDiscord());
    }
}
