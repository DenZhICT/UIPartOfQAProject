package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class DnsListOfProducts {

    private final String
            subTitle = ".products-list__group-title",
            title = ".title",
            waitForRedirect = "[data-redirect='https://www.dns-shop.ru/cart/']",
            addBuyButton = ".button-ui_passive",
            addWishButton = ".wishlist-btn",
            deleteBuyButton = ".remove-button__title",

    deleteWishButton = ".button-ui_done";

    public DnsListOfProducts addProductInCart() {
        step("Нажать на кнопку \"Купить\" возле продукта", () ->
                $(addBuyButton).click());
        step("Стабильность тестов", () -> {
            while (!$(waitForRedirect).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DnsListOfProducts addProductInWishList() {
        step("Нажать на конпку в виде сердечка возле продукта", () ->
                $(addWishButton).click());
        step("Стабильность тестов", () -> {
            while (!$(deleteWishButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DnsListOfProducts isItEnd() {
        step("Дойти до финального подкатолога по поиску", () -> {
            while ($(subTitle).exists()) {
                $(subTitle).click();
            }
        });
        return this;
    }

    public void checkTitle(String title) {
        step(format("Проверить, что в заголовке написано %s", title), () ->
                $(this.title).shouldHave(text(title)));
    }
}
