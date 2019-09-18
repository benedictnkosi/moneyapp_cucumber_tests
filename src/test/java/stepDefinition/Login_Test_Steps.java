package stepDefinition;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Homepage;
import pages.LoginPage;
import utils.ConfigFileReader;

public class Login_Test_Steps extends BaseClass {

    TestContext testContext;

    WebDriver driver;
    ConfigFileReader configReader;
    PageObjectManager pageObjectManager;

    Homepage homepage;
    LoginPage loginPage;

    Logger log = Logger.getLogger("devpinoyLogger");

    public Login_Test_Steps(TestContext context) {
        testContext = context;
        driver = testContext.getWebDriverManager().getDriver();
        configReader = testContext.getConfigFileReader();

        pageObjectManager = testContext.getPageObjectManager();

        homepage = pageObjectManager.getHomePage();
        loginPage = pageObjectManager.getLoginPage();
    }

    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page() throws Throwable {
        homepage.OpenLoginPage();
    }

    @When("^User logs in with \"(.*)\" and \"(.*)\"$")
    public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
        log.debug("type username");
        loginPage.setUserName(username);
        log.debug("type username");


        log.debug("type password");
        loginPage.setPassword(password);
        log.debug("type password");

        log.debug("click login button");
        loginPage.clickLoginButton();
        log.debug("click login button");
    }

    @Then("^User is redirected to the Dashboard page$")
    public void user_is_redirected_to_the_Dashboard_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        boolean result = loginPage.isUserLoggedIn();

        if(result){
            log.debug("Checking if user log in passed");
        }else{
            log.debug("User login");
            Assert.fail();
        }

    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() throws Throwable {
        log.debug("Logout application");
        homepage.logoutUser();
        log.debug("Logout application");
    }

    @Then("^User is redirected to the Login page$")
    public void user_is_redirected_to_the_Login_page() throws Throwable {
        log.debug("Logout application");
    }


    @After
    public void teardown() {
        testContext.getWebDriverManager().closeDriver();
    }


}
