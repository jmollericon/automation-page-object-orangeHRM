package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL + "login");
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
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
    }

    @Test
    public void testLogOut(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertTrue(true);
    }
}