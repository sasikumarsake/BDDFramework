Feature: To Validate Login Functionality in orangehrmlive app

Scenario: To validate login using valid crendentials

Given user starts "chrome" browser
And user lauch app using url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When user enters text "Admin" in textbox using xpath "//input[@name='username']"
And user enters text "admin123" in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//button[@type='submit']"
Then user validates the profilepicture using xpath "//span/img[@alt='profile picture' and contains(@src,'viewPhoto/empNumber')]"