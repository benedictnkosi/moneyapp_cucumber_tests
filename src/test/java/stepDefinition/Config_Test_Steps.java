package stepDefinition;

import MoneyAppTests.BaseClass;
import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ConfigPage;
import pages.Homepage;
import pages.LoginPage;
import utils.ConfigFileReader;


public class Config_Test_Steps extends BaseClass{

    TestContext testContext;

    WebDriver driver;
    ConfigFileReader configReader;
    PageObjectManager pageObjectManager;

    Homepage homePage;
    LoginPage loginPage;
    ConfigPage configPage;

    Logger log = Logger.getLogger("devpinoyLogger");


    public Config_Test_Steps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        configReader = testContext.getConfigFileReader();

        pageObjectManager = testContext.getPageObjectManager();
        homePage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
        configPage = pageObjectManager.getConfigPage();
    }

    @Given("^User is on Config Page$")
    public void user_is_on_Config_Page() {
        log.debug("logging in user");
        loginPage.LoginUser(configReader.getPropertyByName("application_username"), configReader.getPropertyByName("application_password"));
        log.debug("user logged in");

        log.debug("navigating to the config page");
        homePage.OpenConfigPage();
        log.debug("config page opened");
    }


    @When("^User selects category \"(.*)\"$")
    public void selectCategory(String category) {
        log.debug("Selecting transaction category ");
        configPage.selectCategory(category);
        log.debug("Selected transaction category ");
    }



    @When("^User enters \"(.*)\"$")
    public void setTransactionName(String transactionName) {
        log.debug("Populating transaction name fiel ");
        configPage.setTransactionName(transactionName);
        log.debug("Transaction name field populated");
    }

    @When("^User clicks the create button$")
    public void submitNewCustomTransactionForm() {
        log.debug("Submitting the new transaction form");
        configPage.submitNewCustomTransactionForm();
        log.debug("transaction form submitted");
    }



    @When("^User clicks the delete button on \"([^\"]*)\"$")
    public void clickDeleteButton(String transactionName) throws InterruptedException {
        log.debug("clicking the delete button on transaction name ");
        configPage.clickDeleteButtonOnTransaction(transactionName);
        log.debug("Clicked the delete button on transaction name");
    }


    @Then("^A message is displayed : \"(.*)\"$")
    public void checkOutputMessage(String message) {
        log.debug("Checking output message");
        configPage.checkOutputMessage(message);
        log.debug("Checked output message");
    }

    @Then("^transaction \"([^\"]*)\" is added to the list$")
    public void transaction_is_added_to_the_list(String transactionName) {
        configPage.checkTransactionIsAdded(transactionName);
    }

    @Then("^The \"(.*)\" is removed from the list$")
    public void transaction_is_removed_from_the_list(String transactionName) {
        configPage.checkTransactionIsRemoved(transactionName);
    }
}
