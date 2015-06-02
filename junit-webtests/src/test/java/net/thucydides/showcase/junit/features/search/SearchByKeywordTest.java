package net.thucydides.showcase.junit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import net.thucydides.showcase.junit.steps.serenity.BuyerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchByKeywordTest {

    @Managed
    WebDriver driver;

    @Steps
    BuyerSteps buyer;

    @Test
    @WithTags( {
            @WithTag(type="priority",name="medium"),
            @WithTag(type="component",name="search")

    })
    public void search_for_articles_by_keyword() {
        buyer.opens_home_page();
        buyer.searches_by_keyword("wool");
        buyer.should_see_results_summary_containing("wool");
    }

    @Test//(timeout = 100)
    public void search_for_articles_by_shop_name() {
        buyer.opens_home_page();
        buyer.searches_for_shop_called("docksmith");
        buyer.should_see_shop_search_result_summary_of("1 shop found for docksmith");
    }
}