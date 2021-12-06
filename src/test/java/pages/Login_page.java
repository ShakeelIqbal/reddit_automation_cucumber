package pages;

import driver_factory.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;
import java.util.List;

public class Login_page extends driverFactory {
    public WebDriverWait wait = new WebDriverWait(driver, 20);

    public void login(){
        driver.findElement(By.linkText("Log In")).click();
        //List<WebElement> listOfa = driver.findElements(By.tagName("a"));
        driver.switchTo().frame(0);
        driver.findElement(By.id("loginUsername")).sendKeys("TestUser@gmail.com");
        driver.findElement(By.id("loginPassword")).sendKeys("loginPassword!123"+Keys.TAB);
        driver.findElement(By.xpath("//button[contains(@class,'AnimatedForm__submitButton')]"));
        driver.switchTo().defaultContent();

        //Close Login Dialog page if it's not closed automatically after submit
        List<WebElement> close_buttons = driver.findElements(By.tagName("polygon"));
        for(int l=0;l<close_buttons.size();l++){
            try{
                driver.findElements(By.tagName("polygon")).get(l).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
