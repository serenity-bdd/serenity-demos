package net.serenity.samples.batch.junit.steps.serenity;

import net.serenity.samples.batch.junit.model.ActivationMail;
import net.serenity.samples.batch.junit.model.User;
import net.thucydides.core.annotations.Step;

import java.util.concurrent.ThreadLocalRandom;

/**
 * User: YamStranger
 * Date: 11/13/15
 * Time: 2:01 AM
 */
public class MailActivationSteps {

    @Step
    public void given_activation_send(final ActivationMail activation, final User user) {
        action();
    }

    @Step
    public void when_user_enter_activation_code() {
        action();
    }

    @Step
    public void when_activation_code_expired() {
        action();
    }

    @Step
    public void then_user_account_activated() {
        action();
    }

    @Step
    public void then_user_received_notification() {
        action();
    }

    private void action() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(50, 200));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
