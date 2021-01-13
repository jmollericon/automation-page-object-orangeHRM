package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class JobCategoriesPage extends BasePage {

    // Locators
    private By add_new_job_category_button = By.cssSelector("#jobcategoryDiv > div > a > i");
    private By list_container = By.cssSelector(".list-container");

    private By job_category_name_input = By.id("name");
    private By save_button = By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[1]");
    private By cancel_button = By.xpath("//*[@id=\"modal1\"]/form/div[2]/a[2]");
    private By options_button = By.xpath("//*[@id=\"jobcategoryDiv\"]/crud-panel/div/div/list/table/thead/tr/th[1]/a/i");
    private By delete_selected_option = By.xpath("//*[@id=\"listdirective-options-dropdown-list0-action-deleteSelection}\"]/a");
    private By delete_button = By.xpath("//*[@id=\"delete_confirmation_modal\"]/div[2]/a[2]");

    private By successMesage = By.id("toast-container");
    private By job_category_list = By.cssSelector(".list-container table > tbody tr");
    private By job_category_checkbox_list = By.xpath("td[1]");
    private By job_category_name_list = By.xpath("td[2]");
    private By job_category_edit_button_list = By.xpath("td[3]");

    private By option_menu = By.cssSelector(".list-options");

    public JobCategoriesPage(WebDriver webDriver){
        super(webDriver);
    }

    public void clickOnAddNewJobCategory(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Option: Job category");
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(list_container));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Job category list");
        webDriver.findElement(add_new_job_category_button).click();
    }
    public void typeJobCategoryName(String job_category_name) {
        webDriver.findElement(job_category_name_input).clear(); // clean text input
        webDriver.findElement(job_category_name_input).sendKeys(job_category_name);
    }
    public void clickOnSaveJobCategory(){
        webDriver.findElement(save_button).click();
    }
    public void fillOutFormAddNewJobCategory(String job_category_name) {
        // wait for the form
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(job_category_name_input));
        // fill out the form
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form add new job category");
        typeJobCategoryName(job_category_name);
    }
    public void addNewJobCategory(String job_category_name){
        clickOnAddNewJobCategory();
        fillOutFormAddNewJobCategory(job_category_name);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form add new job category filled");
        clickOnSaveJobCategory();
    }

    // functions test 2
    public void findAndClickOnEditJobCategory(String job_category_name){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Option: Job category");
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(list_container));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Job category list");

        List<WebElement> elements = webDriver.findElements(job_category_list);
        //System.out.println("numero elementos "+elements.size());
        WebElement edit_button;
        for (WebElement user : elements) {
            WebElement element = user.findElement(job_category_name_list);
            if(element.getText().equals(job_category_name)) {
                //System.out.println(element.getText()+"=?="+job_category_name);
                edit_button = user.findElement(job_category_edit_button_list);
                edit_button.click();
            }
        }
    }
    public void fillOutFormWithTheNewJobCategoryName(String job_category_new_name) {
        // wait for the form
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(job_category_name_input));
        // fill out the form
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form, edit job category name");
        typeJobCategoryName(job_category_new_name);
    }
    public void editJobCategory(String job_category_name, String job_category_new_name){
        findAndClickOnEditJobCategory(job_category_name);
        fillOutFormWithTheNewJobCategoryName(job_category_new_name);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Form edit job category filled");
        clickOnSaveJobCategory();
    }
    // validation
    public boolean isTheJobCategoryInTheJobCategoryList(String job_category_name){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(successMesage)); // wait for the job category list whit the new job category
        List<WebElement> elements = webDriver.findElements(job_category_list);
        //System.out.println("numero elementos "+elements.size());
        for (WebElement user : elements) {
            WebElement element = user.findElement(job_category_name_list);
            //System.out.println(element.getText()+"=?="+job_category_name);
            if(element.getText().equals(job_category_name)) {
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Message: Successfully Saved/Updated and '"+job_category_name+"' is in the job category list");
                return true;
            }
        }
        return false;
    }

    // functions test 3
    public void findAndSelectJobCategory(String job_category_name){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Option: Job category");
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(list_container));
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Job category list");

        List<WebElement> elements = webDriver.findElements(job_category_list);
        //System.out.println("numero elementos "+elements.size());
        WebElement job_category_checkbox;
        for (WebElement user : elements) {
            WebElement element = user.findElement(job_category_name_list);
            if(element.getText().equals(job_category_name)) {
                //System.out.println(element.getText()+"=?="+job_category_name);
                job_category_checkbox = user.findElement(job_category_checkbox_list);
                job_category_checkbox.click();
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Job category found and selected");
            }
        }
    }
    public void clickOnOptionsButton(){
        webDriver.findElement(options_button).click();
    }
    public void clickOnDeleteSelectedOption(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(delete_selected_option)); // wait for the option
        webDriver.findElement(delete_selected_option).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Delete Selected Option");
    }
    public void clickOnYesDeleteJobCategory(){
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(delete_button)); // wait for the modal to delete
        webDriver.findElement(delete_button).click();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Delete Job Category (YES, DELETE)");
    }
    public void deleteJobCategory(String job_category_name){
        findAndSelectJobCategory(job_category_name);
        clickOnOptionsButton();
        clickOnDeleteSelectedOption();
        clickOnYesDeleteJobCategory();
    }
    public boolean isNotTheJobCategoryInTheJobCategoryList(String job_category_name){
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(successMesage)); // wait for the message
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Message: Successfully Deleted");
        WebDriverWait wait2 = new WebDriverWait(webDriver, 30);
        wait2.until(ExpectedConditions.invisibilityOf(webDriver.findElement(successMesage)));
        List<WebElement> elements = webDriver.findElements(job_category_list);
        //System.out.println("numero elementos "+elements.size());
        for (WebElement user : elements) {
            WebElement element = user.findElement(job_category_name_list);
            //System.out.println(element.getText()+"=?="+job_category_name);
            if(element.getText().equals(job_category_name)) {
                return false;
            }
        }
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "'"+job_category_name+"' isn't in the job category list");
        return true;
    }
}