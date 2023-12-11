import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Использование web steps")
public class AnnotatedStepsTest extends TestBase {

    WebSteps steps = new WebSteps();

    @Test
    @DisplayName("Поиск " + ISSUE)
    void annotatedStepsTest() {

        steps.openMainPage();
        steps.searchRepo(REPOSITORY);
        steps.clickByRepoLinks();
        steps.clickTabIssue();
        steps.checkIssueText(ISSUE);
        steps.attachScreenshot();
    }

}
