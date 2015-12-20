Narrative:
In order check reports
As an Developer
I want to workin with todos

Meta:
@tag component:UI
@tag tool:jbehave
Scenario: Record a some todo actions for future use
Given I need to buy some milk
When I add the todo action "Buy some milk"
And I add the todo action "Buy some tea"
Then "Buy some milk" should be recorded in my todo list

Scenario: All todos should be marked as Active
Given I need to buy some milk
When I add the todo action "Buy some milk"
And I add the todo action "Buy some tea"
Then "Buy some milk" should be recorded in the "Active" items
Then "Buy some tea" should be recorded in the "Active" items