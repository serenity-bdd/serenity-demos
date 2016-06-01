package net.serenitybdd.demo.steps;
import com.google.common.collect.Lists;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.demo.model.Pet;
import net.serenitybdd.demo.steps.serenity.EndUserSteps;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;
/**
 * User: YamStranger
 * Date: 12/10/15
 * Time: 6:48 AM
 */
public class DefinitionSteps {
    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the <word>")
    @Alias("the user looks up the definition of the '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("they should see the <definition>")
    @Alias("they should see the '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition ) {
        endUser.should_see_definition(definition);
    }

    @Then("they should not see the <definition>")
    @Alias("they should not see the '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWordsThrowException(String definition ) {
       throw new NullPointerException();
    }
}
