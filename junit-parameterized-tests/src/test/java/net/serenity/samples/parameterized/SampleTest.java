package net.serenity.samples.parameterized;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.UserStoryCode;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: YamStranger
 * Date: 11/11/15
 * Time: 7:13 PM
 */
@RunWith(SerenityParameterizedRunner.class)
@UserStoryCode("US01")
@Concurrent
public class SampleTest {
    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{1}, {2}, {3}});
    }

    @Steps
    TestSteps steps;
    private final int value;

    public SampleTest(int value) {
        this.value = value;
    }

    @Test
    public void shouldExecuteThisTest() {
        steps.initialization();
        steps.when_example_action_for(this.value);
        steps.then_example_result_should_be(this.value);
    }

    @Test
    public void shouldExecuteThisTestToo() {
        steps.initialization();
        steps.when_example_action_for(this.value);
        steps.then_example_result_should_be(this.value);
    }
}
