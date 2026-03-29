package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;

import java.util.UUID;

public class AdminTest extends BaseTest {

    @Test
    public void fullScenarioTest() {

        LoginPage login = new LoginPage(driver);
        AdminPage admin = new AdminPage(driver);

        String username = "User" + UUID.randomUUID().toString().substring(0,5);
        String password = "Admin@123";
        String userRole = "ESS";
        String employeeName = "John";
        String status = "Enabled";

        // Login
        login.login("Admin", "admin123");
        Assert.assertTrue(login.isAdminTabVisible(), "Login Failed");

        // Open Admin tab
        admin.openAdminTab();

        // Count before add
        int before = admin.getRecordsCount();

        // Add user
        admin.clickAdd();
        admin.addUser(userRole, employeeName, status, username, password);

        // Verify total increased
        int afterAddTotal = admin.getRecordsCount();
        Assert.assertEquals(afterAddTotal, before + 1, "Record count should increase by 1");

        // Search new user
        admin.searchUser(username);
        Assert.assertEquals(admin.getRecordsCount(), 1, "User should appear in search");

        // Delete user
        admin.deleteUser();

        // Search deleted user
        admin.searchUser(username);


        Assert.assertEquals(admin.getRecordsCount(), 0, "User should be deleted");

        // Verify total returned to original
        admin.openAdminTab(); // refresh list
        int afterDelete = admin.getRecordsCount();
        Assert.assertEquals(afterDelete, before, "Record count should return to original");
    }
}