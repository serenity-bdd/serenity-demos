Narrative:
In order to talk better
As an English student
I want to look up word definitions

Scenario: Looking for not existed definition
Meta:
@tag component:UI
Given the user is on the Wikionary home page
When the user looks up the definition of the <word>
Then they should see the <definition>
Examples:
|word|definition|
|apple|1|
|pear|2|


Scenario: Looking for definition
Meta:
@tag component:UI

Given the user is on the Wikionary home page
When the user looks up the definition of the <word>
Then they should see the <definition>
Examples:
|word|definition|
|apple|1|
|pear|1|
|chair|1|

Scenario: Looking for definition with incorrect symbols
Meta:
@tag component:UI
@ignore
Given the user is on the Wikionary home page
When the user looks up the definition of the <word>
Then they should see the <definition>
Examples:
|word|definition|
|apple|1|
|pear|1|
|apple|1|
|pear|1|