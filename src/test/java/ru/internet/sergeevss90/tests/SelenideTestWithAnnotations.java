package ru.internet.sergeevss90.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class SelenideTestWithAnnotations {
    private static final String searchTask = "SergeevSergeiS/qa_guru_12_1_git";
    private static final int issueNumber = 2; //this test going to fail
    private static final String baseUrl = "https://github.com";

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.prepare(baseUrl);
        steps.openMainPage();
        steps.searchForRepository(searchTask);
        steps.clickOnRepositoryLink(searchTask);
        steps.openIssuesTab();
        steps.shouldSeeIssueNumber(issueNumber);
    }
}
