package MoneyAppTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import properties.Application;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public WebDriver driver;


    public void setup(){
        try {
            String driverPath = "C:\\Classes\\geckodriver.exe";

            System.setProperty("webdriver.gecko.driver", driverPath);

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.manage().window().maximize();

            driver.get(Application.baseUrl);

        } catch (Exception ex) {
            Assert.fail(ex.getStackTrace()[0].getMethodName(), ex);
        }
    }

    public void teardown() {
        try {
            System.out.println("closing firefox browser");
            driver.quit();
        } catch (Exception ex) {
            Assert.fail(ex.getStackTrace()[0].getMethodName(), ex);
        }
    }

}