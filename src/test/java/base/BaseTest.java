package base;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import report.ReportManager;
import utils.OSValidator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    protected WebDriver webDriver;
    protected final String URL = "https://orangehrm-demo-6x.orangehrmlive.com/";
    private final String DEFAULT_BROWSER = "chrome";

    /* Inicializar la ruta del reporte */
    @BeforeSuite
    public static void setUpSuite() throws Exception {
        Properties prop = new Properties();
        InputStream is = null;

        try {
            is = new FileInputStream("resources/config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        ReportManager.init(prop.getProperty("ruta.so"), "Report");
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional(DEFAULT_BROWSER) String browser, ITestResult iTestResult) throws Exception {
        String operatingSystem = OSValidator.isMac() ? "-mac" : OSValidator.isUnix() ? "-linux" : ".exe";
        // Report
        ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());
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

    /*public void tearDown(){
        //if(webDriver != null)
            //webDriver.quit();
    }*/

    @AfterMethod // Configuración para reportes
    public void tearDown(ITestResult iTestResult) {
        try {
            switch (iTestResult.getStatus()) {
                case ITestResult.FAILURE:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if (iTestResult.getStatus() != ITestResult.FAILURE && iTestResult.getThrowable() != null) {
                ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            int a=0;
            /*if (webDriver != null)
                webDriver.quit();*/
        }

    }

    // Para generar los reportes
    @AfterSuite
    public static void tearDownSuite() {
        ReportManager.getInstance().flush();
    }
}
