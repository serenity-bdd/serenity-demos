package net.thucydides.showcase.jbehave.steps.serenity;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.showcase.jbehave.model.ListingItem;
import net.thucydides.showcase.jbehave.model.OrderCostSummary;
import net.thucydides.showcase.jbehave.pages.CartPage;
import net.thucydides.showcase.jbehave.pages.HomePage;
import net.thucydides.showcase.jbehave.pages.ListingPage;
import net.thucydides.showcase.jbehave.pages.SearchResultsPage;
import org.assertj.core.data.Offset;

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
        Serenity.takeScreenshot();
        homePage.search();
        Serenity.takeScreenshot();
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
    public void view_currency_options() {
        listingPage.viewCurrencyOptions();
    }

    @Step
    public void currency_options_include(String... currencies) {
        assertThat(listingPage.getCurrencies()).contains(currencies);
    }
}
