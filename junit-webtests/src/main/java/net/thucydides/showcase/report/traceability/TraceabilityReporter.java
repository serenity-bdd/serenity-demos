package net.thucydides.showcase.report.traceability;

import ch.lambdaj.function.convert.Converter;
import com.beust.jcommander.internal.Lists;
import com.google.common.collect.Sets;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.reports.*;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static ch.lambdaj.Lambda.*;

/**
 * Stores a traceability matrix between stories
 */
public class TraceabilityReporter extends ThucydidesReporter implements UserStoryTestReporter {

    public File generateReportFor(TestOutcomes testOutcomes, String reportName) throws IOException {

        List<String> scenarioNames = scenariosIn(testOutcomes);
        List<String> taggedIssues = issuesIn(testOutcomes);
        List<ScenarioIssueCount> scenarioIssueCounts = convert(testOutcomes.getOutcomes(), toScenarioIssueCounts(taggedIssues));

        return ExcelTraceabilityMatrix.record(taggedIssues, scenarioIssueCounts).to(getOutputFile(reportName));
    }

    private Converter<TestOutcome, ScenarioIssueCount> toScenarioIssueCounts(final List<String> taggedIssues) {

        return new Converter<TestOutcome, ScenarioIssueCount>() {

            @Override
            public ScenarioIssueCount convert(TestOutcome testOutcome) {
                ScenarioIssueCount scenarioIssueCount = new ScenarioIssueCount(testOutcome.getTitle());
                for(String issue : testOutcome.getIssues()) {
                    scenarioIssueCount.recordIssue(issue);
                }
                return scenarioIssueCount;
            }
        };
    }

    private List<String> issuesIn(TestOutcomes testOutcomes) {
        Collection<String> distinctIssues = Sets.newHashSet(flatten(extract(testOutcomes.getOutcomes(), on(TestOutcome.class).getIssues())));
        List<String> issueList = Lists.newArrayList(distinctIssues);
        Collections.sort(issueList);
        return issueList;
    }

    private List<String> scenariosIn(TestOutcomes testOutcomes) {
        return extract(testOutcomes.getOutcomes(), on(TestOutcome.class).getTitle());
    }

    private File getOutputFile(String reportName) {
        return new File(getOutputDirectory(), reportName);
    }


    @Override
    public void setResourceDirectory(String resourceDirectoryPath) {}

    @Override
    public TestOutcomes generateReportsForTestResultsFrom(File sourceDirectory) throws IOException {
        System.out.println("GENERATING EXCEL TRACEABILITY REPORT");
        TestOutcomes outcomes = TestOutcomeLoader.loadTestOutcomes().inFormat(OutcomeFormat.JSON).from(sourceDirectory);
        generateReportFor(outcomes,"target/site/serenity/traceability.xls");
        return outcomes;
    }
}
