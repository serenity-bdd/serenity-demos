package net.serenitybdd.demos.todos.steps;

public class WrongQuestion extends AssertionError {
    public WrongQuestion(Throwable cause) {
        super(cause);
    }
}
