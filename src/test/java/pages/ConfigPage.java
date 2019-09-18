package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigFileReader;


public class ConfigPage {
    WebDriver driver;

    By categoryDropDown = By.id("select_categories");
    By transactionNameField = By.id("textTrasnctionName");
    By captureForm = By.id("transaction_form");
    By messageLabel = By.id("lbl_message");
    ConfigFileReader configReader;

    public ConfigPage(WebDriver driver){
        this.driver = driver;
        configReader = new ConfigFileReader();
    }

    public void selectCategory(String strCategoryName) {

            Select drpCategory = new Select(driver.findElement(categoryDropDown));
            drpCategory.selectByVisibleText(strCategoryName);

    }

    public void checkOutputMessage(String message) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(messageLabel), message));

    }


    public void checkTransactionIsAdded(String transactionName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By transactionItem = By.linkText(transactionName);
        wait.until(ExpectedConditions.presenceOfElementLocated(transactionItem));

    }


    public void checkTransactionIsRemoved(String transactionName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By transactionItem = By.linkText(transactionName);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(transactionItem,1));
    }



    public void setTransactionName(String strTransactionName ) {
        driver.findElement(transactionNameField).clear();
        driver.findElement(transactionNameField).sendKeys(strTransactionName);
    }


    public void submitNewCustomTransactionForm() {
            driver.findElement(captureForm).submit();
    }


    public void CreateNewCustomTransaction(String category, String transactionName){

            this.selectCategory(category);
            this.setTransactionName(transactionName);
            this.submitNewCustomTransactionForm();

            WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(messageLabel), configReader.getPropertyByName("msg_success_create_custom_transaction")));


    }

    public void clickDeleteButtonOnTransaction(String transactionName) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + transactionName +"')]/i"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        element.click();
    }

    public void deleteCustomTransaction(String category, String transactionName) throws InterruptedException {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + transactionName +"')]/i"));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            element.click();

            WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(messageLabel), configReader.getPropertyByName("msg_success_delete_custom_transaction")));
    }




}
