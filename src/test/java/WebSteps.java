import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.IssuesPage;
import pages.LoginPage;
import pages.RepoPage;
import pages.SearchResultsPage;

public class WebSteps {

    LoginPage loginPage = new LoginPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    IssuesPage issuesPage = new IssuesPage();
    RepoPage repoPage = new RepoPage();

    @Step("Открываем главную страницу сайта " + TestBase.BASEURL)
    public void openMainPage() {
        loginPage.openSite();
    }

    @Step("Поиск репозитория {repo}")
    public void searchRepo(String repo) {
        loginPage.fillInputSearch(repo);
    }

    @Step("Переходим по ссылке из списка результатов")
    public void clickByRepoLinks() {
        searchResultsPage.clickByRepoLinks();
    }

    @Step("Клик в таб issue")
    public void clickTabIssue() {
        repoPage.clickTabIssue();
    }

    @Step("Проверка наличия Issues {issue}")
    public void checkIssueText(String issue) {
        issuesPage.checkIssueText(issue);
    }

    @Attachment(value = "скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

}