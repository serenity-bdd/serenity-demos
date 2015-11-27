package net.thucydides.showcase.junit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.model.ListingItem;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by john on 12/11/14.
 */
public class ListingPage extends PageObject {

    public static final String PRODUCT_OPTIONS_DROPDOWN = ".variation";

    @FindBy(xpath = "//*[@itemprop='name']")
    WebElementFacade name;

    @FindBy(css="#listing-price .currency-value")
    WebElementFacade price;

    @FindBy(className="review-rating-count")
    WebElementFacade rating;

    @FindBy(className="twitter-icon")
    WebElement twitterIcon;

    @FindBy(id="tumblr-share")
    WebElementFacade tumblrIcon;

    @FindBy(id="share1-fb-like")
    WebElementFacade facebookIcon;

    @FindBy(id="currency-tab")
    WebElementFacade currencyTabHeader;

    @FindBy(css = "#currency-tab-content")
    WebElementFacade currencyTab;

    public ListingItem getDisplayedListing() {
        String listingName = name.getText();
        double listingPrice = Double.parseDouble(price.getText().replaceAll("[^0-9.,]+",""));
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
        if (!findAll(By.cssSelector(PRODUCT_OPTIONS_DROPDOWN)).isEmpty() && isADropdown(PRODUCT_OPTIONS_DROPDOWN)) {
            $(PRODUCT_OPTIONS_DROPDOWN).selectByIndex(1);
        }
    }

    private boolean isADropdown(String productOptionsDropdown) {
        return $(productOptionsDropdown).getTagName().equalsIgnoreCase("select");
    }

    public Double getRating() {
        return Double.parseDouble(StringUtils.strip(rating.getText().replace(",", "."), "()"));
    }

    public WebElementState twitterIcon() {
        withAction().moveToElement(twitterIcon).perform();

        return $(twitterIcon);
    }

    public WebElementState tumblrIcon() {
        return withTimeoutOf(2, TimeUnit.SECONDS).waitFor(tumblrIcon);
    }

    public WebElementState facebookIcon() {
        return withTimeoutOf(5, TimeUnit.SECONDS).waitFor(facebookIcon);
    }

    public boolean clickImaginaryButton() {
        try {
            $(".does-not-exist").click();
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public void waitForTooLong() {

        withTimeoutOf(2, TimeUnit.SECONDS).find(By.cssSelector("#does-not-exist"));
    }
}