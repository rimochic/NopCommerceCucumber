Feature: Customers

  Background: Below are the common steps for eash scenario
    Given User launch the browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then User can view Dashboard
    When User click on customers Menu
    And Click on customers menu item
@sanity
  Scenario: Add new Customer
    And Click on Add new button
    Then User can view Add new cutomer page
    When User enters customer info
    And Click o Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close the browser
@regression
  Scenario: Saerch Customer by email
    And Enter customer Email
    When User click on search button
    Then User should found Email in the search table
    And Close the browser
@regression
  Scenario: Saerch Customer by First name and Last name
    And Enter customer First name
    And Enter customer Last name
    When User click on search button
    Then User should found Name in the search table
    And Close the browser
