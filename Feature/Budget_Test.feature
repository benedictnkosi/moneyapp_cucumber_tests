@budget_feature
Feature: Budget Test

Background:
 Given User is on Budget Page

Scenario Outline: Successfully Add Budget Item
 When User clicks the add button
 And User selects  budget category "<category>"
 And User selects budget transaction "<transaction_name>"
 And User clicks the submit button
 Then A budget success message is displayed : "<message>"
Examples:
          | category  | transaction_name  | message |
          | Personal Expenses | Children and Dependants | successfully captured new budget item |

