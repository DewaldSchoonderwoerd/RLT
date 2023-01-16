package test;

import api.airtable.models.getallrecords.response.Record;
import base.Base;
import com.google.gson.Gson;
import model.trn.playerprofile.Data;
import model.trn.playerprofile.GetTRNProfileResponse;
import model.trn.playerprofile.Segment;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class TestResponseCode extends Base {

    private static final Logger LOG = LoggerFactory.getLogger(TestResponseCode.class);


    @Test
    public void sad(){
        String url = "https://api.tracker.gg/api/v2/rocket-league/standard/profile/epic/Cre8iv1s";
        driver.navigate().to(url);

        String profileJson = driver.findElement(By.xpath("/html[1]/body[1]/pre[1]")).getText();

        GetTRNProfileResponse getTRNProfileResponse = new Gson().fromJson(profileJson, GetTRNProfileResponse.class);

        System.out.println(getTRNProfileResponse.getData().getUserInfo().getUserId());

        for (Segment currentSegment : getTRNProfileResponse.getData().getSegments()){

            if (currentSegment.getMetadata().getName().equals("Ranked Duel 1v1")){
                int mmr = currentSegment.getStats().getRating().getValue();
                System.out.println(mmr);
            }

            if (currentSegment.getMetadata().getName().equals("Ranked Doubles 2v2")){
                int mmr = currentSegment.getStats().getRating().getValue();
                System.out.println(mmr);
            }

            if (currentSegment.getMetadata().getName().equals("Ranked Standard 3v3")){
                int mmr = currentSegment.getStats().getRating().getValue();
                System.out.println(mmr);
            }

        }
    }



}