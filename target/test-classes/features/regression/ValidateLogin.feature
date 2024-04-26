Feature: To validate login functionality

@smoke
Scenario: To validate login using valid credentials 

Given user is starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text "reyaz0806" into textbox using xpath "//input[@name='username']"
And user enters text "reyaz123" into textbox using xpath "//input[@name='password']"
And user clicks on button using xpath "//input[@name='login']"
Then user verifies the title to be "Adactin.com - Search Hotel"

Scenario Outline:  To validate login using Invalid credentials 

Given user is starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user enters text '<username>' into textbox using xpath "//input[@name='username']"
And user enters text '<password>' into textbox using xpath "//input[@name='password']"
And user clicks on button using xpath "//input[@name='login']"
Then user verifies the title to be '<expTitle>'

Examples: 
|username|password|expTitle|
|reyaz0806|reyaz456|Adactin.com - Hotel Reservation System|
|reyaz1212|reyaz123|Adactin.com - Hotel Reservation System|
|reyaz1212|reyaz456|Adactin.com - Hotel Reservation System|




