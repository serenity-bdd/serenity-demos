package net.serenity.samples.retries;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Issues;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * User: YamStranger
 * Date: 12/3/15
 * Time: 11:01 PM
 */
@RunWith(SerenityRunner.class)
public class SampleTest {

    @Steps
    TestSteps steps;

    @Test
    @Title("Test case for some issue #BP-64  ")
    public void shouldExecuteThisTest() {
        steps.initialization();
        steps.when_example_action_for(1);
        steps.then_example_result_should_be(2);
    }

    @Test
    @Title("Tests important bugs : #BP-64,#IS-84")
    public void shouldExecuteThisTestTwo() {
        steps.initialization();
        steps.when_example_action_for(1);
        steps.then_example_result_should_be(2);
    }

    @Test
    @Issue("#NO-97")
    public void shouldExecuteThisTestThree() {
        steps.initialization();
        steps.when_example_action_for(1);
        steps.then_example_result_should_be(2);
    }

    @Test
    @Issues({"#PN-97", "#KB-927"})
    public void shouldExecuteThisTestLast() {
        steps.initialization();
        steps.when_example_action_for(1);
        steps.then_example_result_should_be(2);
    }
}
