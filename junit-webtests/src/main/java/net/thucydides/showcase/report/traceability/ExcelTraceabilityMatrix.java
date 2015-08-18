package net.thucydides.showcase.report.traceability;

import com.google.common.collect.Lists;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static java.util.Collections.sort;

public class ExcelTraceabilityMatrix {

    List<ScenarioIssueCount> scenarioIssueCounts;
    List<String> issues;

    public ExcelTraceabilityMatrix(List<String> issues, List<ScenarioIssueCount> scenarioIssueCounts) {
        this.scenarioIssueCounts = Lists.newArrayList(scenarioIssueCounts);
        this.issues = Lists.newArrayList(issues);
        sort(scenarioIssueCounts);
        sort(issues);
    }

    public static ExcelTraceabilityMatrix record(List<String> issues, List<ScenarioIssueCount> scenarioIssueCounts) throws IOException {
        return new ExcelTraceabilityMatrix(issues, scenarioIssueCounts);
    }

    public File to(File savedTraceabilityMatrix) throws IOException {
        FileOutputStream out = new FileOutputStream(savedTraceabilityMatrix);
        Workbook wb = new HSSFWorkbook();
        Sheet traceabilitySheet = wb.createSheet("Traceability Matrix");

        addTitleRowTo(traceabilitySheet);
        addScenarioRowsTo(traceabilitySheet);

        wb.write(out);
        out.close();

        System.out.println("Saving traceability matrix to " + savedTraceabilityMatrix);
        return savedTraceabilityMatrix;
    }

    private void addTitleRowTo(Sheet traceabilitySheet) {
        Row titleRow = traceabilitySheet.createRow(0);
        titleRow.createCell(0, Cell.CELL_TYPE_STRING).setCellValue("Stories");
        titleRow.createCell(1, Cell.CELL_TYPE_STRING).setCellValue("Story count");

        populateAutomatedTestScenarioHeadings(titleRow);

        traceabilitySheet.createRow(1).createCell(0).setCellValue("Scenarios per issue");
    }

    private void populateAutomatedTestScenarioHeadings(Row titleRow) {
        int column = 2;
        for(ScenarioIssueCount scenarioIssueCount : scenarioIssueCounts) {
            titleRow.createCell(column, Cell.CELL_TYPE_STRING).setCellValue(scenarioIssueCount.getTitle());
            column++;
        }
    }

    private void addScenarioRowsTo(Sheet traceabilitySheet) {
        int rowNum = 1;

        for(String issue : issues) {

            Row scenarioRow = traceabilitySheet.createRow(rowNum++);

            populateStoryTitle(issue, scenarioRow);

            populateIssueCountSumsForStories(rowNum, scenarioRow);

            populateIssueCounts(issue, scenarioRow);
        }
    }

    private void populateStoryTitle(String issue, Row scenarioRow) {
        Cell totalCell = scenarioRow.createCell(0);
        totalCell.setCellValue(issue);
    }

    private void populateIssueCountSumsForStories(int rowNum, Row scenarioRow) {
        String totalFormula = "SUM(C" + rowNum + ":" + "ZZ" + rowNum +")";
        scenarioRow.createCell(1).setCellFormula(totalFormula);
    }

    private void populateIssueCounts(String issue, Row scenarioRow) {
        int columnNum = 2;
        for(ScenarioIssueCount issueCount : scenarioIssueCounts) {
            Cell currentIssueCountCell = scenarioRow.createCell(columnNum);
            currentIssueCountCell.setCellValue(issueCount.getIssueCountFor(issue));
            columnNum++;
        }
    }

}
