package net.serenitybdd.demos.todos.steps;

import net.serenitybdd.demos.todos.pages.components.ToDoList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.RETURN;

public class AddATodoItem implements Performable {

    private final String thingToDo;

    static int counter = 0;

    @Step("{0} adds a todo item called #thingToDo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(thingToDo).into(ToDoList.NEW_TODO_FIELD),
                Hit.the(RETURN).keyIn(ToDoList.NEW_TODO_FIELD)
        );
    }

    public AddATodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

    public static AddATodoItem called(String thingToDo) {
        return instrumented(AddATodoItem.class, thingToDo);
    }

}
