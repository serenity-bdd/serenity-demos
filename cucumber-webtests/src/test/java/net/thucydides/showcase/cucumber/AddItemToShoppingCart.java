package net.thucydides.showcase.cucumber;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/shopping_cart/add_item_to_shopping_cart.feature")
public class AddItemToShoppingCart  {
}
