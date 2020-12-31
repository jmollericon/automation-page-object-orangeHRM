package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL + "login");
    }

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
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