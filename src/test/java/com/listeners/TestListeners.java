package com.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.util.HashSet;

public class TestListeners implements ITestListener {


    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext context) {
        HashSet<ITestResult> allResults = new HashSet<>();
        allResults.addAll(context.getSkippedTests().getAllResults());
        allResults.addAll(context.getFailedTests().getAllResults());
        allResults.addAll(context.getPassedTests().getAllResults());

        reportToTestRail(allResults);

    }
    private void reportToTestRail(HashSet<ITestResult> results) {
        String baseURL = "https://hillelrob.testrail.io/";
        String projectId = "1";
        String runPrefix = "Jira";
        String username = "rvalek@intersog.com";
        String password = "hillel";

        if (baseURL.isEmpty() || projectId.isEmpty()) {
            System.out.println("TestRail reporting is not configured.");
            return;
        }

        System.out.println("Reporting to " + baseURL);

//        TestRail trReport = new TestRail(baseURL);
//        trReport.setCreds(username, password);
//
//        try {
//            trReport.startRun(Integer.parseInt(projectId), runPrefix + " Robert Auto - " + Helper.timeStamp());
//
//            for (ITestResult result : results) {
//                String testDescription = result.getMethod().getDescription();
//                try {
//                    int caseId = Integer.parseInt(testDescription.substring(0, testDescription.indexOf(".")));
//                    trReport.setResult(caseId, result.getStatus());
//                } catch (IndexOutOfBoundsException | NumberFormatException e) {
//                    System.out.println(testDescription + " - Case ID missing; not reporting to TestRail.");
//                    e.printStackTrace();
//                }
//            }
//
//            trReport.endRun();
//            System.out.println("Sent reports successfully.");
//        } catch (Exception e) {
//            System.out.println("Failed to send report to TestRail.");
//            e.printStackTrace();
//        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // result.getTestContext().getSkippedTests().removeResult(result.getMethod());

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }



}
