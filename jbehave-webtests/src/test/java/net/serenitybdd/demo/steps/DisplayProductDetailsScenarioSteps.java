package net.serenitybdd.demo.steps;

import net.thucydides.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.demo.model.ListingItem;
import net.serenitybdd.demo.steps.serenity.BuyerSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static net.serenitybdd.demo.model.SessionVariables.SELECTED_LISTING;

public class DisplayProductDetailsScenarioSteps {

    private final int ARBITRARY_SELECTED_ITEM_NUMBER = 5;
    @Steps
    BuyerSteps buyer;

    @Given("I have searched for '$searchTerm'")
    public void givenIHaveSearchedFor(String searchTerm) {
        buyer.opens_home_page();
        buyer.searches_by_keyword(searchTerm);
    }

    @Given("I have selected a matching item")
    @When("I select a matching item")
    public void whenISelectListingItem() {
        ListingItem selectedListingItem = buyer.selects_listing(ARBITRARY_SELECTED_ITEM_NUMBER);
        Serenity.getCurrentSession().put(SELECTED_LISTING, selectedListingItem);
    }

    @Then("I should see product description and price on the details page")
    public void thenIShouldSeeProductDescriptionAndPriceOnTheDetailsPage() {
         ListingItem selectedListingItem = (ListingItem) Serenity.getCurrentSession().get(SELECTED_LISTING);
         buyer.should_see_product_details_for(selectedListingItem);
    }

}
