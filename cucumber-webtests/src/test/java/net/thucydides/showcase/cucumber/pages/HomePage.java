package net.thucydides.showcase.cucumber.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.etsy.com")
public class HomePage extends PageObject {

    @FindBy(xpath="//form[@id='search-bar']//button[@type='submit']")
    WebElementFacade searchButton;

    private final static String SHOP_SUGGESTION = "//div[@id='search-suggestions']//div[@class='as-suggestion']//*[contains(.,'find shop names containing')]";
    private final static String SHOP_SUGGESTION_SHOP_NAME = "//div[@id='search-suggestions']//div[@class='as-suggestion']/span[2]";
    
    public void enterSearchTerms(String keyword) {
    	$("#search-query").type(keyword);
        new WebDriverWait(getDriver(),1).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHOP_SUGGESTION)));
        //withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(SHOP_SUGGESTION));
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
        $(SHOP_SUGGESTION_SHOP_NAME).click();
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }
}
