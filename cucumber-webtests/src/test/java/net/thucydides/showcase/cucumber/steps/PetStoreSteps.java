package net.thucydides.showcase.cucumber.steps;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.showcase.cucumber.model.Pet;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Random;

/**
 * Created by john on 27/05/2015.
 */
public class PetStoreSteps {

    List<Pet> pets;

    @Given("I have the following pets?")
    public void i_have_the_following_pets(List<Pet> pets) {
        this.pets = Lists.newArrayList(pets);
    }

    @When("I add the pet to the store")
    public void i_add_the_pet_to_the_store() {
        for(Pet pet : pets ) {
            int id = Math.abs(new Random().nextInt());
            String jsonPet = "{\"id\": " + id + " , \"name\": \""
                    + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                    + pet.getStatus() + "\"}";

            rest().given().contentType("application/json")
                          .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

            pet.setId(id);
        }
    }

    @Then("the pets? should be available in the store")
    public void pets_should_be_available() {
        for(Pet pet : pets ) {
            rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                    .then().statusCode(200)
                    .and().body("name", equalTo(pet.getName()));
        }
    }
}
