package net.thucydides.showcase.junit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.model.ListingItem;
import org.openqa.selenium.By;

/**
 * Created by john on 12/11/14.
 */
public class ListingPage extends PageObject {

    public static final String PRODUCT_OPTIONS_DROPDOWN = ".variation";
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
        dismissLocationMessage();
        withAction().moveToElement($("#item-tabs")).perform();
        $(".add-to-cart-form button").click();
    }

    private void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }

    public void selectOptionIfPresent() {
        if (!findAll(By.cssSelector(PRODUCT_OPTIONS_DROPDOWN)).isEmpty()) {
            $(PRODUCT_OPTIONS_DROPDOWN).selectByIndex(1);
        }
    }
}
