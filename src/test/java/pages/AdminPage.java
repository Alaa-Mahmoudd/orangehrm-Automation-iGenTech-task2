package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class AdminPage {

    WebDriver driver;
    WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By adminTab = By.xpath("//span[text()='Admin']");
    By records = By.xpath("//div[@class='oxd-table-card']");
    By addBtn = By.xpath("//button[normalize-space()='Add']");
    By saveBtn = By.xpath("//button[normalize-space()='Save']");

    // Form fields
    By userRoleDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[1]");
    By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    By statusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text-input')])[2]");
    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By passwordField = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");

    // Search & Delete
    By searchUsername = By.xpath("//label[text()='Username']/../following-sibling::div//input");
    By searchBtn = By.xpath("//button[normalize-space()='Search']");
    By deleteBtn = By.xpath("//button[contains(@class,'oxd-icon-button')]//i[contains(@class,'bi-trash')]");
    By confirmDelete = By.xpath("//button[normalize-space()='Yes, Delete']");
    By noRecords = By.xpath("//span[text()='No Records Found']");

    // Methods
    public void openAdminTab() {
        wait.until(ExpectedConditions.elementToBeClickable(adminTab)).click();
    }

    public int getRecordsCount() {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(records));
            return driver.findElements(records).size();
        } catch (TimeoutException e) {
            return 0;
        }
    }

    public void clickAdd() {
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
    }

    public void addUser(String userRole, String employeeName, String status, String username, String password) {

        // User Role
        driver.findElement(userRoleDropdown).click();
        By userRoleOption = By.xpath("//div[@role='option']//span[text()='" + userRole + "']");
        wait.until(ExpectedConditions.elementToBeClickable(userRoleOption)).click();

        // Employee Name
        driver.findElement(employeeNameInput).sendKeys(employeeName);
        By suggestion = By.xpath("//div[@role='listbox']//span[contains(text(),'" + employeeName + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(suggestion)).click();

        // Status
        driver.findElement(statusDropdown).click();
        By statusOption = By.xpath("//div[@role='option']//span[text()='" + status + "']");
        wait.until(ExpectedConditions.elementToBeClickable(statusOption)).click();

        // Username
        driver.findElement(usernameField).sendKeys(username);

        // Password
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);

        // Save
        driver.findElement(saveBtn).click();

        // wait for table refresh
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(records));
    }

    public void searchUser(String user) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(searchUsername));
        input.clear();
        input.sendKeys(user);
        driver.findElement(searchBtn).click();

        // wait for results
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(noRecords),
                ExpectedConditions.presenceOfAllElementsLocatedBy(records)
        ));
    }

    public void deleteUser() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmDelete)).click();

        // wait for table update after delete
        wait.until(ExpectedConditions.invisibilityOfElementLocated(confirmDelete));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(noRecords),
                ExpectedConditions.numberOfElementsToBe(records, 0)
        ));
    }

    public boolean isNoRecordsFoundVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noRecords));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}