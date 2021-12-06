import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.nio.file.Paths;
import java.util.List;

public class reddit_test {

    public static void main(String[] args) {
        //Paths.get("").toAbsolutePath()
        System.setProperty("webdriver.chrome.driver", "/sel/reddit_cucumber/src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("http://www.reddit.com/");
        driver.manage().window().maximize();

        WebElement edt_search = driver.findElement(By.id("header-search-bar"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search-bar")));

        // Search For Sub Reddit gaming;
            // ? Issue: Enter 'gaming' in Search box and submit, is leading to https://www.reddit.com/search/?q=gaming  ; in this case Vote up, Vote down icons are not visible with any of the posts.
            // Requirement is to Click on Up and Down vote buttons, hence i'm navigating to direct URl for gaming

        //edt_search.sendKeys("gaming"+ Keys.ARROW_DOWN);
        //edt_search.sendKeys("gaming");
        //edt_search.submit();

        driver.navigate().to("https://www.reddit.com/r/gaming/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='post-container']")));

        // Print Top most Post's Title
        List<WebElement> posts = driver.findElements(By.xpath("//div[@data-testid='post-container']"));//data-testid="post-container"
        List<WebElement> upVotes = driver.findElements(By.xpath("//i[contains(@class,'icon icon-upvote')]"));
        List<WebElement> downVotes = driver.findElements(By.xpath("//i[contains(@class,'icon icon-downvote')]"));

        System.out.println("--------  Print Top most Post's Title  ---------");
        System.out.println(posts.get(0).findElements(By.xpath("//h3")).get(0).getText());
        /*for (int i=0;i<posts.size();i++  ) {
            System.out.println(posts.get(i).getText());
            System.out.println("-------- "+i);
            System.out.println(posts.get(i).findElements(By.xpath("//h3")).get(i).getText());
            jsExecutor.executeScript("arguments[0].style.border='2px solid red'", upVotes.get(i*2));
            jsExecutor.executeScript("arguments[0].style.border='2px solid red'", downVotes.get(i*2));
            System.out.println("------------------------------------------------------------------------");
        }*/


        //Up Vote First Post and Down Vote the second Post
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='5px solid blue'", upVotes.get(0));
        jsExecutor.executeScript("arguments[0].style.border='5px solid blue'", downVotes.get(2));
        // Switch vote the second Post if it's not and advertisement

        // use bdd, page object, coding standards, documentation.

        //Login
        driver.findElement(By.linkText("Log In")).click();
        //List<WebElement> listOfa = driver.findElements(By.tagName("a"));
        driver.switchTo().frame(0);
        driver.findElement(By.id("loginUsername")).sendKeys("TestUser@gmail.com");
        driver.findElement(By.id("loginPassword")).sendKeys("loginPassword!123"+Keys.TAB);
        driver.findElement(By.xpath("//button[contains(@class,'AnimatedForm__submitButton')]"));
        driver.switchTo().defaultContent();


        //close window
        List<WebElement> close_buttons = driver.findElements(By.tagName("polygon"));
        for(int l=0;l<close_buttons.size();l++){
            try{
                driver.findElements(By.tagName("polygon")).get(l).click();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

       //driver.findElements(By.tagName("polygon")).get(2).click();

        driver.quit();
    }
}