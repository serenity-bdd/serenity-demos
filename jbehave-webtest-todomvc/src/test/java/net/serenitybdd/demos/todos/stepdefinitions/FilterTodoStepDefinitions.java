package net.serenitybdd.demos.todos.jbehave.stepdefinitions;

import net.serenitybdd.demos.todos.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.steps.FilterItems;
import org.jbehave.core.annotations.When;

import static net.serenitybdd.demos.todos.model.Actors.theActorNamed;

public class FilterTodoStepDefinitions {

    @When("$name consults the $status tasks$")
    public void i_delete_the_todo_action(String name, TodoStatusFilter status) throws Throwable {
        theActorNamed(name).attemptsTo(FilterItems.byStatus(status));
    }
}
