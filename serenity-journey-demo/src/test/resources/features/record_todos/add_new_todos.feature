Feature: Add new todos
  I need to be able to jot down actions I need to do as fast as I think of them

  Scenario: Add a new todo
    Given I need to buy some milk
    When I add the todo action 'Buy some milk'
    Then 'Buy some milk' should appear in my todo list

  Scenario: New todos should be marked as Active
    Given I need to buy some milk
    When I add the todo action 'Buy some milk'
    Then 'Buy some milk' should appear in the Active items
