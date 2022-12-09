package dns.pages;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class DNSPage {

    private final String citySelect = ".city-select__text",
            cityInput = ".base-ui-input-search__input_YOW",
            cityRaw = ".modal-row",
            searchField = ".ui-input-search__input",
            subTitle = ".products-list__group-title",
            title = ".title",
            mainCatalogMenu = ".menu-desktop__root-title",
            amountOfCart = ".summary-header__total-items",
            amountOfWishList = ".profile-wishlist__sum",
            emptyCart = ".empty-message__title-empty-cart",
            emptyWishList = ".profile-wishlist__empty-text",
            help = ".navmenu__submenu-link",
            helpHead = ".help__head",
            animation = ".animation_active",
            waitForRedirect = "[data-redirect='https://www.dns-shop.ru/cart/']",
            addBuyButton = ".button-ui_passive",
            deleteBuyButton = ".remove-button__title",
            addWishButton = ".wishlist-btn",
            deleteWishButton = ".button-ui_done";

    public DNSPage openPageByWay(String way) {
        step(format("Перейти по пути %s относительно главного", way), () ->
                open(way));
        return this;
    }

    public DNSPage openMainPage() {
        step("Открыть главную страницу DNS", () ->
                open("/"));
        return this;
    }

    public DNSPage citySelectorClick() {
        step("Нажать на выбор города", () ->
                $(citySelect).click());
        step("Стабильность тестов", () -> {
            while ($$(animation).size() == 2) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DNSPage chooseCity(String city) {
        step(format("Ввести в поисковик %s и нажать на первый предложенный вариант", city), () -> {
            $(cityInput).setValue(city);
            $$(cityRaw).findBy(text(city)).click();
        });
        return this;
    }

    public DNSPage inputTextInSearchField(String text) {
        step(format("Ввести в поисковик сайта %s и нажать Enter", text), () ->
                $$(searchField).exclude(id("null")).first().setValue(text).pressEnter());
        return this;
    }

    public DNSPage chooseMainCatalog(String catalog) {
        step(format("Выбрать раздел католога \"%s\"", catalog), () ->
                $$(mainCatalogMenu).findBy(text(catalog)).click());
        return this;
    }

    public DNSPage chooseCatalogById(String catalog) {
        step(format("Выбрать раздел католога \"%s\"", catalog), () ->
                $(format("[id='%s']", catalog)).parent().click());
        return this;
    }

    public DNSPage addProductInCart() {
        step("Нажать на кнопку \"Купить\" возле продукта", () ->
                $(addBuyButton).click());
        step("Стабильность тестов", () -> {
            while (!$(waitForRedirect).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DNSPage addProductInWishList() {
        step("Нажать на конпку в виде сердечка возле продукта", () ->
                $(addWishButton).click());
        step("Стабильность тестов", () -> {
            while (!$(deleteWishButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DNSPage delProductFromCart() {
        step("Нажат на кнопку удалить возле продукта", () ->
                $(deleteBuyButton).click());
        step("Стабильность тестов", () -> {
            while ($(deleteBuyButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становтся не сталбильными
        refresh();
        return this;
    }

    public DNSPage delProductFromWishList() {
        step("Нажать на конпку в виде сердечка возле продукта", () ->
                $(deleteWishButton).click());
        step("Стабильность тестов", () -> {
            while ($(deleteWishButton).exists()) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становтся не сталбильными
        refresh();
        return this;
    }

    public DNSPage clickHelp() {
        step("Нажать на \"Помощь\"", () ->
                $$(help).findBy(text("Помощь")).click());
        return this;
    }

    public void checkCity(String city) {
        step("Проверить изменение города", () ->
                checkTextByLocator(citySelect, city));
    }

    public DNSPage isItEnd() {
        step("Дойти до финального подкатолога по поиску", () -> {
            while ($(subTitle).exists()) {
                $(subTitle).click();
            }
        });
        return this;
    }

    public void checkTitle(String title) {
        step(format("Проверить, что в заголовке написано %s", title), () ->
                checkTextByLocator(this.title, title));
    }

    public DNSPage checkAmountOfProductInCart() {
        step("Проверить, что продукт был добавлен в корзину", () ->
                checkTextByLocator(amountOfCart, "товар"));
        return this;
    }

    public DNSPage checkAmountOfProductInWishList() {
        step("Проверить, что продукт был добавлен в список желаемого", () ->
                checkTextByLocator(amountOfWishList, "товар"));
        return this;
    }

    public void checkCartIsEmpty() {
        step("Проверить, что корзина пуста", () ->
                checkTextByLocator(emptyCart, "Корзина пуста"));
    }

    public void checkWishListIsEmpty() {
        step("Проверить, что список желаемого пуст", () ->
                checkTextByLocator(emptyWishList, "В списке пока нет ни одного избранного товара"));
    }

    public void checkHelp() {
        step("Проверить, что появилась страницы помощи", () ->
                checkTextByLocator(helpHead, "Помощь"));
    }

    private void checkTextByLocator(String locator, String text) {
        $(locator).shouldHave(text(text));
    }
}
