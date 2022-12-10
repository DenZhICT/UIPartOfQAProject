package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

public class DnsCartPage {

    private final String amountOfCart = ".summary-header__total-items",
            emptyCart = ".empty-message__title-empty-cart",
            deleteBuyButton = ".remove-button__title";

    public DnsCartPage delProductFromCart() {
        step("Нажат на кнопку удалить возле продукта", () ->
                $(deleteBuyButton).click());
        step("Стабильность тестов", () -> {
            while ($(deleteBuyButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становтся не сталбильными
        refresh();
        return this;
    }

    public DnsCartPage checkAmountOfProductInCart() {
        step("Проверить, что продукт был добавлен в корзину", () ->
                $(amountOfCart).shouldHave(text("товар")));
        return this;
    }

    public void checkCartIsEmpty() {
        step("Проверить, что корзина пуста", () ->
                $(emptyCart).shouldHave(text("Корзина пуста")));
    }
}
