Feature: Vest Item
  #A vest item's quality decreases normally

  Scenario: Conjured item update
    Given I have a new inventory
    Then the quality of the Vest item is 6
    When I update the inventory
    Then the quality of the Vest item is 5