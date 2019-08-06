package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    Homepage homepage;

    By userName = By.id("username");
    By password = By.id("password");
    By loginButton = By.id("cmdLogin");
    By demoButton = By.id("demobutton");
    By signupButton = By.linkText("SignupPage");
    By logoutButton = By.linkText("Sign Out");
    By loginError = By.id("lbl_message");
    By userMenuButton = By.id("user_name");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setUserName(String strUserName) {
        driver.findElement(userName).sendKeys(strUserName);
    }

    //set password in textbox
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    //set password in textbox
    public void clickLoginButton() {

        driver.findElement(loginButton).click();


    }

    public boolean isUserLoggedIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void LoginUser(String username, String password) {

        this.setUserName(username);
        this.setPassword(password);
        this.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(logoutButton));


    }

    public void startDemo() {

        driver.findElement(demoButton).click();

    }

    public void goToSignUpNewUser() {

        driver.findElement(signupButton).click();


    }

}
