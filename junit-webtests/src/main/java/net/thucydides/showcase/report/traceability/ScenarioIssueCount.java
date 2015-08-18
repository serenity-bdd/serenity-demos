package net.thucydides.showcase.report.traceability;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by john on 17/08/2015.
 */
public class ScenarioIssueCount implements Comparable<ScenarioIssueCount> {
    String title;
    Map<String, Integer> issueCountMap;

    public ScenarioIssueCount(String title) {
        this.title = title;
        issueCountMap = Maps.newHashMap();
    }

    public void recordIssue(String issue) {
        int currentCount = issueCountMap.containsKey(issue) ? issueCountMap.get(issue) : 0;
        issueCountMap.put(issue, currentCount + 1);
    }

    public Integer getIssueCountFor(String issue) {
        if (issueCountMap.containsKey(issue)) {
            return issueCountMap.get(issue);
        }
        return 0;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(ScenarioIssueCount other) {
        return title.compareTo(other.title);
    }
}
