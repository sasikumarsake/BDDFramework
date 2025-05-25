Feature: To Validate Registrtion Functionality in adactinHotel app

@Regression @wip103
Scenario Outline: To validate login using different combinations of inputs

Given user starts "chrome" browser
And user lauch app using url "https://adactinhotelapp.com/"
When user clicks on the link using xpath "//a[contains(text(),'New User Register Here')]"
Then user validates Title to be "Adactin.com - New User Registration"
When user enters details in new user registration form using mapping
| Username | Password | Confirm Password | Full Name | Email ID |
| KumarRanjan | Kumar123 | Kumar123 | kumarRanjan | kumar@gmail.com | 

And user enter captcha manually
#//And user enters text "INDIA" in textbox using xpath "//input[@name='captcha']"
And user clicks on the checkbox by using xpath "//input[@name='tnc_box']"
Then user clicks button using xpath "//input[@name='Submit']"