package net.serenitybdd.demos.todos.features.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.demos.todos.tasks.AddItems;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DeleteTodoStepDefinitions {


    @Managed
    WebDriver herBrowser;

    @Steps AddItems addSomeItems;

    Actor jane;

    @Before
    public void jane_wants_to_manage_her_todo_list() {
        jane = Actor.named("Jane");
        jane.can(BrowseTheWeb.with(herBrowser));
    }

    @Given("^I have a todo list containing (.*)$")
    public void i_have_a_todo_list_containing(List<String> thingsToDo) throws Throwable {
        jane.attemptsTo(addSomeItems.called(thingsToDo));
    }

    @When("^I delete the todo action 'Buy some milk'$")
    public void i_delete_the_todo_action_Buy_some_milk() throws Throwable {
    }

    @Then("^my todo list should contain 'Buy Petrol'$")
    public void my_todo_list_should_contain_Buy_Petrol() throws Throwable {
    }

    @Given("^I have marked the 'Buy some milk' action as complete$")
    public void i_have_marked_the_Buy_some_milk_action_as_complete() throws Throwable {
    }


}
