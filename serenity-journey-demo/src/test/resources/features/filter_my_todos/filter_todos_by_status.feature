Feature: Filter todos by status
  I need to be able show only completed or uncompleted tasks

  Scenario: Display only Active tasks
    Given I have added the todo action 'Buy some milk'
    And I have completed the todo action 'Buy the newspaper'
    When I consult my Active tasks
    Then 'Buy some milk' should appear in my todo list

