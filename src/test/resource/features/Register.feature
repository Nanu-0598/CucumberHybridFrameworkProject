Feature: Registration Functionality


Scenario: User creates an account only with mandatory fields
Given User navigates to Register Page
When User enteres the details into below fields
|firstName		|Arun										|
|LastName			|Motoori								|
|telephone    |1234567890							|
|password			|12345									|
And User selects Privacy Policy
And User click on continue button
Then User account should get created successfully

Scenario: User creates an account by entering all fields
Given User navigates to Register Page
When User enteres the details into below fields
|firstName						|Arun										|
|LastName							|Motoori								|
|telephone    				|1234567890							|
|password							|12345									|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User click on continue button
Then User account should get created successfully

Scenario: User creates an duplicate account
Given User navigates to Register Page
When User enteres the details into below fields with duplicate email
|firstName		|Arun										|
|LastName			|Motoori								|
|email				|test55@gmail.com				|
|telephone    |1234567890							|
|password			|12345									|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User click on continue button
Then User account should get warning about duplicate email

Scenario: User creates an account without entering any fields
Given User navigates to Register Page
When User does enteres any details into fields
And User click on continue button
Then User account should get warning about mandatory fields