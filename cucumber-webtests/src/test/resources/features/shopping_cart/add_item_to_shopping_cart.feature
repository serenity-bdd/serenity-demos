Feature: Add item to shopping cart
  As a buyer
  I want to be able to purchase items online
  So that I can get them faster

Scenario: Add item to cart
  Given I have searched for 'docking station'
  And I have selected item 2
  When I add it to the cart
  Then the item should appear in the cart
  And the shipping cost should be included in the total price~