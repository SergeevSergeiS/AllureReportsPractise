package ru.internet.sergeevss90.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    SelenideElement search = $(".header-search-input");

    @Step("Настраиваем конфигурацию браузера")
    public void prepare(String path) {
        Configuration.baseUrl = path;
        Configuration.browserSize = "1920x1080";
    }

    @Step("Открываем главную страницу: https://github.com" )
    public void openMainPage() {
        open("");
    }

    @Step("Ищем репозиторий: {searchTask}")
    public void searchForRepository(String searchTask) {
        search.click();
        search.sendKeys(searchTask);
        search.submit();
    }

    @Step("Переходим по ссылке репозитория: {searchTask}")
    public void clickOnRepositoryLink(String searchTask) {
        $(linkText(searchTask)).click();
    }

    @Step("Переходим на вкладку Issues")
    public void openIssuesTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем, что существует Issue с номером {issueNumber}")
    public void shouldSeeIssueNumber(int issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.visible);
        attachScreenshot();
    }

    @Attachment(value = "Чёткий скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
