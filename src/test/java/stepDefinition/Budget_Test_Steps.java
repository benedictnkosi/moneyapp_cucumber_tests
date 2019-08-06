package stepDefinition;

import MoneyAppTests.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BudgetPage;
import pages.ConfigPage;
import pages.Homepage;
import pages.LoginPage;
import properties.Application;


public class Budget_Test_Steps extends BaseClass{

    WebDriver driver;

    Homepage homePage;
    LoginPage loginPage;

    Logger log = Logger.getLogger("devpinoyLogger");

    @Given("^User is on Budget Page$")
    public void user_is_on_Budget_Page() throws Throwable {
        super.setup();
        this.driver = super.driver;
        loginPage = new LoginPage(driver);

        log.debug("loging in user");
        loginPage.LoginUser(Application.application_username,Application.application_password);
        log.debug("user logged in");


        homePage = new Homepage(driver);
        log.debug("navigating to the budget page");
        homePage.OpenBudgetPage();
        log.debug("budget page opened");
    }

    @When("^User clicks the add button$")
    public void user_clicks_the_add_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver = super.driver;
        BudgetPage budgetPage = new BudgetPage(driver);

        log.debug("clicking the add new budget item button");
        budgetPage.showBudgetForm();
        log.debug("clicked the add new budget item button");
    }

    @When("^User selects  budget category \"([^\"]*)\"$")
    public void user_selects_budget_category(String category) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver = super.driver;
        BudgetPage budgetPage = new BudgetPage(driver);

        log.debug("selecting category");
        budgetPage.selectCategory(category);
        log.debug("selected category");
    }


    @When("^User selects budget transaction \"([^\"]*)\"$")
    public void user_selects_budget_transaction(String trasaction_name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.driver = super.driver;
        BudgetPage budgetPage = new BudgetPage(driver);

        log.debug("selecting transaction");
        budgetPage.selectTransaction(trasaction_name);
        log.debug("selected transaction");
    }

    @When("^User clicks the submit button$")
    public void user_clicks_the_submit_button() throws Throwable {
        this.driver = super.driver;
        BudgetPage budgetPage = new BudgetPage(driver);

        log.debug("submitting the new budget item");
        budgetPage.submitBudgetForm();
        log.debug("submitted the new budget item");
    }


    @Then("^A budget success message is displayed : \"(.*)\"$")
    public void checkBudgetOutputMessage(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        BudgetPage budgetPage = new BudgetPage(driver);

        log.debug("checking success message");
        budgetPage.checkOutputMessage(message);
        log.debug("checked success message");
    }


    @After
    public void teardown() {
        driver.quit();
    }

}
