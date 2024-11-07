Feature:
  BOOKCART Demo

  Background:
    Given  User should navigate to the application
    And  User should go to the login page

    @smoke
  Scenario: Login should be Success


    And  User should enter the username as "myTest"
    And  User should enter the password as "myTest123"
    When User click the login button
    Then  Login should be Success

  @regression
  Scenario: Login should be Fail

    And  User should enter the username as "mif"
    And  User should enter the password as "myTest123"
    When User click the login button
    But  Login should be Fail
