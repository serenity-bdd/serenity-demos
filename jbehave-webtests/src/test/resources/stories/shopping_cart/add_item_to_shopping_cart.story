Narrative:
In order to make the most appropriate purchase decisions
As a buyer
I want to be able to place items I want to buy in a virtual cart before placing my order

Scenario: Show shipping cost for an item in the shopping cart
Given I have searched for 'docking station'
And I have selected a matching item
When I add it to the cart
Then the shipping cost should be included in the total price

Scenario: Calculate tax
Given I have searched for 'docking station'
And I have selected a matching item
When I add it to the cart
Then local taxes should be included in the total price

