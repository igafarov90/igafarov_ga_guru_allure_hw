import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.IssuesPage;
import pages.LoginPage;
import pages.RepoPage;
import pages.SearchResultsPage;

import java.nio.charset.StandardCharsets;

import static io.qameta.allure.Allure.step;

@DisplayName("Использование lambda steps")
public class LambdaStepsTest extends TestBase {

    LoginPage loginPage = new LoginPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    IssuesPage issuesPage = new IssuesPage();
    RepoPage repoPage = new RepoPage();

    @Test()
    @Owner("igafarov")
    @DisplayName("Поиск " + ISSUE)
    @Story("Проверка Issue")
    @Severity(SeverityLevel.CRITICAL)
    void searchIssue() {

        step("Открываем главную страницу сайта " + BASEURL, () -> {
            loginPage.openSite();
        });

        step("Поиск " + REPOSITORY, () -> {
            loginPage.fillInputSearch(REPOSITORY);
        });

        step("Переходим по ссылке " + REPOSITORY, () -> {
            searchResultsPage.clickByRepoLinks();
        });
        step("Клик в таб issue", () -> {
            repoPage.clickTabIssue();
        });
        step("Проверяем наличие " + ISSUE + " по вхождению текста", () -> {
            issuesPage.checkIssueText(ISSUE);
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }

}
