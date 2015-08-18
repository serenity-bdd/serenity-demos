package net.thucydides.showcase.junit.fluent;

import net.thucydides.core.annotations.Step;

public class Actor {

    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String toString() { return name; }

    public <T extends Task> void has(T... todos) {
        attemtpsTo(todos);
    }

    public <T extends Task> void attemtpsTo(T... todos) {
        for(Task todo : todos) {

            todo.performAs(this);
        }
    }

    @Step("Then #this should see that {0}")
    public <ANSWER> ANSWER seesThat(Question<ANSWER> question) {
        return question.answeredBy(this);
    }

    public static Actor named(String name) {
        return new Actor(name);
    }
}
