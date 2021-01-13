package add_new_user;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.UsersPage;

public class AddNewUserTest extends BaseTest {
    @BeforeMethod
    public void init(){
         webDriver.get(URL);
    }

    @Test
    public void testSuccessfulAddNewUser(){
        // data new user
        String employee_name = "Amanda Cooper";
        String user_name = "cooper2021v2"; // change user_name
        String password = user_name+".123";
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        UsersPage usersPage = dashboardPage.goToAddNewUser();
        usersPage.addNewUser(employee_name, user_name, password, password);
        // validation
        Assert.assertTrue(usersPage.isTheNewUserInTheUserList(user_name));
    }
}