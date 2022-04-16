package ru.internet.sergeevss90.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithLambda {

    SelenideElement search = $(".header-search-input");
    private static final String searchTask = "SergeevSergeiS/qa_guru_12_1_git";

    @BeforeAll
    static void prepare() {
        step("Настраиваем конфигурацию браузера", () -> {
            Configuration.baseUrl = "https://github.com";
            Configuration.browserSize = "1920x1080";
        });
    }

    @Test
    public void testGithubIssue() {
        step("Открываем главную страницу:" + Configuration.baseUrl, () -> {
            open("");
        });


        search.click();
        search.sendKeys(searchTask);
        search.submit();

        $(linkText(searchTask)).click();
        $(partialLinkText("Issues")).click();
        $(withText("#2")).click();
    }
}
