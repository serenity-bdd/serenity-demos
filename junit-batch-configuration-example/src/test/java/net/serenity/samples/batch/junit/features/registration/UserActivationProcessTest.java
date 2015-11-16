package net.serenity.samples.batch.junit.features.registration;

import net.serenity.samples.batch.junit.model.ActivationMail;
import net.serenity.samples.batch.junit.model.User;
import net.serenity.samples.batch.junit.steps.serenity.MailActivationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ThreadLocalRandom;

/**
 * User: YamStranger
 * Date: 11/12/15
 * Time: 3:52 PM
 */
@RunWith(SerenityRunner.class)
public class UserActivationProcessTest {
    @Steps
    MailActivationSteps steps;

    @Test
    public void should_activate_user_account() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        final ActivationMail activation = new ActivationMail(user.getEmail()
            , String.valueOf(ThreadLocalRandom.current().nextLong()));
        steps.given_activation_send(activation, user);

        // WHEN
        steps.when_user_enter_activation_code();

        // THEN
        steps.then_user_account_activated();
    }

    @Test
    public void should_send_notification_to_user() {
        // GIVEN
        final User user = new User("user.login", "user@mail.com");
        final ActivationMail activation = new ActivationMail(user.getEmail()
            , String.valueOf(ThreadLocalRandom.current().nextLong()));
        steps.given_activation_send(activation, user);

        // WHEN
        steps.when_activation_code_expired();

        // THEN
        steps.then_user_received_notification();
    }
}
