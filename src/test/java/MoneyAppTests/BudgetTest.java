package MoneyAppTests;

import DTO.BudgetDTO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BudgetPage;
import pages.Homepage;
import pages.LoginPage;
import properties.Application;

public class BudgetTest extends BaseClass {

    public WebDriver driver;

    @Test(dataProvider = "BudgetProvider", dataProviderClass = DataProvider.class)
    public void runBudgetTestCases(String testCaseName, BudgetDTO budgetDTO) {
        try {
            /*System.out.println("running custom transaction name test case");

            LoginPage loginPage = new LoginPage(driver);

            Homepage homePage = new Homepage(driver);

            BudgetPage budgetPage = new BudgetPage(driver);

            if (testCaseName != null) {
                System.out.println(budgetDTO.getTestCaseName());

                driver.get(Application.baseUrl);

                loginPage.LoginUser(budgetDTO.getUsername(), budgetDTO.getPassword());

                homePage.OpenBudgetPage();

                budgetPage.addNewBudgetItem(budgetDTO.getCategory(), budgetDTO.getTransactionName());
            }*/
        } catch (Exception ex) {
            Assert.fail(ex.getStackTrace()[0].getMethodName(), ex);
        }
    }

}
