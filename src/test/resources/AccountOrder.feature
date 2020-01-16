#Author: Ileossa
Feature: Features for account service

  Scenario: In order to save money
    When I want to make a deposit 10 in my bank
    Then I have 10 money in my bank

  Scenario: In order to retrieve some or all of my savings
    Given I have 100 money on my bank
    When I want to make a withdrawal 100 from my bank
    Then I have 0 money on my bank

  Scenario: In order to check my operations
    Given I have make deposit of 10 and withdrawal of 5 on my bank
    When I want to see the history (operation, date, amount, balance) of my operations
    Then I print history