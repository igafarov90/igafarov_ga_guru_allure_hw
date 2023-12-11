package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private SelenideElement searchMenu = $(".search-input"),
    searchInput = $("#query-builder-test");

    public LoginPage openSite(){
        open("");

        return this;
    }

    public LoginPage fillInputSearch(String value){
        searchMenu.click();
        searchInput.setValue(value)
                .pressEnter();

        return this;
    }
}
