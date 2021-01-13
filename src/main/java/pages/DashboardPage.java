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
    private By menu_admin_module = By.id("menu_admin_viewAdminModule");
    private By user_management = By.id("menu_admin_UserManagement");
    private By view_users = By.id("menu_admin_viewSystemUsers");
    private By menu_on_boarding = By.id("menu_onboarding_defaultMenuView");
    private By view_jobs = By.id("menu_onboarding_viewJobs");



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
    public void clickOnMenuAdminModule() {
        webDriver.findElement(menu_admin_module).click();
    }
    public void clickOnUserManagement() {
        webDriver.findElement(user_management).click();
    }
    public void clickOnViewUsers() {
        webDriver.findElement(view_users).click();
    }
    public UsersPage goToAddNewUser() {
        clickOnMenuAdminModule();
        clickOnUserManagement();
        clickOnViewUsers();
        return new UsersPage(webDriver);
    }
    public void clickOnMenuOnBoarding() {
        webDriver.findElement(menu_on_boarding).click();
    }
    public void clickOnMenuOnBoardingViewJobs() {
        webDriver.findElement(view_jobs).click();
    }
    public EventsPage goToAddEvent() {
        clickOnMenuOnBoarding();
        clickOnMenuOnBoardingViewJobs();
        return new EventsPage(webDriver);
    }
}
