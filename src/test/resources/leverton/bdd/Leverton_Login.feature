Feature: Verify login functionality

  Background: Navigate to home page
    Given User navigate to the application home

    @Login_IncorrectCredentials
    Scenario Outline: Verify user unable to login with incorrect credentials
      Given "Leverton_HomePage" is displaying
      When User enter "Username" as "<Username>"
      And User enter "Password" as "<Password>"
      And Use click "Log_In"
      Then "Ooops_Message" is displaying
      And "ErrorMessage" as "Sorry, we were not able to find a user with that username and password." displaying

      Examples:
      |Username|Password|
      |admin   |12345   |
      |guest   |12345   |
      |ankit   |test12  |





