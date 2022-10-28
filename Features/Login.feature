Feature: Login

@sanity
  Scenario: Successful login with valid credentials
    Given User launch the browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And Close the browser
@regression
  Scenario Outline: Login data driven
    Given User launch the browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login button
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And Close the browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | admin@hhhhh.com     | amdkk    |
