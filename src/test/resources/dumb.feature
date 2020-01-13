#Author: Ileossa
Feature: Features for account service

  Scenario: I would like deposit 10 in my personal account
    Given I deposit 10 euros
    When I print the statement of my account
    Then My account as credited of 10 euros

  Scenario: I can't deposit negative value (-10)
    Given I have 0 euros on my account
    When I deposit -10 euros on my account
    Then print error message and rollback operation

  Scenario: I would like withdrawal a value on my account
    Given I have 0 euros on my account
    When I withdrawal -10 euros on my account
    Then statement of my account as -10

  Scenario: I can't withdrawal with a positive value (+10)
    Given I have 0 euros on my account
    When I withdrawal 10 euros on my account
    Then print error message and rollback operation

  Scenario: I want see deposit history
    Given I have no transaction on my history
    When I deposit 10 euros on my account
    Then I see in my history my operation deposit, with the current date (year-mont-day) and 10 euro positive amount.

  Scenario: I want see withdrawal history
    Given I have no transaction on my history
    When I withdrawal 10 euro on my account
    Then I see in my history my operation withdrawal, with the current date (year-mont-day) and -10 euro negative amount.

  Scenario: I want see balance on multiple transactions
    Given I have no transaction on my history
    When I deposit 10
    And I withdrawal 100
    And I deposit 10
    Then I see in my history 3 transactions( date + amount), and -80 euros in my bank account.