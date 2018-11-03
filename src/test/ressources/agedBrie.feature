Feature: AgedBrie Item
  #An aged bries' quality increases with time

  Scenario: Conjured item update
    Given I have a new inventory
    Then the quality of the AgedBrie item is 6
    When I update the inventory
    Then the quality of the AgedBrie item is 7