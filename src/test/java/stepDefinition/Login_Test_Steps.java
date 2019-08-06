package stepDefinition;

import MoneyAppTests.BaseClass;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import pages.Homepage;
import pages.LoginPage;
import properties.Application;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class Login_Test_Steps extends BaseClass {

    WebDriver driver;

    LoginPage loginPage;

    Logger log = Logger.getLogger("devpinoyLogger");



    @Given("^User is on Login Page$")
    public void user_is_on_Login_Page() throws Throwable {
        super.setup();
        this.driver = super.driver;
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        loginPage = new LoginPage(driver);

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
        Homepage homepage = new Homepage(driver);
        log.debug("Logout application");
        homepage.logoutUser();
        log.debug("Logout application");
    }

    @Then("^User is redirected to the Login page$")
    public void user_is_redirected_to_the_Login_page() throws Throwable {
        log.debug("Logout application");
        log.debug("Logout application");
    }


}
