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

    private By successMesage = By.id("toast-container");
    private By job_category_list = By.cssSelector(".list-container table > tbody tr");
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
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Option: Job category ok");
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
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Option: Job category ok");

        List<WebElement> elements = webDriver.findElements(job_category_list);
        //System.out.println("numero elementos "+elements.size());
        WebElement edit_button;
        for (WebElement user : elements) {
            WebElement element = user.findElement(job_category_name_list);
            if(element.getText().equals(job_category_name)) {
                System.out.println(element.getText()+"=?="+job_category_name);
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

}