Feature: Display product details
  In order to encourage buyers to make a purchase
  As a seller
  I want buyers to be able to see details about a product

  Scenario: Display product details from the search list
    Given I have searched for 'Docking station'
    When I select item 1
    Then I should see product description and price on the details page

  Scenario: Display social media links for a product
    Given I have searched for 'Docking station'
    When I select item 1
    Then I should see social media links


  Scenario: Show pricing options
    Given I have searched for 'Docking station'
    And I have selected item 1
    When I view the currency options
    Then I should see a list of possible currencies