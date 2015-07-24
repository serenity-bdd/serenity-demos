Add an item to the shopping cart
Narrative:
In order to make the most appropriate purchase decisions
As a buyer
I want to be able to place items I want to buy in a virtual cart before placing my order

Meta:
@tag component:UI

Scenario: Add item to cart
Given I have searched for 'wool' in my region
And I have selected item 1
When I add it to the cart
Then the item should appear in the cart
And the shipping cost should be included in the total price