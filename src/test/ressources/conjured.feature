Feature: Conjured Item
  #A conjured item's quality decreases twice as fast

Scenario: Conjured item update
  Given I have a new inventory
  Then the quality of the conjured item is 6
  When I update the inventory
  Then the quality of the conjured item is 4