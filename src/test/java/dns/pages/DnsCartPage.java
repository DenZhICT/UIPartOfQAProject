package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

public class DnsCartPage {

    public DnsCartPage delProductFromCart() {
        String deleteBuyButton = ".remove-button__title";
        step("Нажат на кнопку удалить возле продукта", () ->
                $(deleteBuyButton).click());
        step("Стабильность тестов", () -> {
            $(deleteBuyButton).shouldNotBe(visible);
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становтся не сталбильными
        refresh();
        return this;
    }

    public DnsCartPage checkAmountOfProductInCart() {
        String amountOfCart = ".summary-header__total-items";
        step("Проверить, что продукт был добавлен в корзину", () ->
                $(amountOfCart).shouldHave(text("товар")));
        return this;
    }

    public void checkCartIsEmpty() {
        String emptyCart = ".empty-message__title-empty-cart";
        step("Проверить, что корзина пуста", () ->
                $(emptyCart).shouldHave(text("Корзина пуста")));
    }
}
