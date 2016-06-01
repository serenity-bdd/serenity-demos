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

public class BuyerSteps extends ScenarioSteps {

    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ListingPage listingPage;
    CartPage cartPage;

    @Step
    public void opens_home_page() {
        homePage.open();
    }

    @Step
    public void searches_by_keyword(String keyword) {
        homePage.enterSearchTerms(keyword);
        homePage.search();
        homePage.dismissLocationMessage();
    }

    @Step
    public void should_see_results_summary_containing(String keyword) {
        assertThat(searchResultsPage.getSearchHeader()).containsIgnoringCase(keyword);
    }

    @Step
    public void searches_for_shop_called(String shopName) {
        //homePage.searchForShopCalled(shopName);
        assertThat("Bla").containsIgnoringCase(shopName);
    }

    @Step
    public void should_see_shop_search_result_summary_of(String expectedMessage) {
        assertThat(searchResultsPage.getResultSummary()).isEqualToIgnoringCase(expectedMessage);
    }

    @Step
    public ListingItem selects_listing(int articleNumber) {
        return searchResultsPage.selectListing(articleNumber);
    }

    @Step
    public void should_see_product_details_for(ListingItem selectedListingItem) {
        ListingItem displayedListingItem = listingPage.getDisplayedListing();
        assertThat(displayedListingItem).isEqualTo(selectedListingItem);
    }

    @Step
    public void adds_current_listing_to_cart() {
        listingPage.selectOptionIfPresent();
        listingPage.addToCart();
    }

    @Step
    public void should_see_item_in_cart(ListingItem selectedItem) {
        assertThat(cartPage.getOrderCostSummaries()
                        .stream().anyMatch(order -> order.getName().equals(selectedItem.getName()))).isTrue();
    }

    @Step
    public void should_see_total_including_shipping_for(ListingItem selectedItem) {
        OrderCostSummary orderCostSummary = cartPage.getOrderCostSummaryFor(selectedItem).get();

        double itemTotal = orderCostSummary.getItemTotal();
        double shipping = orderCostSummary.getShipping();

        assertThat(itemTotal).isEqualTo(selectedItem.getPrice());
        assertThat(shipping).isGreaterThan(0.0);
    }

    @Step
    public void should_see_product_rating() {
        assertThat(listingPage.getRating()).isGreaterThan(0);
    }

    @Step
    public void should_see_twitter_link() {
        listingPage.twitterIcon().shouldBeVisible();
    }

    @Step
    public void should_see_tumblr_link() {
        listingPage.tumblrIcon().shouldBeVisible();
    }

    @Step
    public void should_see_facebook_link() {
        listingPage.facebookIcon().shouldBeVisible();
    }


    @Step
    public void should_see_nonexistant_field() {
        assertThat(listingPage.clickImaginaryButton()).isFalse();
    }


    @Step
    public void filters_by_local_region() {
        searchResultsPage.filterByLocalRegion();
    }
}
