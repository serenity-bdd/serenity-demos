package net.serenitybdd.demos.todos.steps;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.core.exceptions.TestCompromisedException;
import net.serenitybdd.demos.todos.pages.ApplicationHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.ElementNotVisibleException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddItems implements Performable {

    List<String> thingsToDo;
    ApplicationHomePage applicationHomePage;

    @Step("{0} adds #thingsToDo to the todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(applicationHomePage));

        thingsToDo.forEach(thingToDo -> actor.attemptsTo(AddATodoItem.called(thingToDo)));
    }

    public AddItems called(List<String> thingsToDo) {
        this.thingsToDo = thingsToDo;
        return this;
    }

    public AddItems called(String... thingsToDo) {
        return called(ImmutableList.copyOf(thingsToDo));
    }

//    @Step
//    public void failAssumption() {
//        throw new AssumptionViolatedException("oh crap");
//
//    }

    @Step
    public void failedAssert() {
        assertThat(true, is(false));
    }

    @Step
    public void withError() {
        throw new ElementNotVisibleException("");
    }

    @Step
    public void compromised() {
        throw new TestCompromisedException("");
    }
}
