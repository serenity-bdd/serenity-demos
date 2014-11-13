package net.thucydides.showcase.jbehave.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.showcase.jbehave.model.ListingItem;

/**
 * Created by john on 12/11/14.
 */
public class ListingPage extends PageObject {

    @FindBy(xpath = "//*[@itemprop='name']")
    WebElementFacade name;

    @FindBy(css="#listing-price .currency-value")
    WebElementFacade price;

    public ListingItem getDisplayedListing() {
        String listingName = name.getText();
        double listingPrice = Double.parseDouble(price.getText());
        return new ListingItem(listingName, listingPrice);
    }

    public void addToCart() {
        withAction().moveToElement($("#item-tabs")).perform();
        $(".add-to-cart-form button").click();
    }
}
