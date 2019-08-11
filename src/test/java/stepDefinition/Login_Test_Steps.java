package stepDefinition;

import MoneyAppTests.BaseClass;
import MoneyAppTests.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Homepage;
import pages.LoginPage;
import pages.PageObjectManager;
import utils.ConfigFileReader;

public class Login_Test_Steps extends BaseClass {

    WebDriver driver;
    ConfigFileReader configReader;
    WebDriverManager webDriverManager;
    PageObjectManager pageObjectManager;

    Homepage homepage;
    LoginPage loginPage;

    Logger log = Logger.getLogger("devpinoyLogger");

    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page() throws Throwable {
        webDriverManager = new WebDriverManager();
        configReader = new ConfigFileReader();

        driver = webDriverManager.getDriver();
        pageObjectManager = new PageObjectManager(driver);

        homepage = pageObjectManager.getHomePage();
        homepage.OpenLoginPage();
    }

    @When("^User logs in with \"(.*)\" and \"(.*)\"$")
    public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        loginPage = pageObjectManager.getLoginPage();

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
        // Write code here that turns the phrase above into concrete actions
        homepage = pageObjectManager.getHomePage();
        log.debug("Logout application");
        homepage.logoutUser();
        log.debug("Logout application");
    }

    @Then("^User is redirected to the Login page$")
    public void user_is_redirected_to_the_Login_page() throws Throwable {
        log.debug("Logout application");
        log.debug("Logout application");
    }


    @After
    public void teardown() {
        webDriverManager.closeDriver();
    }


}
