package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.etsy.com")
public class HomePage extends PageObject {

    @FindBy(css="button[value='Search']")
    WebElementFacade searchButton;

    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'%s')]";

    public void enterSearchTerms(String keyword) {
        $("#search-query").type(keyword);
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(String.format(SHOP_SUGGESTION, keyword.toLowerCase())));
        waitForKeywordToBeUpdatedTo(keyword);
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250,TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return webDriver -> $("#search-query").getValue().equalsIgnoreCase(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public void searchForShopCalled(String shopName) {
        enterSearchTerms(shopName);
        $(String.format(SHOP_SUGGESTION, shopName)).click();
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }
}
