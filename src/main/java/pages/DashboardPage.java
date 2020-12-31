package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        //ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Display");
        return element.isDisplayed();
    }
    public String getFirstOptionMenuText(){
        List<WebElement> elements = webDriver.findElements(menu_content_elements); // all menu options
        WebElement firstElement = elements.get(0); // first option
        return firstElement.getText();
    }

}
