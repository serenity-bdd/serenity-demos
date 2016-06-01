Narrative:
In order to sell a pet
As a store owner
I want to add a new pet to the catalog

Scenario: Adding a pet
Meta:
@tag component:Pet Store Api

Given I have the following pet:
|name | status    |
|Fido | available |
When I add the pet to the store
Then the pet should be available in the store

