package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BudgetPage;
import pages.Homepage;
import pages.LoginPage;
import utils.ConfigFileReader;


public class Budget_Test_Steps extends BaseClass{

    TestContext testContext;
    WebDriver driver;
    ConfigFileReader configReader = new ConfigFileReader();
    PageObjectManager pageObjectManager;

    Homepage homePage;
    LoginPage loginPage;
    BudgetPage budgetPage;



    Logger log = Logger.getLogger("devpinoyLogger");

    public Budget_Test_Steps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        configReader = testContext.getConfigFileReader();

        pageObjectManager = testContext.getPageObjectManager();

        homePage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
        budgetPage = pageObjectManager.getBudgetPage();
    }


    @Given("^User is on Budget Page$")
    public void user_is_on_Budget_Page() throws Throwable {
        homePage.OpenLoginPage();
        log.debug("loging in user");
        loginPage.LoginUser(configReader.getPropertyByName("application_username"), configReader.getPropertyByName("application_password"));
        log.debug("user logged in");

        log.debug("navigating to the budget page");
        homePage.OpenBudgetPage();
        log.debug("budget page opened");
    }

    @When("^User clicks the add button$")
    public void user_clicks_the_add_button() {
        log.debug("clicking the add new budget item button");
        budgetPage.showBudgetForm();
        log.debug("clicked the add new budget item button");
    }

    @When("^User selects  budget category \"([^\"]*)\"$")
    public void user_selects_budget_category(String category) throws Throwable {
        log.debug("selecting category");
        budgetPage.selectCategory(category);
        log.debug("selected category");
    }


    @When("^User selects budget transaction \"([^\"]*)\"$")
    public void user_selects_budget_transaction(String trasaction_name) throws Throwable {
        log.debug("selecting transaction");
        budgetPage.selectTransaction(trasaction_name);
        log.debug("selected transaction");
    }

    @When("^User clicks the submit button$")
    public void user_clicks_the_submit_button() throws Throwable {
        log.debug("submitting the new budget item");
        budgetPage.submitBudgetForm();
        log.debug("submitted the new budget item");
    }


    @Then("^A budget success message is displayed : \"(.*)\"$")
    public void checkBudgetOutputMessage(String message) throws Throwable {
        log.debug("checking success message");
        budgetPage.checkOutputMessage(message);
        log.debug("checked success message");
    }



}
