package net.serenity.samples.batch.junit.features.registration;

import net.serenity.samples.batch.junit.model.User;
import net.serenity.samples.batch.junit.steps.serenity.UserActionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * User: YamStranger
 * Date: 11/12/15
 * Time: 3:52 PM
 */
@RunWith(SerenityRunner.class)
public class RegisterUserTest {
    @Steps
    UserActionSteps steps;

    @Test
    public void should_be_available_after_finishing_registration() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_started_registration_process(user);

        // WHEN
        steps.when_user_activate_registration();

        // THEN
        steps.then_user_should_be_available();
    }

    @Test
    public void should_be_not_available_before_finishing_registration() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        steps.given_started_registration_process(user);

        // WHEN
        steps.when_user_not_finished_registration();

        // THEN
        steps.then_user_should_be_not_available();
    }
}
