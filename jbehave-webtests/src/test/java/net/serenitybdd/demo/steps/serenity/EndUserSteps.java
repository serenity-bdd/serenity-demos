package net.serenitybdd.demo.steps.serenity;

import net.serenitybdd.demo.model.ListingItem;
import net.serenitybdd.demo.model.OrderCostSummary;
import net.serenitybdd.demo.pages.CartPage;
import net.serenitybdd.demo.pages.HomePage;
import net.serenitybdd.demo.pages.ListingPage;
import net.serenitybdd.demo.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * User: YamStranger
 * Date: 12/10/15
 * Time: 6:50 AM
 */
public class EndUserSteps {

    @Step
    public void is_the_home_page() {
    }

    @Step
    public void looks_for(String value) {
       // assertThat("Value").containsIgnoringCase("8416516");
    }

    @Step
    public void should_see_definition(String value) {
        assertThat(value).containsIgnoringCase("1");
    }
}
