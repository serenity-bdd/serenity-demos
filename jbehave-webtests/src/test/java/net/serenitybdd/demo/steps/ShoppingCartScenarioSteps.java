package net.serenitybdd.demo.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.serenitybdd.demo.model.ListingItem;
import net.serenitybdd.demo.steps.serenity.BuyerSteps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import static net.serenitybdd.demo.model.SessionVariables.SELECTED_LISTING;

/**
 * Created by john on 12/11/14.
 */
public class ShoppingCartScenarioSteps {

    @Steps
    BuyerSteps buyer;

    @When("I add it to the cart")
    public void addToCart() {
        buyer.adds_current_listing_to_cart();
    }

    @Then("the item should appear in the cart")
    public void shouldSeeSelectedItemInCart() {
        ListingItem selectedItem = (ListingItem) Serenity.getCurrentSession().get(SELECTED_LISTING);
        buyer.should_see_item_in_cart(selectedItem);
    }

    @Then("the shipping cost should be included in the total price")
    public void shouldIncludeShippingCost() {
        ListingItem selectedItem = (ListingItem) Serenity.getCurrentSession().get(SELECTED_LISTING);
        buyer.should_see_total_including_shipping_for(selectedItem);
    }


}
