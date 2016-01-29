Narrative:
In order check reports
As an Developer
I want to workin with todos using examples

Scenario: Record a new todo action for future use using examples
Meta:
@tag component:UI
@tag tool:jbehave
@skip

Given I need to <definition1>
When I add the todo action "<action1>"
Then "<action1>" should be recorded in my todo list
Examples:
|definition1|action1|
|buy some milk|Buy some milk|
|buy some sugar|Buy some sugar|
|buy some tea|Buy some tea|

Scenario: New todos should be marked as Active when examples are used
Meta:
@tag component:UI
@tag tool:jbehave
Given I need to <definition>
When I add the todo action "<action>"
Then "<action>" should be recorded in the "Active" items
Examples:
|definition|action|todostatus|
|buy some sugar|Buy some sugar|Active|
|buy some coffee|Buy some coffee|Active|
|buy some cup|Buy some cup|Active|