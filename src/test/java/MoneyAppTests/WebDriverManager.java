package MoneyAppTests;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private WebDriver driver;
    private ConfigFileReader configReader;

    public WebDriverManager() {
        configReader = new ConfigFileReader();
        driverType = configReader.getBrowser();
        environmentType = configReader.getEnvironment();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER_PROPERTY, this.configReader.getFirefoxDriverPath());
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, this.configReader.getChromeDriverPath());
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }

        if (this.configReader.getBrowserWindowSize()) driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(this.configReader.getImplicitlyWait(), TimeUnit.SECONDS);

        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
