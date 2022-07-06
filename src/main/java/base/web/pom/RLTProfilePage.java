package base.web.pom;

import base.web.WebPageHelper;
import base.web.utls.WebPropertyUtils;
import model.member.Member;
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

    public void pullMmr(Member member) {
        LOG.info(" -- Attempting rank pull for memeber " + member.getGamerTag());
        String mmr1v1 = null;
        String mmr2v2 = null;
        String mmr3v3 = null;

        String rowsXpath = "/html/body/div[1]/div[2]/div[2]/div/main/div[3]/div[3]/div[1]/div/div/div[1]/div[2]/table/tbody/tr";
        List<WebElement> rows = driver.findElements(By.xpath(rowsXpath));

        if (rows == null || rows.isEmpty()){
            LOG.error("Unable to find rows");
        }

        for (WebElement row : Objects.requireNonNull(rows)) {
            String currentRowText = row.getText();

            if (currentRowText.contains("Ranked Duel 1v1")) {
                mmr1v1 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 1v1 MMR - " + mmr1v1);
                member.setMmr1v1(Integer.parseInt(mmr1v1));
                continue;
            }
            if (currentRowText.contains("Ranked Doubles 2v2")) {
                mmr2v2 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 2v2 MMR - " + mmr1v1);
                member.setMmr2v2(Integer.parseInt(mmr2v2));
                continue;
            }
            if (currentRowText.contains("Ranked Standard 3v3")) {
                mmr3v3 = currentRowText.split("\n")[2].replace(",", "");
                LOG.info("Got 3v3 MMR - " + mmr1v1);
                member.setMmr3v3(Integer.parseInt(mmr3v3));
                continue;
            }

            if (mmr1v1 != null
            && mmr2v2 != null
            && mmr3v3 != null){
                LOG.info("Found all relative ranks");
                break;
            }

            if (mmr1v1 == null) {
                LOG.info(member.getGamerTag() + " has no 1v1 rank");
                member.setMmr1v1(0);
            }

            if (mmr2v2 == null) {
                LOG.info(member.getGamerTag() + " has no 2v2 rank");
                member.setMmr2v2(0);
            }

            if (mmr3v3 == null) {
                LOG.info(member.getGamerTag() + " has no 3v3 rank");
                member.setMmr3v3(0);
            }

        }

        LOG.info("Ranks pull attempt completed");
    }
}
