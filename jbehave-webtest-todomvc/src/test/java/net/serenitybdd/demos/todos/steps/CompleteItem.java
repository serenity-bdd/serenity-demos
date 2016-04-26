package net.serenitybdd.demos.todos.steps;

import net.serenitybdd.demos.todos.pages.components.ToDoList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteItem implements Performable {

    private final String itemName;

    public CompleteItem(String itemName) {
        this.itemName = itemName;
    }

    public static CompleteItem called(String itemName) {
        return instrumented(CompleteItem.class, itemName);
    }

    @Override
    @Step("Completes item called #itemName")
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(Click.on(ToDoList.completeButtonFor(itemName)));
    }
}
