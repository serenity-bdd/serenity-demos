package net.serenity.samples.batch.junit.steps.serenity;

import net.serenity.samples.batch.junit.model.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;
import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_BATCH_SIZE;

/**
 * User: YamStranger
 * Date: 11/12/15
 * Time: 3:51 PM
 */
public class UserActionSteps {

    @Step
    public void given_started_registration_process(final User user) {
        Configuration configuration = new SystemPropertiesConfiguration(SystemEnvironmentVariables.createEnvironmentVariables());
        EnvironmentVariables environmentVariables = configuration.getEnvironmentVariables();
        assertThat(THUCYDIDES_BATCH_SIZE.integerFrom(environmentVariables, 0)).isGreaterThan(0);
    }

    @Step
    public void given_registered_user(final User user) {
        action();
    }

    @Step
    public void when_user_activate_registration() {
        action();
    }

    @Step
    public void when_user_login() {
        action();
    }

    @Step
    public void when_user_session_expired() {
        action();
    }

    @Step
    public void when_user_logout() {
        action();
    }

    @Step
    public void when_user_not_finished_registration() {
        action();
    }

    @Step
    public void then_user_should_be_available() {
        action();
    }


    @Step
    public void then_user_should_be_not_available() {
        action();
    }

    @Step
    public void then_one_login_record_should_exist() {
        action();
    }

    @Step
    public void then_login_record_should_not_exist() {
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