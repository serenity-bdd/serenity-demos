package net.serenitybdd.demos.todos.jbehave.stepdefinitions;

import net.serenitybdd.demos.todos.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.steps.ATodoUser;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RecordTodoStepDefinitions {
    @Given("I need to $doSomething")
    public void i_need_to(String doSomething) throws Throwable {
        jane.opens_the_todo_application();
    }

    @Steps ATodoUser jane;

    @When("I add the todo action \"$actionName\"")
    @Alias("I have added the todo action \"$actionName\"")
    public void i_add_the_todo_action(String actionName) throws Throwable {
        jane.adds_an_action_called(actionName);
    }

    @Then("\"$action\" should appear in my todo list")
    @Alias("\"$action\" should be recorded in my todo list")
    public void action_should_appear_in_my_todo_list(String action) throws Throwable {
        jane.should_see_the_todo_action(action);
    }

    @Then("\"$action\" should appear in the \"$status\" items")
    @Alias("\"$action\" should be recorded in the \"$status\" items")
    public void action_should_appear_the_items_of_status(String action, String status) throws Throwable {
        jane.filters_by_status(TodoStatusFilter.valueOf(status));
        jane.should_see_the_todo_action(action);
    }
}
