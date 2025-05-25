Feature: To Validate Registrtion Functionality in adactinHotel app

@Regression @wip101
Scenario Outline: To validate login using different combinations of inputs

Given user starts "chrome" browser
And user lauch app using url "https://adactinhotelapp.com/"
When user clicks on the link using xpath "//a[contains(text(),'New User Register Here')]"
Then user validates Title to be "Adactin.com - New User Registration"
When user enters text "KumarRanjan" in textbox using xpath "//input[@name='username']"
And user enters text "Kumar123" in textbox using xpath "//input[@name='password']"
And user enters text "Kumar123" in textbox using xpath "//input[@id='re_password']"
And user enters text "KumarRanjan" in textbox using xpath "//input[@name='full_name']"
And user enters text "kumar@gmail.com" in textbox using xpath "//input[@name='email_add']"
And user enter captcha manually
#//And user enters text "INDIA" in textbox using xpath "//input[@name='captcha']"
And user clicks on the checkbox by using xpath "//input[@name='tnc_box']"
Then user clicks button using xpath "//input[@name='Submit']"
And user waiting some seconds