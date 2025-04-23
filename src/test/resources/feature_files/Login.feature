#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


#Author: seleniumpanda@gmail.com

@LoginFunctionality
Feature: Testing Login functionality of TutorialsNinja application

Background: Given User navigates to LoginPage

@ValidCredentials
 Scenario Outline: Login with valid credentials
 When User enters valid email <email> into email textBox
 And User enters valid password <password> into password textBox
 And User clicks on Login button
 Then User is re-directed to AccountPage
 Examples:
 |   email                 |   password   |
 |seleniumpanda@gmail.com  | Selenium@123 |
 |seleniumpanda1@gmail.com | Selenium@123 |
 |seleniumpanda2@gmail.com | Selenium@123 |
 |seleniumpanda3@gmail.com | Selenium@123 |
 |seleniumpanda4@gmail.com | Selenium@123 |
 
@InvalidCredentials
 Scenario: Login with invalid credentials
  When User enters invalid email "seleniumpanda@gmaill.com"
  And User enters invalid password "Selenium@123456"
  And User clicks on Login button
  Then User gets warning message about credentials mismatch
  
@InvalidPasswordValidEmail
 Scenario: Login with invalid credentials
  When User enters valid email 'seleniumpanda@gmail.com' into email textBox
  And User enters invalid password 123456 into password textBox
  And User clicks on Login button
  Then User gets warning message about credentials mismatch



