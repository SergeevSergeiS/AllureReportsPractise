package ru.internet.sergeevss90.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTestWithLambda {

    SelenideElement search = $(".header-search-input");
    private static final String searchTask = "SergeevSergeiS/qa_guru_12_1_git";
    private static final String issueNumber = "#3";

    @BeforeAll
    static void prepare() {
        step("Настраиваем конфигурацию браузера", () -> {
            Configuration.baseUrl = "https://github.com";
            Configuration.browserSize = "1920x1080";
        });
    }

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу:" + Configuration.baseUrl, () -> open(""));

        step("Ищем репозиторий:" + searchTask, () -> {
            search.click();
            search.setValue(searchTask);
            search.submit();
        });

        step("Переходим по ссылке репозитория:" + searchTask, () -> $(linkText(searchTask)).click());

        step("Переходим на вкладку Issues", () -> $(partialLinkText("Issues")).click());

        step("Проверяем, что существует Issue с номером " + issueNumber, () -> {
            $(withText(issueNumber)).should(Condition.visible);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
