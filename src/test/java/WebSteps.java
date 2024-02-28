import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Ищем репозиторий {repo}")
    public void searchForRepositoryLink(String repo) {
        $("span.flex-1").click();
        $("#query-builder-test").setValue(repo);
        $("#query-builder-test").submit();
    }
    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }
    @Step("Открываем таб Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

}
