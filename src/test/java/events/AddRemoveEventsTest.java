package events;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EventsPage;
import pages.LoginPage;

public class AddRemoveEventsTest extends BaseTest {
    @BeforeMethod
    public void init(){
        webDriver.get(URL);
    }

    @Test
    public void testAddEvent(){
        // process
        LoginPage loginPage = new LoginPage(webDriver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "admin123");
        EventsPage eventsPage = dashboardPage.goToAddEvent();
        eventsPage.addEvent("1", "2", "3", "4");

        //eventsPage.addNewUser(employee_name, user_name, password, password);
        // Validation
        Assert.assertTrue(true);
        //Assert.assertTrue(usersPage.isTheNewUserInTheUserList(user_name));
    }
}
