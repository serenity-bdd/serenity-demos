package net.serenitybdd.demo.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.etsy.com")
public class HomePage extends PageObject {

    @FindBy(css="button[value='Search']")
    WebElementFacade searchButton;

    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'find shop names')]";

    public void enterSearchTerms(String keyword) {
        $("#search-query").type(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public void searchForShopCalled(String shopName) {
        enterSearchTerms(shopName);
        waitFor(500).milliseconds();
        $(SHOP_SUGGESTION).click();
    }
}
