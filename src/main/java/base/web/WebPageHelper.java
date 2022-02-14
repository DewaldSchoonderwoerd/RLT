package base.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebPageHelper {

    private static final Logger LOG = LoggerFactory.getLogger(WebPageHelper.class);

    public static final String ID = "ID";
    public static final String XPATH = "xpath";
    public static final String TEXT = "text";
    public static final String CONTAINS = "contains";
    public static final String STARTS_WITH = "starts-with";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static final int DRIVER_DEFAULT_WAIT_TIMEOUT = 30;
    protected static final int SLEEP_IN_BETWEEN_POLLS = 500;

    public WebPageHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DRIVER_DEFAULT_WAIT_TIMEOUT), Duration.ofMillis(SLEEP_IN_BETWEEN_POLLS));
    }

    public void sendKeys(WebElement element, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(15)).
                until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    protected WebElement findElementWhenReady(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by);
        } catch (Exception e) {
            LOG.error("Exception on : " + by);
        }
        return null;
    }

    public WebElement getElementByType(String type, String value) {
        try {
            return findElementWhenReady(getByTypeAndValue(type, value));
        } catch (Exception e) {
            return null;
        }
    }

    public By getByTypeAndValue(String type, String value) {
        String inputType = type.toLowerCase();
        By by = By.id(value);

        if (inputType.equalsIgnoreCase(ID)) {
            by = By.id(value);
            LOG.info("finding element by id => " + value);

        } else if (inputType.equalsIgnoreCase(XPATH)) {
            by = By.xpath(value);
            LOG.info("finding element by xpath => " + value);

        } else if (inputType.equalsIgnoreCase(TEXT)) {
            by = By.xpath("//*[.='" + value + "']");
            LOG.info("finding element by text => " + value);

        } else if (inputType.equalsIgnoreCase(CONTAINS)) {
            by = By.xpath("//*[contains(.,'" + value + "')]");
            LOG.info("finding element by contains => " + value);
        } else if (inputType.equalsIgnoreCase(STARTS_WITH)) {
            by = By.xpath("//*[starts-with(text(),'" + value + "')]");
            LOG.info("finding element by starts-with => " + value);
        }
        return by;
    }
}