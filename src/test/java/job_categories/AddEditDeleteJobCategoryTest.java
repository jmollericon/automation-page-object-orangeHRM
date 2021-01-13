package job_categories;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.JobCategoriesPage;
import pages.LoginPage;
import pages.UsersPage;

public class AddEditDeleteJobCategoryTest extends BaseTest {
    // data
    static String job_category_name = "example4";
    static String job_category_new_name = "example4 updated";

    @BeforeMethod
    public void init(){
         webDriver.get(URL);
    }

    @Test
    public void test1AddNewJobCategory(){
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        JobCategoriesPage jobCategoriesPage = dashboardPage.goToJobCategory();
        jobCategoriesPage.addNewJobCategory(job_category_name);
        // validation
        Assert.assertTrue(jobCategoriesPage.isTheJobCategoryInTheJobCategoryList(job_category_name));
    }

    @Test
    public void test2EditJobCategory(){
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        JobCategoriesPage jobCategoriesPage = dashboardPage.goToJobCategory();
        // edit previously created job category (previous test)
        jobCategoriesPage.editJobCategory(job_category_name, job_category_new_name);
        // validation
        Assert.assertTrue(jobCategoriesPage.isTheJobCategoryInTheJobCategoryList(job_category_new_name));
    }
    @Test
    public void test3DeleteJobCategory(){
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        JobCategoriesPage jobCategoriesPage = dashboardPage.goToJobCategory();
        // delete previously updated job category (previous test)
        jobCategoriesPage.deleteJobCategory(job_category_new_name);
        // validation
        Assert.assertTrue(jobCategoriesPage.isNotTheJobCategoryInTheJobCategoryList(job_category_new_name));
    }
}