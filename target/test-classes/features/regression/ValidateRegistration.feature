Feature: To validate registration Functionality

@wip2604
Scenario: To validate registration functionality using valid details

Given user is starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks on link using xpath "//a[text()='New User Register Here']"
Then user verifies the title to be "Adactin.com - New User Registration"
When user enters text "ravi2604" into textbox using xpath "//input[@name='username']"
And user enters text "ravi123" into textbox using xpath "//input[@name='password']"
And user enters text "ravi123" into textbox using xpath "//input[@name='re_password']"
And user enters text "Ravi S" into textbox using xpath "//input[@name='full_name']"
And user enters text "abcd@gmail.com" into textbox using xpath "//input[@name='email_add']"
And user enters text "snowbell" into textbox using xpath "//input[@name='captcha']"

