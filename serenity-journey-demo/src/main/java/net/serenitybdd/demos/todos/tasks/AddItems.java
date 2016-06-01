package net.serenitybdd.demos.todos.tasks;

import net.serenitybdd.demos.todos.interactions.AddATodoItem;
import net.serenitybdd.demos.todos.pages.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.tasks.Open;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class AddItems implements Performable {

    private List<String> thingsToDo;
    private ApplicationHomePage applicationHomePage;

    @Step("{0} adds #thingsToDo to her todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(applicationHomePage));

        thingsToDo.forEach(thingToDo -> actor.attemptsTo(AddATodoItem.called(thingToDo)));
    }

    public AddItems called(List<String> thingsToDo) {
        this.thingsToDo = thingsToDo;
        return this;
    }
}
