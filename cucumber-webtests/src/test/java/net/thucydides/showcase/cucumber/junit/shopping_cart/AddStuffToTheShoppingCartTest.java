package net.thucydides.showcase.cucumber.junit.shopping_cart;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.showcase.cucumber.model.ListingItem;
import net.thucydides.showcase.cucumber.steps.serenity.BuyerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddStuffToTheShoppingCartTest {
    @Managed
    WebDriver driver;

    @Steps
    BuyerSteps buyer;

    @Test
    public void add_a_leather_jacket_to_the_cart() {
        // GIVEN
        buyer.opens_home_page();
        buyer.searches_by_keyword("leather jacket");
        buyer.filters_by_local_region();

        // WHEN
        ListingItem selectedItem = buyer.selects_listing(2);
        buyer.adds_current_listing_to_cart();

        // THEN
        buyer.should_see_item_in_cart(selectedItem);
        buyer.should_see_total_including_shipping_for(selectedItem);
    }
}

