package net.serenity.samples.parameterized;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_BATCH_COUNT;
import static org.assertj.core.api.StrictAssertions.*;

/**
 * User: YamStranger
 * Date: 11/11/15
 * Time: 7:19 PM
 */
public class TestSteps {

    @Step
    public void initialization() {
        action();
    }

    @Step
    public void when_example_action_for(final int value) {
        action();
    }

    @Step
    public void then_example_result_should_be(final int value) {
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
