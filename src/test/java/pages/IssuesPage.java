package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class IssuesPage {

    private SelenideElement issues = $("#issue_2579_link");

    public IssuesPage checkIssueText(String value){
        issues.shouldHave(Condition.partialText(value));
        return this;
    }
}
