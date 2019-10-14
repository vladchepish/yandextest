package ru.example.testproject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.example.testproject.pages.MainPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    private MainPage mainPage;

    @DataProvider(name = "data")
    public Object[][] createData1() {
        return new Object[][]{{"погода"}, {"Липецк"}, {"Лото"}};
    }


    @Test(description = "Тест выводящий на экран первый элемент результатов поиска", dataProvider = "data")
    public void testSearch(String val) {
        open("https://yandex.ru/");
        mainPage = new MainPage();
        mainPage.setSearchValue(val);
        List<String> suggestionList = mainPage.getSuggestionList();
        System.out.println(suggestionList.get(0));
    }

}
