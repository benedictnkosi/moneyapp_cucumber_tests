package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage {
    WebDriver driver;

    By userName = By.name("register");
    By password = By.name("password");
    By confirmPassword = By.name("confirm");
    By submitButton = By.cssSelector("css=input[type='submit']");
    By loginButton = By.linkText("LoginPage");

    public SignupPage(WebDriver driver){
        this.driver = driver;
    }

    //Set user name in textbox

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    //set password in textbox
    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    //set password in textbox
    public void setConfirmPassword(String strPassword){
        driver.findElement(confirmPassword).sendKeys(strPassword);
    }

    //click login button
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    //click submit button
    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    //login to application
    public void signupNewUser(String strUserName,String strPasword, String strConfirmPasword){
        try{


        //Fill user name

        this.setUserName(strUserName);

        //Fill password

        this.setPassword(strPasword);

        //Fill confirm password

        this.setConfirmPassword(strConfirmPasword);

        //Click LoginPage button

        this.clickSubmit();
        }catch (Exception ex){
            Assert.fail(ex.getStackTrace()[0].getMethodName(),ex );
        }
    }
}
