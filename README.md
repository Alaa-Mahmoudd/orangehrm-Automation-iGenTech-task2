OrangeHRM Automation – iGenTech Task 2
Project Overview :
This project is an automated test suite for the OrangeHRM web application, focused on UI automation for the Admin module using Selenium WebDriver and TestNG.
The suite tests user management operations such as adding, searching, and deleting users. It uses the Page Object Model (POM) pattern for maintainable and reusable code.

Tools & Dependencies :
Java 25 – Programming language for automation scripts.
Selenium WebDriver 4.41 – Browser automation framework.
TestNG 7.9 – Testing framework for running tests and assertions.
Maven – Dependency and project management.
ChromeDriver – Browser driver for Google Chrome. Ensure it matches your Chrome version.
Git & GitHub – Version control and repository management.
Setup Instructions :
1. Clone the Repository
git clone https://github.com/Alaa-Mahmoudd/orangehrm-Automation-iGenTech-task2.git
cd orangehrm-Automation-iGenTech-task2

3. Install Dependencies
The project uses Maven. To download all required dependencies:
mvn clean install

4. Set Up ChromeDriver
Download the ChromeDriver version matching your installed Chrome browser.
Place it in a directory and add it to your system PATH.
Alternatively, update the path to ChromeDriver in your test setup if needed.

6. Configure Browser & Login
Open LoginPage.java and ensure the Admin username and password match your OrangeHRM credentials.
How to Run Tests
Run All Tests
mvn test
Run a Specific Test Class
mvn -Dtest=tests.AdminTest test
Run with TestNG XML (Optional)
If using a TestNG XML file:
mvn -DsuiteXmlFile=testng.xml test
Test Reporting : 
Reports show passed/failed tests, execution time, and assertion results.
Notes
Make sure the Chrome browser and ChromeDriver versions match.
Ensure a stable internet connection for accessing the OrangeHRM application.
Follow the Page Object Model structure for any additional test creation.
