package ru.example.testproject.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.example.testproject.pages.MainPage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    private MainPage mainPage;

    @DataProvider(name = "data")
    public Iterator<Object[]> createData1() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test_data.txt")));
        String line = reader.readLine();
        while (line != null){
            list.add(new Object[]{line});
            line = reader.readLine();
        }
        return list.iterator();
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
