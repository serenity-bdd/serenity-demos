package net.thucydides.showcase.junit.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import net.thucydides.showcase.junit.model.ListingItem;
import net.thucydides.showcase.junit.model.OrderCostSummary;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by john on 12/11/14.
 */
public class CartPage extends PageObject {

    private static ListingItem costSummaryToListingItem(OrderCostSummary orderCostSummary) {
        return new ListingItem(orderCostSummary.getName(), orderCostSummary.getItemTotal());
    }

    public List<OrderCostSummary> getOrderCostSummaries() {
        return findAll(".cart-listing-list")
                .stream()
                .map(CartPage::convertToOrderCostSummary)
                .collect(Collectors.toList());
    }

    public Optional<OrderCostSummary> getOrderCostSummaryFor(ListingItem selectedItem) {
        return getOrderCostSummaries()
                .stream()
                .filter(item -> item.getName().equals(selectedItem.getName()))
                .findFirst();
    }

    public static OrderCostSummary convertToOrderCostSummary(WebElementFacade summaryElement) {
        String name = summaryElement.find(By.xpath("//div[@class='cart-listing-list']//a[contains(@class,'listing-title')]")).getText();
        double itemTotal = Double.parseDouble(summaryElement.findBy("//div[@class='multi-shop-cart-payment']//tr[1]//span[@class='currency-value']").getText());
        double shipping = Double.parseDouble(summaryElement.findBy("//tr//*[contains(., 'Shipping')]/following-sibling::td[1]//span[2]").getText());
        double grandTotal = Double.parseDouble(summaryElement.findBy("//div[@class='multi-shop-cart-payment']//tr[6]//span[@class='currency-value'] | //div[@class='multi-shop-cart-payment']//tr[7]//span[@class='currency-value']").getText());
        return new OrderCostSummary(name, itemTotal, shipping, grandTotal);
    }
}
