Feature: Delete a todo
  I need to be able to delete a todo item if I made a mistake or no longer need to do it.

  Scenario: Delete an active todo
    Given I have a todo list containing 'Buy some milk','Buy Petrol'
    When I delete the todo action 'Buy some milk'
    Then my todo list should contain 'Buy Petrol'

  Scenario: Delete a completed todo
    Given I have a todo list containing 'Buy some milk','Buy Petrol'
    And I have marked the 'Buy some milk' action as complete
    When I delete the todo action 'Buy some milk'
    Then my todo list should contain 'Buy Petrol'
