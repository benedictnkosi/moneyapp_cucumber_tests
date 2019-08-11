@login_feature
Feature: Login Action

Background:
 Given User is on Login Page

Scenario Outline: Successful Login with Valid Credentials
 When User logs in with "<username>" and "<password>"
 Then User is redirected to the Dashboard page
Examples:
          | username  | password  |
          | demo | pass |

Scenario Outline: Successful LogOut
When User logs in with "<username>" and "<password>"
 And User LogOut from the Application
 Then User is redirected to the Login page
 Examples:
           | username  | password  |
           | demo | pass |