package pages;

import driver_factory.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Reddit_page  extends driverFactory {

    public boolean validate_user_is_on_homePage(){
        System.out.println("--------  Title  "+driver.getTitle()+"  ---------");
       return driver.getTitle().contains("Reddit") ;
    }
    public void search_reddit(){
        WebElement edt_search = driver.findElement(By.id("header-search-bar"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header-search-bar")));
        System.out.println("--------  Search For Sub Reddit gaming ---------");
        // ? Issue: Enter 'gaming' in Search box and submit, is leading to https://www.reddit.com/search/?q=gaming  ;
        // in this case Vote up, Vote down icons are not visible with any of the posts.
        // Requirement is to interact with on Up and Down vote buttons, hence i'm navigating to direct URl for gaming.
        driver.navigate().to("https://www.reddit.com/r/gaming/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='post-container']")));
    }

    public boolean validate_user_is_on_subReditSection(){
        System.out.println("--------  Title  "+driver.getTitle()+"  ---------");
        return driver.getTitle().contains("gaming") ;
    }

    public void print_title_topmost_post(){
        List<WebElement> posts = driver.findElements(By.xpath("//div[@data-testid='post-container']"));
        System.out.println("--------  Print Top most Post's Title  ---------");
        System.out.println(posts.get(0).findElements(By.xpath("//h3")).get(0).getText());
    }

    public void downVote_second_post(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        System.out.println("--------  down vote second post  ---------");
        //Below collection returns only posts ; hence we don't need to check if it's an advertisement
        List<WebElement> downVotes = driver.findElements(By.xpath("//i[contains(@class,'icon icon-downvote')]"));
        //Highlighting the element before click
        jsExecutor.executeScript("arguments[0].style.border='5px solid blue'", downVotes.get(2));
        //downVotes.get(2).click();
    }
}
