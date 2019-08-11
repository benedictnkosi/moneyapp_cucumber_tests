package MoneyAppTests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import utils.ConfigFileReader;

import java.util.concurrent.TimeUnit;


public class BaseClass {

    public WebDriver driver;
    ConfigFileReader configReader = new ConfigFileReader();

    public void setup(){
        try {
            String driverPath = "C:\\Classes\\geckodriver.exe";

            System.setProperty("webdriver.gecko.driver", driverPath);

            driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.manage().window().maximize();

            driver.get(configReader.getApplicationUrl());

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