package net.thucydides.showcase.cucumber.pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.cucumber.model.ListingItem;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
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
        return $("//div[@id='search-header']/h1[@class='summary']").getText();
    }

    private int parse(String resultCount) {
        try {
            return NumberFormat.getNumberInstance(java.util.Locale.US).parse(resultCount).intValue();
        } catch (ParseException e) {
            throw new RuntimeException("Result count could not be parsed: " + resultCount);
        }
    }

    //https://github.com/serenity-bdd/serenity-core/issues/459
    public ListingItem selectListing(int listingNumber) {
    	String name = getDriver().findElements(By.xpath("//div[@id='content']//div[@class='clearfix']//div[1]/a//div[contains(@class,'card-title')]")).get(listingNumber).getText();
    	double price = Double.parseDouble( getDriver().findElements(By.xpath("//div[@id='content']//div[@class='clearfix']//div[1]/a//span[contains(@class,'currency text')]")).get(listingNumber).getText());
    	
    	List<WebElement> listingCards = getDriver().findElements(By.cssSelector(".listing-card:nth-child(" + listingNumber + ")"));
        WebElement listingCard = listingCards.get(1);
        
        listingCard.findElement(By.tagName("a")).click();
        waitForTextToAppear("Item details");

        return new ListingItem(name,price);
    }

    public void filterByLocalRegion() {
        if (containsText("We'd like to set these regional settings for you")) {
            regionalSettingsSaveButton.click();
        }
    }
}
