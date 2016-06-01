Narrative:
In order to sell a pet
As a store owner
I want to remove a pet from the catalog

Scenario: Removing a pet
Meta:
@tag component:Pet Store Api
@skip

Given I have the following pet:
|name | status    |
|Fido | available |
When I add the pet to the store
Then the pet should be available in the store
Then the pet should be available in the store
Then the pet should be available in the store

Scenario: Removing multiple pets:
Meta:
@tag component:Pet Store Api
@pending

Given I have the following pet:
|name | status    |
|Fido | available |
When I add the pet to the store
Then the pet should be available in the store
Then the pet should be available in the store
Then the pet should be available in the store
Then the pet should be available in the store