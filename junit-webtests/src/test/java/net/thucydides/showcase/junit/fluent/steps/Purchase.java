package net.thucydides.showcase.junit.fluent.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.StepFactory;
import net.thucydides.showcase.junit.fluent.Actor;
import net.thucydides.showcase.junit.fluent.Task;

public class Purchase implements Task {

    String purchasedItem;
    int cost;
    String currency;

    public static Purchase purchased() {return new Purchase();}

    public Purchase anApple() {
        this.purchasedItem = "an apple";
        return this;
    }

    private Purchase forItem(String item) {
        this.purchasedItem = item;
        return this;
    }

    public Purchase aPear() {
        this.purchasedItem = "a pear";
        return this;
    }


    @Step("Given {0} has purchased #purchasedItem for #cost #currency")
    public void performAs(Actor actor) {
        int i = 0;
    }

    public Purchase thatCosts(int cost) {
        this.cost = cost;
        return this;
    }

    public Purchase pounds() {
        this.currency = "pounds";
        return this;
    }
}
