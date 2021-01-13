package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UsersPage extends BasePage {

    // Locators
    private By add_new_user_button = By.cssSelector("#systemUserDiv > div > a");
    private By employee_name_input = By.id("selectedEmployee_value");
    private By angucomplete_text = By.id("angucomplete-title-temp-id");

    private By user_name_input = By.id("user_name");
    private By password_input = By.id("password");
    private By confirm_password_input = By.id("confirmpassword");
    private By save_user_button = By.id("systemUserSaveBtn");
    private By users_list = By.cssSelector(".list-container table > tbody tr");
    private By user_name_list = By.xpath("td[2]");
    private By successMesage = By.id("toast-container");

    public UsersPage(WebDriver webDriver){
        super(webDriver);
    }

    public UsersPage clickOnAddNewUser(){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        //wait.until(ExpectedConditions.elementToBeClickable(add_new_user_button));
        wait.until(ExpectedConditions.elementToBeClickable(users_list)); // wait for the user list - ok
        webDriver.findElement(add_new_user_button).click();
        return new UsersPage(webDriver);
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
    public void addNewUser(String employee_name, String user_name, String password, String confirm_password){
        clickOnAddNewUser();
        fillOutFormAddNewUser(employee_name, user_name, password, confirm_password);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form new user filled");
        clickOnSaveNewUser();
    }
    public boolean isTheNewUserInTheUserList(String user_name_new_user){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(successMesage)); // wait for the user list whit the new user
        List<WebElement> elements = webDriver.findElements(users_list);
        //System.out.println("numero elementos "+elements.size());
        for (WebElement user : elements) {
            WebElement element = user.findElement(user_name_list);
            //System.out.println(element.getText()+"=?="+user_name_new_user);
            if(element.getText().equals(user_name_new_user)) {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Message: Successfully Saved and User list with the new user");
                return true;
            }
        }
        return false;
    }
}
