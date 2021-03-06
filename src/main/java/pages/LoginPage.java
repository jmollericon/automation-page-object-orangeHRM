package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    // Locators
    private By userInput = By.id("txtUsername");
    private By passWordInput = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");


    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    // Actions
    public void typeUserName(String user){
        WebElement element = webDriver.findElement(userInput);
        element.clear();
        element.sendKeys(user);
    }

    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.clear();
        element.sendKeys(passWord);
    }

    public void clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        if (element!=null) {
            element.submit();
        }
    }

    public DashboardPage loginAs(String user, String passWord){
        typeUserName(user);
        typePassWord(passWord);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Valid 'username' and 'password' entered");
        clickOnLoginButton();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login was made");
        return new DashboardPage(webDriver);
    }

    public RetryLoginPage errorLoginAs(String user, String passWord){
        typeUserName(user);
        typePassWord(passWord);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Invalid 'username' and 'password' entered");
        clickOnLoginButton();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Error Login - Retry Login Page");
        return new RetryLoginPage(webDriver);
    }

    public boolean isLoginPageDisplayed(){
        return webDriver.findElement(loginButton).isDisplayed();
    }
}