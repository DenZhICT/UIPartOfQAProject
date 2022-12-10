package dns.pages;

import static com.codeborne.selenide.Condition.id;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class DnsMainPage {

    private final String citySelect = ".city-select__text",
            animation = ".animation_active",
            cityInput = ".base-ui-input-search__input_YOW",
            cityRaw = ".modal-row",
            searchField = ".ui-input-search__input",
            mainCatalogMenu = ".menu-desktop__root-title",
            help = ".navmenu__submenu-link";


    public DnsMainPage openPageByWay(String way) {
        step(format("Перейти по пути %s относительно главного", way), () ->
                open(way));
        return this;
    }

    public DnsMainPage openMainPage() {
        step("Открыть главную страницу DNS", () ->
                open("/"));
        return this;
    }

    public DnsMainPage citySelectorClick() {
        step("Нажать на выбор города", () ->
                $(citySelect).click());
        step("Стабильность тестов", () -> {
            while ($$(animation).size() == 2) {
            }
        }); //DNS-сайт нестабильный по времени отклика, приходиться делать задержку, иначе тесты тоже становятся не сталбильными
        return this;
    }

    public DnsMainPage chooseCity(String city) {
        step(format("Ввести в поисковик %s и нажать на первый предложенный вариант", city), () -> {
            $(cityInput).setValue(city);
            $$(cityRaw).findBy(text(city)).click();
        });
        return this;
    }

    public DnsMainPage inputTextInSearchField(String text) {
        step(format("Ввести в поисковик сайта %s и нажать Enter", text), () ->
                $$(searchField).exclude(id("null")).first().setValue(text).pressEnter());
        return this;
    }

    public DnsMainPage chooseMainCatalog(String catalog) {
        step(format("Выбрать раздел католога \"%s\"", catalog), () ->
                $$(mainCatalogMenu).findBy(text(catalog)).click());
        return this;
    }

    public DnsMainPage clickHelp() {
        step("Нажать на \"Помощь\"", () ->
                $$(help).findBy(text("Помощь")).click());
        return this;
    }

    public void checkCity(String city) {
        step("Проверить изменение города", () ->
                $(citySelect).shouldHave(text(city)));
    }
}
