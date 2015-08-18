package net.thucydides.showcase.junit.fluent;

public interface Question<ANSWER> {
    ANSWER answeredBy(Actor actor);
}
