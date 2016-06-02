package net.thucydides.showcase.junit.pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.model.ListingItem;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResultsPage extends PageObject {

    @FindBy(css="#search-header .result-count")
    WebElementFacade resultCountSummary;

    @FindBy(css=".primary-actions .btn-primary")
    WebElementFacade regionalSettingsSaveButton;

    public String getSearchHeader() {
        return $("//div[@class='float-left']//span[@class='strong']").getText();
    }

    Pattern searchResultSummaryPattern = Pattern.compile("([\\d,]+) Results");

    public String getResultSummary(){
        return $(".summary").getText();
    }

    private int parse(String resultCount) {
        try {
            return NumberFormat.getNumberInstance(java.util.Locale.US).parse(resultCount).intValue();
        } catch (ParseException e) {
            throw new RuntimeException("Result count could not be parsed: " + resultCount);
        }
    }

    public ListingItem selectListing(int listingNumber) {
        List<WebElementFacade> listingCards = findAll(By.cssSelector(".listing-card:nth-child(" + listingNumber + ")"));
        WebElementFacade listingCard = listingCards.get(0);
        String name = listingCard.findBy(".card-meta-row").getText();
        double price = Double.parseDouble(listingCard.findBy(".card-price").getText().split("\\s")[0].replace("$", "")
                .replace("€", "")
                .replace("£", "")
                .replace(",", ""));

        listingCard.findBy(By.tagName("a")).click();

        waitForTextToAppear("Item details");

        return new ListingItem(name, price);
    }

    public void filterByLocalRegion() {
        if (containsText("We'd like to set these regional settings for you")) {
            regionalSettingsSaveButton.click();
        }
    }
}
