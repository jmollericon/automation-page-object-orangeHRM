package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage extends BasePage {

    //TODO Locators
    private By userInput = By.id("username");
    private By passWordInput = By.id("password");
    private By loginButton = By.id("loginButton");
    private By errorMessage = By.name("errorMessage");


    public AddRemoveElementsPage(WebDriver webDriver){
        super(webDriver);
    }

    //TODO Actions
    /*
    public void typeUserName(String user){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(user);
    }

    public void typePassWord(String passWord){
        WebElement element = webDriver.findElement(passWordInput);
        element.sendKeys(passWord);
    }

    public void clickOnLoginButton(){
        WebElement element = webDriver.findElement(loginButton);
        if (element!=null) {
            element.submit();
        }
    }

    public void loginAs(String user, String passWord){
        typeUserName(user);
        typePassWord(passWord);
        clickOnLoginButton();
    }


    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 3);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean isLoginPageDisplayed(){
        return webDriver.findElement(loginButton).isDisplayed();
    }*/
}