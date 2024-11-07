Feature: add to card

  Scenario Outline: ADD Product to the card

    @regression
    Given  User should navigate to the app
    And  User should login  to application as "<username>" and "<password>"
    And  User should  Search the "<book>"
    And  User Add to the book in Card
    Then The Card Should Be Updated

    Examples:
      | username | password  | book    |
      | myTest   | myTest123 | Slayer  |
      | mif      | myTest123 | Roomies |