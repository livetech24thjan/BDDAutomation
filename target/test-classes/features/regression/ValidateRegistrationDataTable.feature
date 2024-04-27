Feature: To validate registration Functionality

@wip2704
Scenario: To validate registration functionality using valid details

Given user is starts "chrome" browser
And user launch app using url "https://adactinhotelapp.com/"
When user clicks on link using xpath "//a[text()='New User Register Here']"
Then user verifies the title to be "Adactin.com - New User Registration"
#When user enter details in registaration form
#|ravi2704|ravi123|ravi123|Ravi Kumar|abcd@gmail.com|snowbell|
When user enter details in registaration form using datatable
|username|password|confirm password|full name|email address|captcha|
|ravi2704|ravi123|ravi123|Ravi Kumar|abcd@gmail.com|snowbell|