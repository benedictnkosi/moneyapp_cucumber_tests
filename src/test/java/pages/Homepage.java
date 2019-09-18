package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigFileReader;

public class Homepage {
    WebDriver driver;
    ConfigFileReader configReader;

    By homeMenu = By.cssSelector("css=a[href='index.html']");

    By TransactionsMenu = By.cssSelector("css=a[href='transactions.html']");
    By accountsMenu = By.cssSelector("css=a[href='accounts.html']");
    By socialMenu = By.cssSelector("css=a[href='social.html']");
    By homeHeading = By.xpath("//*[@id=\"BudgetPage-graphs\"]/div[1]/h3");


    //user menu
    By userMenuButton = By.id("user_name");
    By logoutMenu = By.id("signout");
    By configMenu = By.linkText("Config");
    By budgetMenu = By.linkText("Budget");


    public Homepage(WebDriver driver) {
        this.driver = driver;
    }


    //click login button
    public void logoutUser() {

            driver.findElement(userMenuButton).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(logoutMenu)).click();

    }

    //Get the User name from Home Page

    public String getHomePageHeading() {
        return driver.findElement(homeHeading).getText();
    }


    public void OpenConfigPage() {

            driver.findElement(userMenuButton).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(configMenu)).click();

    }


    //homePage.navigateTo_HomePage();
    public void OpenLoginPage() {
        configReader = new ConfigFileReader();
        driver.get(configReader.getApplicationUrl());
    }

    public void OpenBudgetPage() {

            driver.findElement(userMenuButton).click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(budgetMenu)).click();

    }


    public void teardown() {
        driver.quit();
    }


}
