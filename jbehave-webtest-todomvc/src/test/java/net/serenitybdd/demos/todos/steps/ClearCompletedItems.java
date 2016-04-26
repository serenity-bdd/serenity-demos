package net.serenitybdd.demos.todos.steps;

import net.serenitybdd.demos.todos.pages.components.FilterBar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class ClearCompletedItems implements Performable {

    @Step("{0} clears all the completed items")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(FilterBar.CLEAR_COMPLETED));
    }
}
