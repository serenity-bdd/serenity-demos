package net.thucydides.showcase.junit.pages;

import com.google.common.base.Function;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.etsy.com")
public class HomePage extends PageObject {

    @FindBy(xpath="//button[@class='btn btn-primary']|//button[@value='Search']|//button[@class='btn btn-orange btn-append']")
    WebElementFacade searchButton;

    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'find shop names')]";

    public void enterSearchTerms(String keyword) {
        $("#search-query").type(keyword);
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//div[@class='as-suggestion'][contains(.,'" + keyword.toLowerCase() + "')]"));
        waitForKeywordToBeUpdatedTo(keyword);
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250,TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return $("#search-query").getValue().equalsIgnoreCase(keyword);
            }
        };
    }

    public void search() {
    	withAction().moveToElement($("//button[@class='btn btn-primary']|//button[@value='Search']|//button[@class='btn btn-orange btn-append']")).perform();
    	//without above step , click is not happening at all
        searchButton.click();
    }

    public void searchForShopCalled(String shopName) {
        enterSearchTerms(shopName);
        $(SHOP_SUGGESTION).click();
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }
}
