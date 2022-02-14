package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;

public class Base {

    public static WebDriver driver;

    private static final Logger LOG = LoggerFactory.getLogger(Base.class);

    private static final int implicitWaitTimeout = 20;
    private static final int scriptTimeout = 30;
    private static final int pageLoadTimeout = 60;

    @Parameters({"platformType", "browserName"})
    @BeforeClass(alwaysRun = true)
    public void setupDriver() {
        LOG.info(" -- init driver -- ");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("--disable-extensions");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTimeout));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(scriptTimeout));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
        driver.manage().window().maximize();

        LOG.info(" -- Driver ready -- ");
    }

    @Parameters
    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        if (driver != null) driver.quit();
        LOG.info(" -- Driver closed -- ");
    }
}
