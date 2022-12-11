package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;
import static io.qameta.allure.Allure.step;

public class DnsWishListPage {

    public DnsWishListPage delProductFromWishList() {
        String deleteWishButton = ".button-ui_done";

        step("Нажать на конпку в виде сердечка возле продукта", () ->
                $(deleteWishButton).click());
        step("Стабильность тестов", () -> {
            $(deleteWishButton).shouldNotBe(visible);
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становтся не сталбильными
        refresh();
        return this;
    }

    public DnsWishListPage checkAmountOfProductInWishList() {
        String amountOfWishList = ".profile-wishlist__sum";

        step("Проверить, что продукт был добавлен в список желаемого", () ->
                $(amountOfWishList).shouldHave(text("товар")));
        return this;
    }

    public void checkWishListIsEmpty() {
        String emptyWishList = ".profile-wishlist__empty-text";

        step("Проверить, что список желаемого пуст", () ->
                $(emptyWishList).shouldHave(text("В списке пока нет ни одного избранного товара")));
    }
}
