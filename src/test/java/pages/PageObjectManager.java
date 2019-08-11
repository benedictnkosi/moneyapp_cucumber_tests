package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private BudgetPage budgetPage;
    private ConfigPage configPage;
    private Homepage homepage;
    private LoginPage loginPage;
    private SignupPage signupPage;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public Homepage getHomePage() {

        return (homepage == null) ? homepage = new Homepage(driver) : homepage;

    }

    public BudgetPage getBudgetPage() {

        return (budgetPage == null) ? budgetPage = new BudgetPage(driver) : budgetPage;

    }

    public ConfigPage getConfigPage() {

        return (configPage == null) ? configPage = new ConfigPage(driver) : configPage;

    }

    public LoginPage getLoginPage() {

        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;

    }

    public SignupPage getSignUpPage() {

        return (signupPage == null) ? signupPage = new SignupPage(driver) : signupPage;

    }

}
