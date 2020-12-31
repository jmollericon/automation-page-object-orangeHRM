package elements;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddRemoveElementsTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL + "add_remove_elements/");
    }

    @Test
    public void testAddElement(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
    }

   @Test
    public void testRemoveElement(){
        LoginPage loginPage = new LoginPage(webDriver);
        //TODO ADD Logic
        Assert.assertEquals("test", "test");
    }


}