Feature: Vest Item
  #A vest item's quality decreases normally

  Scenario: Vest item update
    Given I have a new inventory with a vest
    Then the quality of the Vest item is 20
    When I update the vest inventory
    Then the quality of the Vest item is 19