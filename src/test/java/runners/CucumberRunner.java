package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
        features = {"src/test/java/features/"},
        glue = {"src/test/java/stepdefinitions"},
        monochrome = true,
        tags = {},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"}
)
//WHILE RUNNING THIS  Cucumber Runner, if you face any configuration issues; PLEASE RUN src/main/java/reddit_test.java

public class CucumberRunner {

}