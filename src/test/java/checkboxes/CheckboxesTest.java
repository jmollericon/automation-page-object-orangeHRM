package checkboxes;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class CheckboxesTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL + "checkboxes");
    }

    @Test
    public void testCheck(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
    }

   @Test
    public void testUncheck(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
    }


}