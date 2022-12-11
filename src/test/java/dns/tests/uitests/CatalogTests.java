package dns.tests.uitests;

import dns.pages.DnsCatalogPage;
import dns.pages.DnsListOfProducts;
import dns.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@Tag("Catalog")
@DisplayName("UI тесты на сайт DNS")
public class CatalogTests extends TestBase {
    private final String tech = "Ноутбуки";
    DnsMainPage mainPage = new DnsMainPage();
    DnsListOfProducts productsPage = new DnsListOfProducts();

    @Tag("Search")
    @DisplayName("Работоспособности поиска")
    @Test
    void searchSystemTest() {
        mainPage.openMainPage()
                .inputTextInSearchField(tech);
        productsPage
                .isItEnd()
                .checkTitle(tech);
    }

    @Tag("CurrentCatalog")
    @DisplayName("Работоспособность католога")
    @Test
    void catalogTest() {
        DnsCatalogPage catalogPage = new DnsCatalogPage();

        String mainCatalogChapter = "Отдых и развлечения",
                catalogChapter = "Развлечения и хобби",
                subCatalogChapter = "Настольные игры";

        mainPage.openMainPage()
                .chooseMainCatalog(mainCatalogChapter);
        catalogPage
                .chooseCatalogById(catalogChapter)
                .chooseCatalogById(subCatalogChapter);
        productsPage.checkTitle(subCatalogChapter);
    }
}
