package driver_factory;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driverFactory {
    public static WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, 20);
    public WebDriver crete_webdriver()
    {
        System.setProperty("webdriver.chrome.driver", "/sel/reddit_cucumber/src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        driver = new ChromeDriver(options);

        driver.get("http://www.google.com/");
        driver.manage().window().maximize();
        return driver;
    }

}
