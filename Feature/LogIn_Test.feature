@login_feature
Feature: Login Action

Background:
 Given User is on Login Page

Scenario Outline: Successful Login with Valid Credentials
 When User enters "<username>" and "<password>"
 Then User is redirected to the Dashboard page
Examples:
          | username  | password  |
          | demo12 | pass |

Scenario Outline: Successful LogOut
When User enters "<username>" and "<password>"
 And User LogOut from the Application
 Then User is redirected to the Login page
 Examples:
           | username  | password  |
           | demo12 | pass |