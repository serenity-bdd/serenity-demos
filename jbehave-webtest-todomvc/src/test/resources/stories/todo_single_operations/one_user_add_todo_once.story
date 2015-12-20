Narrative:
In order check reports
As an Developer
I want to workin with todos

Meta:
@tag component:UIAngularJs
@tag tool:jbehave
Scenario: Record a new todo action for future use
Given I need to buy some milk
When I add the todo action "Buy some milk"
Then "Buy some milk" should be recorded in my todo list

Scenario: New todos should be marked as Active
Given I need to buy some milk
When I add the todo action "Buy some milk"
Then "Buy some milk" should be recorded in the "Active" items