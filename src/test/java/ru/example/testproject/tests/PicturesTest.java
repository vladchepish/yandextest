package ru.example.testproject.tests;

import org.testng.annotations.Test;
import ru.example.testproject.pages.MainPage;
import ru.example.testproject.pages.PicturesPage;

import static com.codeborne.selenide.Selenide.open;

public class PicturesTest {

    private MainPage mainPage;
    private PicturesPage picturesPage;

    @Test(description = "Тест проверяющий отображение страницы 'Картинки'")
    public void testPicturesPage() {
        open("https://yandex.ru/");
        mainPage = new MainPage();
        picturesPage = mainPage.goToPicturesPage();
        picturesPage.checkElementsOnPage();
    }

}
