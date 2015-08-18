package net.thucydides.showcase.junit.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.showcase.junit.steps.serenity.BuyerSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
@Issues({"MYPROJ-102","MYPROJ-103"})
public class SearchByKeyword {

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

    @Test
    public void search_for_articles_by_shop_name() {
        buyer.opens_home_page();
        buyer.searches_for_shop_called("docksmith");
        buyer.should_see_shop_search_result_summary_of("1 shop found for docksmith");
    }

    @Test
    public void failing_search_for_articles_by_shop_name() {
        buyer.opens_home_page();
        buyer.searches_for_shop_called("docksmith");
        buyer.should_see_shop_search_result_summary_of("2 shops found for docksmith");
    }

    @Test
    @Manual
    public void should_respect_standard_look_and_feel() {}

}