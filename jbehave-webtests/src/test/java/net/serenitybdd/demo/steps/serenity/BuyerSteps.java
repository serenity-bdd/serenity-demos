package net.serenitybdd.demo.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.serenitybdd.demo.model.ListingItem;
import net.serenitybdd.demo.model.OrderCostSummary;
import net.serenitybdd.demo.pages.CartPage;
import net.serenitybdd.demo.pages.HomePage;
import net.serenitybdd.demo.pages.ListingPage;
import net.serenitybdd.demo.pages.SearchResultsPage;

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
        assertThat(searchResultsPage.getResultCount()).isGreaterThan(0);
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
}