package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import net.thucydides.showcase.cucumber.model.ListingItem;
import net.thucydides.showcase.cucumber.pages.HomePage;
import net.thucydides.showcase.cucumber.steps.serenity.BuyerSteps;
import static net.thucydides.showcase.cucumber.model.SessionVariables.SELECTED_LISTING;
import static org.assertj.core.api.Assertions.assertThat;

public class DisplayProductDetailsScenarioSteps {

    @Steps
    BuyerSteps buyer;

    HomePage homePage;

    @Given("I have searched for '(.*)' in my region")
    public void givenIHaveSearchedFor(String searchTerm) {

        homePage.open();

        buyer.opens_home_page();
        buyer.searches_by_keyword(searchTerm);
        buyer.filters_by_local_region();
    }

    @When("I (?:have selected|select) item (\\d+)")
    public void whenISelectListingItem(int number) {
        ListingItem selectedListingItem = buyer.selects_listing(number);
        Serenity.setSessionVariable(SELECTED_LISTING).to(selectedListingItem);
    }

    @Then("I should see product description and price on the details page")
    public void thenIShouldSeeProductDescriptionAndPriceOnTheDetailsPage() {
         ListingItem selectedListingItem = (ListingItem) Serenity.sessionVariableCalled(SELECTED_LISTING);
         buyer.should_see_product_details_for(selectedListingItem);
    }

    @Then("I should see a product rating")
    public void shouldSeeProductRating() {
        buyer.should_see_product_rating();
    }

    @Then("I should see social media links")
    public void shouldSeeSocialMediaLinks() {
        buyer.should_see_facebook_link();
        buyer.should_see_twitter_link();
        buyer.should_see_tumblr_link();
    }
}
