package ru.example.testproject.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement searchInput = $("form[role='search'] input#text");
    private SelenideElement suggestBlock = $("div.suggest2__content");
    private ElementsCollection suggestList = $$("li.suggest2-item");
    private SelenideElement picturesLisk = $("a[data-id='images']");

    public MainPage() {
        searchInput.waitUntil(visible.because("Строка поиска должна отображаться на главной странице"), 10000);
    }

    public MainPage setSearchValue(String val) {
        $(searchInput).setValue(val);
        return this;
    }

    public List<String> getSuggestionList() {
        $(suggestBlock).waitUntil(visible.because("Дропдаун со списком подсказок должен отображаться"), 10000);
        List<String> result = new ArrayList<>();
        for (SelenideElement e : suggestList) {
            result.add(e.text().replaceAll("\n", " "));
        }
        return result;
    }

    public PicturesPage goToPicturesPage() {
        $(picturesLisk).click();
        return new PicturesPage();
    }
}
