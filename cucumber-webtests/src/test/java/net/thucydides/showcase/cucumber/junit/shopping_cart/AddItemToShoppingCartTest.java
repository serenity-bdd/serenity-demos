package net.thucydides.showcase.cucumber.junit.shopping_cart;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.showcase.cucumber.model.ListingItem;
import net.thucydides.showcase.cucumber.steps.serenity.BuyerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AddItemToShoppingCartTest {
    @Managed
    WebDriver driver;

    @Steps
    BuyerSteps anne;

    @Test
    public void add_a_leather_jacket_to_the_cart() {
        // GIVEN
        anne.opens_home_page();
        anne.searches_by_keyword("leather jacket");
        anne.filters_by_local_region();

        // WHEN
        ListingItem selectedItem = anne.selects_listing(2);
        anne.adds_current_listing_to_cart();

        // THEN
        anne.should_see_item_in_cart(selectedItem);
        anne.should_see_total_including_shipping_for(selectedItem);
    }
}

