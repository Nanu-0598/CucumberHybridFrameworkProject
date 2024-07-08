Feature: Search Functionality

Scenario: User searches for a valid product
Given user Opens the Applicaitons
When User enters valid products "HP" into Search box field
And User clicks on Search button
Then User should get valid product displayed in search results

Scenario: User searches for an invalid product
Given user Opens the Applicaitons
When User enters invalid products "Honda" into Search box field
And User clicks on Search button
Then User should get a message as no product matching

Scenario: User searches without entering any product
Given user Opens the Applicaitons
When User does not enter any products into Search box field
And User clicks on Search button
Then User should get a message as no product matching