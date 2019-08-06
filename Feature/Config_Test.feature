@config_feature
Feature: Config Test

Background:
 Given User is on Home Page


Scenario Outline: Successfully Create Custom Transaction Name
 When User navigates to the config page
 And User selects category "<category>"
 And User enters "<transaction_name>"
 And User clicks the create button
 Then A message is displayed : "<message>"
 And transaction "<transaction_name>" is added to the list
Examples:
          | category  | transaction_name  | message |
          | Personal Expenses | breakfast | successfully captured new transaction name |
          | Business Expenses | travel | successfully captured new transaction name |
          | Income | side hustle | successfully captured new transaction name |
          | Investments | Forex | successfully captured new transaction name |
          | Loan Pay Down | Wonga | successfully captured new transaction name |

@delete_transaction
Scenario Outline: Successfully Delete Custom Transaction Name
 When User navigates to the config page
 And User selects category "<category>"
 And User clicks the delete button on "<transaction_name>"
 Then A message is displayed : "<message>"
 And The "<transaction_name>" is removed from the list
Examples:
          | category  | transaction_name  | message |
          | Personal Expenses | breakfast | successfully deleted transaction name |
          | Business Expenses | travel | successfully deleted transaction name |
          | Income | side hustle | successfully deleted transaction name |
          | Investments | Forex | successfully deleted transaction name |
          | Loan Pay Down | Wonga | successfully deleted transaction name |