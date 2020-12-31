package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage extends BasePage {

    // Locators
    private By dashboardPage = By.id("content");
    private By user_dropdown = By.id("user-dropdown");
    private By logoutLink = By.id("logoutLink");
    private By menu_content_elements = By.cssSelector("#menu-content li");


    public DashboardPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isDashboardPageDisplayed(){
        WebElement element = webDriver.findElement(dashboardPage);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Dashboard Page Displayed");
        return element.isDisplayed();
    }
    public String getFirstOptionMenuText(){
        List<WebElement> elements = webDriver.findElements(menu_content_elements); // all menu options
        WebElement firstElement = elements.get(0); // first option
        return firstElement.getText();
    }
    public DashboardPage clickOnUserDropDown(){
        webDriver.findElement(user_dropdown).click();
        return new DashboardPage(webDriver);
    }
    public LoginPage clickOnLogOutButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(logoutLink)));
        webDriver.findElement(logoutLink).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login Page");
        return new LoginPage(webDriver);
    }
}
