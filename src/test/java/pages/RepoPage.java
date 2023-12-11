package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RepoPage {

    private SelenideElement issueTab = $("#issues-tab");

    public RepoPage clickTabIssue(){
        issueTab.click();

        return this;
    }

}
