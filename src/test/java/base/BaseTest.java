package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.OSValidator;

public class BaseTest {
    protected WebDriver webDriver;
    protected final String URL = "https://the-internet.herokuapp.com/";
    private final String DEFAULT_BROWSER = "chrome";

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional(DEFAULT_BROWSER) String browser) throws Exception {
        String operatingSystem = OSValidator.isMac() ? "-mac" : OSValidator.isUnix() ? "-linux" : ".exe";

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver","resources/chromedriver" + operatingSystem);
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","resources/geckodriver" + operatingSystem);
                webDriver = new FirefoxDriver();
                break;
            default:
                throw new Exception(browser + " Does not supported");
        }
    }

    @AfterMethod
    public void tearDown(){
        if(webDriver != null)
            webDriver.quit();
    }
}
