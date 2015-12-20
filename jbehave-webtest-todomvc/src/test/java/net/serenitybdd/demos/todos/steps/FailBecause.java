package net.serenitybdd.demos.todos.steps;

import net.serenitybdd.core.exceptions.TestCompromisedException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.ElementNotVisibleException;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FailBecause implements Performable {

    RuntimeException reasonForFailure;

    public FailBecause(RuntimeException reasonForFailure) {
        this.reasonForFailure = reasonForFailure;
    }

    @Step("A step fails")
    public <T extends Actor> void performAs(T actor) {
        throw reasonForFailure;
    }

    public static FailBecause theUIHasBeenChanged() {
        return instrumented(FailBecause.class, new ElementNotVisibleException("no such element"));
    }

    public static FailBecause theMainframeIsDown() {
        return instrumented(FailBecause.class, new TestCompromisedException("Mainframe down"));
    }
}
