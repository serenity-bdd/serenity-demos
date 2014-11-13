package net.thucydides.showcase.jbehave.steps;

import net.thucydides.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.jbehave.model.ListingItem;
import net.thucydides.showcase.jbehave.steps.serenity.BuyerSteps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static net.thucydides.showcase.jbehave.model.SessionVariables.SELECTED_LISTING;

public class DisplayProductDetailsScenarioSteps {

    @Steps
    BuyerSteps buyer;

    @Given("I have searched for '$searchTerm'")
    public void givenIHaveSearchedFor(String searchTerm) {
        buyer.opens_home_page();
        buyer.searches_by_keyword(searchTerm);
    }

    @Given("I have selected item $number")
    @When("I select item $number")
    public void whenISelectListingItem(int number) {
        ListingItem selectedListingItem = buyer.selects_listing(number);
        Serenity.getCurrentSession().put(SELECTED_LISTING, selectedListingItem);
    }

    @Then("I should see product description and price on the details page")
    public void thenIShouldSeeProductDescriptionAndPriceOnTheDetailsPage() {
         ListingItem selectedListingItem = (ListingItem) Serenity.getCurrentSession().get(SELECTED_LISTING);
         buyer.should_see_product_details_for(selectedListingItem);
    }

}
