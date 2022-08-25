Feature: Login

Scenario: Login with the valid cred

Given User launch chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out
Then Page title should be "Your store. Login"
And Close the browser

Scenario Outline: Login Data Driven

Given User launch crome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "<email>" and Password as "<Password>"
And Click on Login
Then Page title should be "Dashboard / nopCommerce administration"
When User click on Log out
Then Page title should be "Your store. Login"
And Close the browser

Examples:
				| email | Password |
				| admin@yourstore.com | admin |
				| admin@yourstore.com | admin123 |