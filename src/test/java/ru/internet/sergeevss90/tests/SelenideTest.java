package ru.internet.sergeevss90.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    SelenideElement search = $(".header-search-input");
    String searchTask = "SergeevSergeiS/qa_guru_12_1_git";

    @BeforeAll
    static void prepare() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void testGithubIssue() {
        open("");

        search.click();
        search.sendKeys(searchTask);
        search.submit();

        $(linkText(searchTask)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#2")).click();


    }
}
