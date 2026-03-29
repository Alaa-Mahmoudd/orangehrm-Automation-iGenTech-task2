package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        Assert.assertTrue(login.isAdminTabVisible(), "Login Failed");
    }
}