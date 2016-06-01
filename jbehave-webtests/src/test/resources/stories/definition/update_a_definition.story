Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: Updating a definition
Meta:
@tag component:UI
Given the user is on the Wikionary home page
When the user looks up the definition of the <word>
Then they should not see the <definition>
Examples:
|word|definition|
|apple|1|
|pear|1|
|pear|1|
|apple|1|
|pear|1|