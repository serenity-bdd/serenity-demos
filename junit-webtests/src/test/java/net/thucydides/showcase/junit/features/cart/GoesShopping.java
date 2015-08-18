package net.thucydides.showcase.junit.features.cart;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Issues;
import net.thucydides.showcase.junit.fluent.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import static net.thucydides.showcase.junit.fluent.GivenWhenThen.givenThat;
import static net.thucydides.showcase.junit.fluent.steps.Purchase.purchased;

@RunWith(SerenityRunner.class)
@Issues({"MYPROJ-105","MYPROJ-106"})
public class GoesShopping {

    Actor dana = Actor.named("Dana");

    @Test
    public void shouldBeAbleToPurchaseSomeItems() {
        givenThat(dana).has(purchased().anApple().thatCosts(10).pounds(),
                            purchased().aPear().thatCosts(5).pounds());
    }

}
