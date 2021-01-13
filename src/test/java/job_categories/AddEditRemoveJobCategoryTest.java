package job_categories;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.JobCategoriesPage;
import pages.LoginPage;
import pages.UsersPage;

public class AddEditRemoveJobCategoryTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL);
    }

    @Test
    public void testAddJobCategory(){
        // data
        String job_category_name = "example2";
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        JobCategoriesPage jobCategoriesPage = dashboardPage.goToJobCategory();
        jobCategoriesPage.addNewJobCategory(job_category_name);
        // validation
        Assert.assertTrue(jobCategoriesPage.isTheNewJobCategoryInTheJobCategoryList(job_category_name));
    }
}