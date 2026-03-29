package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Config;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver("chrome");
        driver.get(Config.BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}