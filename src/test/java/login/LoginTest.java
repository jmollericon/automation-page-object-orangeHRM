package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RetryLoginPage;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL);
    }

    @Test
    public void testSuccessfulAdminLogin(){
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
        Assert.assertEquals(dashboardPage.getFirstOptionMenuText(), "Admin");
    }

    @Test
    public void testInvalidCredentials(){
        LoginPage loginPage = new LoginPage(webDriver);
        RetryLoginPage retryLoginPage = loginPage.errorLoginAs("admin", "admin");
        Assert.assertTrue(retryLoginPage.isRetryLoginPageDisplayed());
        Assert.assertTrue(retryLoginPage.isErrorMessageVisible());
    }

    @Test
    public void testValidCredentialsButNotAdmin(){
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("linda", "linda.anderson");
        Assert.assertTrue(dashboardPage.isDashboardPageDisplayed());
        Assert.assertNotEquals(dashboardPage.getFirstOptionMenuText(), "Admin");
    }

    @Test
    public void testLogOut(){
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        dashboardPage = dashboardPage.clickOnUserDropDown();
        loginPage = dashboardPage.clickOnLogOutButton();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}