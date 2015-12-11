package net.thucydides.showcase.junit.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.showcase.junit.model.Pet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by john on 3/06/2015.
 */
public class PetStoreSteps {

    Pet pet;
    String jsonPet;

    @Step
    public void when_i_add_the_pet_to_the_store(Pet pet) {
        this.pet = pet;
        int id = Math.abs(new Random().nextInt());
        this.jsonPet = "{\"id\": " + id + " , \"name\": \""
                + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
                .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

        this.pet.setId(id);
    }

    @Step
    public void when_i_add_the_pet_to_the_store_with_json_map(Pet pet) {
        this.pet = pet;
        int id = Math.abs(new Random().nextInt());
        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("id", id);
        jsonAsMap.put("name", pet.getName());
        jsonAsMap.put("status", pet.getStatus());
        jsonAsMap.put("photoUrls", new ArrayList<>(Arrays.asList()));

        this.jsonPet = "{\"id\": " + id + " , \"name\": \""
            + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
            + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
            .content(jsonAsMap).post("http://petstore.swagger.io/v2/pet");

        this.pet.setId(id);
    }

    @Step
    public void the_pets_should_be_available() {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                    .then().statusCode(200)
                    .and().body("name", equalTo(pet.getName()));
    }

    @Step
    public void when_i_delete_the_pet() {
        rest().given().contentType("application/json")
            .content(jsonPet).delete("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
            .then().statusCode(200);
    }
    @Step
    public void the_pets_should_be_not_available() {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
            .then().statusCode(404);
    }
}