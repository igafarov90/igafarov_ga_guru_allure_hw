package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private final SelenideElement searchResult = $("[href=\"/selenide/selenide\"]");

    public SearchResultsPage clickByRepoLinks() {
        searchResult.click();

        return this;

    }
}
