package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Login_page;
import pages.Reddit_page;

public class redit_stepdef {
    Reddit_page reddit_steps = new Reddit_page();
    Login_page login_steps = new Login_page();
    @Given("^User is on the Reddit Homepage$")
    public void is_user_is_on_Homepage(){
        reddit_steps.validate_user_is_on_homePage();
    }

    @When("^Enteres a Search String on the Search and User Submits$")
    public void search_and_submit_Posts(){
        reddit_steps.search_reddit();
    }

    @Then("^User is navigated to the SubReddit Section$")
    public void User_is_navigated_to_the_SubReddit_Section() {
        reddit_steps.validate_user_is_on_subReditSection();
    }

    @Then("^User Prints out the top most post title$")
    public void user_Prints_out_the_top_most_post_title()  {
        reddit_steps.print_title_topmost_post();
    }

    @Then("^User performs a Login$")
    public void user_performs_a_Login()  {
        login_steps.login();
    }

    @Then("^DownVote the Second post if its Upvoted$")
    public void downVote_the_Second_post_if_its_Upvoted()  {
        reddit_steps.downVote_second_post();
    }
}
