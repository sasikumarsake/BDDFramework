Feature: To Validate Login Functionality in adactinHotel app

Scenario Outline: To validate login using different combinations of inputs

Given user starts "chrome" browser
And user lauch app using url "https://adactinhotelapp.com/"
When user enters text '<username>' in textbox using xpath "//input[@name='username']"
And user enters text '<password>' in textbox using xpath "//input[@name='password']"
And user clicks button using xpath "//input[@name='login']"
Then user validates Title to be '<expTitle>'




Examples:   

| username	| password | expTitle |
| Sashikumar | Sashikumar@47 | Adactin.com - Search Hotel |
| Sashikumar | Sashikumartiu | Adactin.com - Hotel Reservation System |
| Sashik | Sashikumar@47 | Adactin.com - Hotel Reservation System |
| Sashikumasdsr | Sashikumartidfu | Adactin.com - Hotel Reservation System |