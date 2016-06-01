package net.serenitybdd.demo.steps;

import com.google.common.collect.Lists;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.demo.model.Pet;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by john on 27/05/2015.
 */
public class PetStoreSteps {

    List<Pet> pets;

    @Given("I have the following pet: $pets")
    @Alias("I have the following pets: $pets")
    public void i_have_the_following_pets(ExamplesTable petsTable) {

        this.pets = Lists.newArrayList();

        for(Map<String, String> petRow : petsTable.getRows()) {
            this.pets.add(new Pet(petRow.get("status"), petRow.get("name")));
        }
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
    @Alias("the pet should be available in the store")
    public void pets_should_be_available() {
        for(Pet pet : pets ) {
            rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                    .then().statusCode(200)
                    .and().body("name", equalTo(pet.getName()));
        }
    }
}
