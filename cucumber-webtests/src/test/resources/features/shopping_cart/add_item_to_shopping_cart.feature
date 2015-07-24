@version:Release-1
@version:Sprint-1.1
@issue:ETSY-104
Feature: Add an item to the shopping cart
  As a buyer
  I want to be able to purchase items online
  So that I can get them faster

  Scenario: Add item to cart
    Given I have searched for 'wool' in my region
    And I have selected item 1
    When I add it to the cart
    Then the item should appear in the cart
    And the shipping cost should be included in the total price




