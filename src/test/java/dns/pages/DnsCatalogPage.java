package dns.pages;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class DnsCatalogPage {

    public DnsCatalogPage chooseCatalogById(String catalog) {
        step(format("Выбрать раздел католога \"%s\"", catalog), () ->
                $(format("[id='%s']", catalog)).parent().click());
        return this;
    }
}
