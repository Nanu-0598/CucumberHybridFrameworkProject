Feature: Login Functionality


Scenario Outline: login with valid credentials
Given User has navigate to login page
When User has entered valid email address <username> into the email field
And User has entered valid password <password> into password field
And User clicks on login button
Then User should get login succesfully
Examples:
|username									|password|
|amotooricap1@gmail.com		|12345	 |
|amotooricap2@gmail.com		|12345   |  
|amotooricap3@gmail.com		|12345   |
|test55@gmail.com					|Test@123|

Scenario: Login with invalid credentials
Given User has navigate to login page
When User has entered invalid email address into the email field
And User has entered invalid password = "1234895" into password field
And User clicks on login button
Then User should error message about credentials mismatch

Scenario: Login with valid email and invalid Password
Given User has navigate to login page
When User has entered valid email address = "test55@gmail.com" into the email field
And User has entered invalid password = "12348895" into password field
And User clicks on login button
Then User should get error message about password mismatch

Scenario: lLogin with invalid email and valid Password
Given User has navigate to login page
When User has entered invalid email address into the email field
And User has entered valid password = "12345" into password field
And User clicks on login button
Then User should get error message about email id is wrong

Scenario: login without providing credentials
Given User has navigate to login page
When User does not entered valid email address into the email field
And User does not entered valid password into password field
And User clicks on login button
Then User should get Warning message