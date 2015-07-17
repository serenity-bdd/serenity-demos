package net.thucydides.showcase.cucumber.steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.Inflector;
import net.thucydides.showcase.cucumber.steps.serenity.BuyerSteps;

import java.text.ParseException;


/**
 * Created by john on 17/07/2015.
 */
public class PortugeseSteps {

    @Steps
    BuyerSteps buyer;

    @Dado("que (?:quero|possa querer) comprar um (.*)")
    public void buyerWantsToBuy(String article) {
        buyer.opens_home_page();
    }

    @Quando("eu buscar por '(.*)'")
    public void searchByKeyword(String keyword) {
        buyer.searches_by_keyword(keyword);
    }

    @Entao("devo ver apenas artigos relacionados com '(.*)'")
    public void resultsForACategoryAndKeywordInARegion(String keyword) throws ParseException {
        buyer.should_see_results_summary_containing(keyword);
    }

    @Dado("que desejo visualizar artigos de uma loja em particular")
    public void givenIWantToSeeArticlesFromAParticularShop() {
        buyer.opens_home_page();
    }

    @Quando("eu buscar uma loja por '(.*)'")
    public void whenISearchByShopFor(String shopName) {
        buyer.should_see_nonexistant_field();
        buyer.searches_for_shop_called(shopName);
    }

    @Entao("devo encontrar (\\d+) (?:loja|lojas) chamada '(.*)'")
    public void thenIShouldFindShopsCall(int count, String shopName) {
        String expectedMessage = String.format("%d %s encontrada para %s", count, pluralized(count, "loja"), shopName);
        buyer.should_see_shop_search_result_summary_of(expectedMessage);
    }

    private String pluralized(int count, String word) {
        return Inflector.getInstance().pluralize(word, count);

    }
}
