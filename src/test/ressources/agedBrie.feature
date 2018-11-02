Feature : Aged Brie
  This item's quality should increase over time

Scenario :
  Given I have 1 Aged Brie
  When sellIn decreases by 1
  Then quality increases by 1