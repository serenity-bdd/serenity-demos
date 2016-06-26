@component:ui
@version:Release-2
@issue:ETSY-102
Feature: Search by keyword
  In order for buyers to find what they are looking for more efficiently
  As a seller
  I want buyers to be able to search for articles by keywords

  Scenario: Search for articles by keyword
    Given I want to buy a wool scarf
    When I search for 'wool'
    Then I should see only articles related to 'wool'

  Scenario Outline: Search by shop name
    Given I want to see articles from a particular shop
    When I search by shop for '<shopname>'
    Then I should find 1 shop called '<shopname>'
  Examples:
    | shopname      |
    | SwankySips    |
    | mymagicname   |

  Scenario Outline: Search for many articles by keyword
    Given I would like to buy a <article>
    When I search for '<article>'
    Then I should see only articles related to '<keyword>'
  Examples:
    | article        | keyword |
    | wool scarf     | wool    |
    | cotton shirt   | cotton  |
