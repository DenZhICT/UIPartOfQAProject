package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class DnsListOfProducts {

    public DnsListOfProducts addProductInCart() {
        String addBuyButton = ".button-ui_passive",
                waitForRedirect = "[data-redirect='https://www.dns-shop.ru/cart/']";

        step("Нажать на кнопку \"Купить\" возле продукта", () ->
                $(addBuyButton).click());
        step("Стабильность тестов", () -> {
            while (!$(waitForRedirect).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DnsListOfProducts addProductInWishList() {
        String addWishButton = ".wishlist-btn",
                deleteWishButton = ".button-ui_done";

        step("Нажать на конпку в виде сердечка возле продукта", () ->
                $(addWishButton).click());
        step("Стабильность тестов", () -> {
            while (!$(deleteWishButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DnsListOfProducts isItEnd() {
        String subTitle = ".products-list__group-title";

        step("Дойти до финального подкатолога по поиску", () -> {
            while ($(subTitle).exists()) {
                $(subTitle).click();
            }
        });
        return this;
    }

    public void checkTitle(String title) {
        String titleSelector = ".title";

        step(format("Проверить, что в заголовке написано %s", title), () ->
                $(titleSelector).shouldHave(text(title)));
    }
}
