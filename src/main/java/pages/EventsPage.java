package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Predicate;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class EventsPage extends BasePage {

    // Locators
    private By preloader = By.id("preloader");
    private By add_event_button = By.id("list_item_add");
    private By help_button = By.id("stickyHelpButton");
    private By content_event = By.cssSelector("#TestList");

    private By employee_name_input = By.id("selectedEmployee_value");
    private By angucomplete_text = By.id("angucomplete-title-temp-id");

    private By user_name_input = By.id("user_name");
    private By password_input = By.id("password");
    private By confirm_password_input = By.id("confirmpassword");
    private By save_user_button = By.id("systemUserSaveBtn");
    private By users_list = By.cssSelector("#tableWrapper table > tbody tr");
    private By events_table = By.id("resultTable");
    private By user_name_list = By.xpath("td[2]");
    private By successMesage = By.id("toast-container");

    public EventsPage(WebDriver webDriver){
        super(webDriver);
    }

    public EventsPage clickOnAddEvent(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Events Page");

        //WebDriverWait wait = new WebDriverWait(webDriver, 30);
        //wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(content_event)));
        //wait.until(ExpectedConditions.elementToBeClickable(add_event_button)); // wait for the events list - ok

        // wait for
        WebDriverWait wait = new WebDriverWait(webDriver, 60);
        wait.until(ExpectedConditions.invisibilityOf(webDriver.findElement(preloader)));

        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Events Page 2");

        //WebDriverWait wait2 = new WebDriverWait(webDriver, 30);
        //wait2.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(help_button)));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "before click");
        webDriver.findElement(help_button).click();
        //wait2.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(add_event_button)));
        //wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(add_event_button)));

        //webDriver.findElement(add_event_button).click();
        return new EventsPage(webDriver);
    }
    public void typeEmployeeName(String employee_name) {
        webDriver.findElement(employee_name_input).sendKeys(employee_name);
    }
    public void typeUserName(String user_name) {
        webDriver.findElement(user_name_input).sendKeys(user_name);
    }
    public void typePassword(String user_name) {
        webDriver.findElement(password_input).sendKeys(user_name);
    }
    public void typeConfirmPassword(String user_name) {
        webDriver.findElement(confirm_password_input).sendKeys(user_name);
    }
    public void clickOnSaveNewUser(){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(save_user_button));
        webDriver.findElement(save_user_button).click();
    }
    public void fillOutFormAddNewUser(String employee_name, String user_name, String password, String confirm_password) {
        // wait for the form
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(employee_name_input));
        // fill out the form
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form new user");
        typeEmployeeName(employee_name);
        wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(angucomplete_text));
        typeUserName(user_name);
        typePassword(password);
        typeConfirmPassword(confirm_password);
    }
    public void addEvent(String name, String location, String due_date, String data){
        clickOnAddEvent();

        //fillOutFormAddNewUser(employee_name, user_name, password, confirm_password);
        //ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form new user filled");
        //clickOnSaveNewUser();
    }
    public boolean isTheNewUserInTheUserList(String user_name_new_user){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(successMesage)); // wait for the user list whit the new user
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Message: Successfully Saved and User list with the new user");
        List<WebElement> elements = webDriver.findElements(users_list);
        //System.out.println("numero elementos "+elements.size());
        for (WebElement user : elements) {
            WebElement element = user.findElement(user_name_list);
            //System.out.println(element.getText()+"=?="+user_name_new_user);
            if(element.getText().equals(user_name_new_user)) {
                return true;
            }
        }
        return false;
    }
}
