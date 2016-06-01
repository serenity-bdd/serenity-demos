package net.serenitybdd.demos.todos.interactions;

import net.serenitybdd.demos.todos.pages.components.ToDoList;
import net.serenitybdd.demos.todos.tasks.interactions.Hit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.tasks.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddATodoItem implements Performable {

    private final String thingToDo;

    @Step("{0} adds a todo item called #thingToDo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(thingToDo).into(ToDoList.NEW_TODO),
                Hit.the(Keys.RETURN).into(ToDoList.NEW_TODO));
    }

    public AddATodoItem(String thingToDo) {
        this.thingToDo = thingToDo;
    }

    public static AddATodoItem called(String thingToDo) {
        return instrumented(AddATodoItem.class, thingToDo);
    }

}
