package ru.internet.sergeevss90.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.*;

public class SelenideTestWithLabels {

    @Test
    @Owner("sergeevss")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Очень странный тест")
    @Feature("Задачи в репозитории")
    @Story("Просмотр созданных задач в репозитории")
    @Link(value = "Тестинг", url = "https://github.com")
    public void testAnnotated() {
    }

    @Test
    public void testCode() {
        Allure.label("owner", "sergeevss");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.feature("Задачи в репозитории");
        Allure.story("Просмотр созданных задач в репозитории");
        Allure.link("Тестинг", "https://github.com");
    }

    @Documented
    @Owner("sergeevss")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Простматр созданных задач в репозитории")
    @Target({ ElementType.TYPE, ElementType.METHOD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IssueShow {

    }
}
