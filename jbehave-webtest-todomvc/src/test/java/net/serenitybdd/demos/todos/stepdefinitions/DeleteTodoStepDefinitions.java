package net.serenitybdd.demos.todos.jbehave.stepdefinitions;

import net.serenitybdd.demos.todos.steps.AddItems;
import net.serenitybdd.demos.todos.steps.CompleteItem;
import net.serenitybdd.demos.todos.steps.DeleteAnItem;
import net.serenitybdd.demos.todos.steps.DisplayedItems;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;


import java.util.List;

import static net.serenitybdd.demos.todos.model.Actors.theActorNamed;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class DeleteTodoStepDefinitions {

    @Managed
    WebDriver janesBrowser;

    @Managed
    WebDriver joesBrowser;

    @Steps AddItems addSomeItems;
    @Steps DisplayedItems theDisplayedItems;

    @Given("$actor has a todo list containing $thingsToDo")
    public void has_a_todo_list_containing(String actor, List<String> thingsToDo) throws Throwable {
        theActorNamed(actor).can(BrowseTheWeb.with(theBrowserBelowingTo(actor)));
        theActorNamed(actor).attemptsTo(addSomeItems.called(thingsToDo));
    }


    @When("$actor deletes the todo action $action")
    public void delete_the_todo_action(String actor, String action) throws Throwable {
        theActorNamed(actor).attemptsTo(DeleteAnItem.called(action));
    }

    @Then("$actor's todo list should contain $expectedTodos")
    public void my_todo_list_should_contain(String actor, List<String> expectedTodos) throws Throwable {
        theActorNamed(actor).should(seeThat(theDisplayedItems, containsInAnyOrder(theActionsIn(expectedTodos))));
    }

    private Object[] theActionsIn(List<String> expectedTodos) {
        return expectedTodos.toArray();
    }

    @Given("$actor has marked the $itemName action as complete$")
    public void i_have_marked_the_action_as_complete(String actor, String itemName) throws Throwable {
        theActorNamed(actor).attemptsTo(CompleteItem.called(itemName));
    }


    private WebDriver theBrowserBelowingTo(String actor) {
        switch (actor) {
            case "Jane" :
                return janesBrowser;
            case "Joe" :
                return joesBrowser;
            default:
                return janesBrowser;
        }
    }

}