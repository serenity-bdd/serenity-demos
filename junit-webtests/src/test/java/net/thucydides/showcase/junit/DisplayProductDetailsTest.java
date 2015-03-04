package net.thucydides.showcase.junit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.junit.model.ListingItem;
import net.thucydides.showcase.junit.steps.serenity.BuyerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class DisplayProductDetailsTest {
    @Managed
    WebDriver driver;

    @Steps
    BuyerSteps buyer;

    @Test
    public void display_product_details_from_the_search_list() {
        buyer.opens_home_page();
        buyer.searches_by_keyword("Docking station");

        ListingItem selectedListingItem = buyer.selects_listing(1);

        buyer.should_see_product_details_for(selectedListingItem);

    }
}
