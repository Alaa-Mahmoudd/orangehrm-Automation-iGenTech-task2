package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By adminTab = By.xpath("//span[text()='Admin']");

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isAdminTabVisible() {
        return wait.until(d -> d.findElement(adminTab).isDisplayed());
    }
}