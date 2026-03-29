🟠 OrangeHRM Automation – iGenTech Task 2


📄 Project Overview
This project is an automated test suite for the OrangeHRM web application, focused on UI automation for the Admin module using Selenium WebDriver and TestNG.


The suite tests user management operations such as:
➕ Adding users
🔍 Searching users
❌ Deleting users

The project follows the Page Object Model (POM) pattern for maintainable and reusable code.


🛠 Tools & Dependencies
Java 25 – Programming language for automation scripts
Selenium WebDriver 4.41 – Browser automation framework
TestNG 7.9 – Testing framework for running tests and assertions
Maven – Dependency and project management
ChromeDriver – Browser driver for Google Chrome (ensure it matches your Chrome version)
Git & GitHub – Version control and repository management


📝 Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/Alaa-Mahmoudd/orangehrm-Automation-iGenTech-task2.git
cd orangehrm-Automation-iGenTech-task2
2️⃣ Install Dependencies

The project uses Maven. To download all required dependencies:

mvn clean install
3️⃣ Set Up ChromeDriver
Download the ChromeDriver version matching your installed Chrome browser
Place it in a directory and add it to your system PATH
Alternatively, update the ChromeDriver path in your test setup if needed
4️⃣ Configure Browser & Login
Open LoginPage.java
Make sure the Admin username and password match your OrangeHRM credentials
▶️ How to Run Tests
Run All Tests
mvn test
Run a Specific Test Class
mvn -Dtest=tests.AdminTest test
Run Using TestNG XML (Optional)

If using a TestNG XML file:

mvn -DsuiteXmlFile=testng.xml test
📊 Test Reporting

Reports include:

✅ Passed tests
❌ Failed tests
⏱ Execution time
📌 Assertion results


⚠️ Notes
Ensure Chrome browser and ChromeDriver versions match
Maintain a stable internet connection for OrangeHRM access
Follow the Page Object Model (POM) structure for creating additional tests
