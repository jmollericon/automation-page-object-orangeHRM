package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RetryLoginPage extends BasePage {

    // Locators
    private By divContent = By.id("divContent");
    private By errorMessage = By.id("toast-container");

    public RetryLoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isRetryLoginPageDisplayed(){
        WebElement element = webDriver.findElement(divContent);
        //ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Display");
        return element.isDisplayed();
    }

    public boolean isErrorMessageVisible(){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 5);
            wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(errorMessage)));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
