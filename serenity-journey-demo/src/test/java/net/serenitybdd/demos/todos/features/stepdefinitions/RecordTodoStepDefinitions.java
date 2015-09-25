package net.serenitybdd.demos.todos.features.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.demos.todos.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.pages.TodoPage;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTodoStepDefinitions {

    TodoPage todoPage;

    @Given("^I need to (?:.*)$")
    public void i_need_to_add_a_new_task() throws Throwable {
        todoPage.open();
    }

    @When("^I (?:add|have added) the todo action '(.*)'$")
    public void i_add_the_todo_action(String actionName) throws Throwable {
        todoPage.addActionCalled(actionName);
    }

    @Then("^'(.*)' should appear in my todo list$")
    public void action_should_appear_in_my_todo_list(String action) throws Throwable {
        assertThat(todoPage.getActions()).contains(action);
    }

    @Then("^'(.*)' should appear in the (.*) items$")
    public void action_should_appear_the_items_of_status(String action, TodoStatusFilter status) throws Throwable {
        todoPage.filterByStatus(status);
        assertThat(todoPage.getActions()).contains(action);
    }
}
