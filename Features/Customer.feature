Feature: Customer

Background: Below are the common steps for each scenario
Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then User can view Dashboard
When User click on customers menu
And click on customers menu item

Scenario: Add a new customer

And click on Add new button
Then User can view Add new customer page
When User enter customer info
And click on save button
Then User can view confirmation message "The customer has been added successfully"
And Close the browser

Scenario: Search a customer by email id

And Enter customer email
When click on search button
Then user should find email in search table
And Close the browser

Scenario: Search a customer by name

And Enter customer first name
And Enter customer last name
When click on search button
Then user should find name in search table
And Close the browser