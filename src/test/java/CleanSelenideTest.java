import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("Чистый Selenide")
public class CleanSelenideTest extends TestBase {

    @DisplayName("Поиск " + ISSUE)
    @Test
    void searchIssueTest() {

        open("");
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[href=\"/selenide/selenide\"]").click();
        $("#issues-tab").click();
        $("#issue_2579_link").shouldHave(Condition
                .partialText("UnsupportedCommandException"));

    }


}
