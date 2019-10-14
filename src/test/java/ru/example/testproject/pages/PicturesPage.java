package ru.example.testproject.pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PicturesPage {

    private SelenideElement collectionMenu = $("div.collections-menu");
    private SelenideElement mainPicturesBlock = $("div.section_feed");
    private SelenideElement picturesNavLink = $x("//div[@data-name='Картинки']/parent::div");

    public PicturesPage() {
        $(collectionMenu).waitUntil(visible.because("Меню сортировки изображений должно отображаться"), 10000);
    }

    public PicturesPage checkElementsOnPage() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue($(collectionMenu).isDisplayed(), "Меню сортировки изображений должно отображаться");
        soft.assertTrue(picturesNavLink.attr("class").contains("navigation__item_state_selected"),
                "Элемент навигационного меню 'Картинки' должен быть выбран");
        soft.assertTrue($(mainPicturesBlock).isDisplayed(), "Основной блок с изображениями должен отображаться");
        soft.assertAll();
        return this;
    }
}
