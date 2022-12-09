package dns.tests.uitests;

import dns.pages.DNSPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@DisplayName("UI тесты на сайт DNS")
public class UiDnsTests extends TestBase {

    DNSPage page = new DNSPage();

    private String tech = "Ноутбуки";

    @Tag("City")
    @DisplayName("Смена города")
    @Test
    void cityChangeTest() {
        String city = "Уфа";

        page.openMainPage()
                .citySelectorClick()
                .chooseCity(city)
                .checkCity(city);
    }

    @Tag("Search")
    @DisplayName("Работоспособности поиска")
    @Test
    void searchSystemTest() {
        page.openMainPage()
                .inputTextInSearchField(tech)
                .isItEnd()
                .checkTitle(tech);
    }

    @Tag("Catalog")
    @DisplayName("Работоспособность католога")
    @Test
    void catalogTest() {
        String mainCatalogChapter = "Отдых и развлечения",
                catalogChapter = "Развлечения и хобби",
                subCatalogChapter = "Настольные игры";

        page.openMainPage()
                .chooseMainCatalog(mainCatalogChapter)
                .chooseCatalogById(catalogChapter)
                .chooseCatalogById(subCatalogChapter)
                .checkTitle(subCatalogChapter);
    }

    @Tag("Add")
    @Tag("Cart")
    @DisplayName("Добавление техники в корзину")
    @Test
    void addTechInCartTest() {
        page.openMainPage()
                .inputTextInSearchField(tech)
                .addProductInCart()
                .openPageByWay("/cart")
                .checkAmountOfProductInCart();
    }

    @Tag("Add")
    @Tag("WishList")
    @DisplayName("Добавление техники в список желаемого")
    @Test
    void addTechInWishListTest() {
        page.openMainPage()
                .inputTextInSearchField(tech)
                .addProductInWishList()
                .openPageByWay("/profile/wishlist/")
                .checkAmountOfProductInWishList();
    }

    @Tag("Delete")
    @Tag("Cart")
    @DisplayName("Удаление техники из корзины")
    @Test
    void delTechFromCartTest() {
        page.openMainPage()
                .inputTextInSearchField(tech)
                .addProductInCart()
                .openPageByWay("/cart")
                .checkAmountOfProductInCart()
                .delProductFromCart()
                .checkCartIsEmpty();
    }

    @Tag("Delete")
    @Tag("WishList")
    @DisplayName("Удаление техники из списока желаемого")
    @Test
    void delTechFromWishListTest() {
        page.openMainPage()
                .inputTextInSearchField(tech)
                .addProductInWishList()
                .openPageByWay("/profile/wishlist/")
                .checkAmountOfProductInWishList()
                .delProductFromWishList()
                .checkWishListIsEmpty();
    }

    @Tag("Help")
    @DisplayName("Работоспособность помощи")
    @Test
    void helpTest() {
        page.openMainPage()
                .clickHelp()
                .checkHelp();
    }
}
