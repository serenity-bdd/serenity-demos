package net.thucydides.showcase.junit.steps.serenity;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.junit.model.ListingItem;
import net.thucydides.showcase.junit.model.OrderCostSummary;
import net.thucydides.showcase.junit.pages.CartPage;
import net.thucydides.showcase.junit.pages.HomePage;
import net.thucydides.showcase.junit.pages.ListingPage;
import net.thucydides.showcase.junit.pages.SearchResultsPage;

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
        homePage.searchForShopCalled(shopName);
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
