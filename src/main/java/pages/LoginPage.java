package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    // Locators
    private By userInput = By.id("txtUsername");
    private By passWordInput = By.id("txtPassword");
    private By loginButton = By.id("btnLogin");
    private By errorMessage = By.name("errorMessage");

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
        clickOnLoginButton();
        return new DashboardPage(webDriver);
    }


    /*public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }*/

    public boolean isLoginPageDisplayed(){
        return webDriver.findElement(loginButton).isDisplayed();
    }
}