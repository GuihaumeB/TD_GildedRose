Feature: AgedBrie Item
  #An aged bries' quality increases with time

  Scenario: AgedBrie item update
    Given I have a new inventory with an aged brie
    Then the quality of the AgedBrie item is 0
    When I update the brie inventory
    Then the quality of the AgedBrie item is 1