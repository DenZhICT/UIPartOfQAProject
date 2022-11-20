package dns.tests.UITests;

import dns.pages.DNSPage;
import dns.base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest") @Tag("All")
@DisplayName("UI тесты на сайт DNS")
public class UiDnsTests extends TestBase {

    DNSPage page = new DNSPage();

    @Tag("City")
    @DisplayName("Смена города")
    @Test
    void cityChangeTest() {
        String city = "Уфа";

        page.openMainPage()
                .clearAll()
                .citySelectorClick()
                .chooseCity(city)
                .checkCity(city);
    }

    @Tag("Search")
    @DisplayName("Работоспособности поиска")
    @Test
    void searchSystemTest() {
        String tech = "Ноутбуки";

        page.openMainPage()
                .clearAll()
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
                .clearAll()
                .chooseMainCatalog(mainCatalogChapter)
                .chooseCatalogById(catalogChapter)
                .chooseCatalogById(subCatalogChapter)
                .checkTitle(subCatalogChapter);
    }

    @Tag("Add") @Tag("Cart")
    @DisplayName("Добавление техники в корзину")
    @Test
    void addTechInCartTest() {
        String tech = "Ноутбуки";

        page.openMainPage()
                .clearAll()
                .inputTextInSearchField(tech)
                .addProductInCart()
                .openPageByWay("/cart")
                .checkAmountOfProductInCart();
    }

    @Tag("Add") @Tag("WishList")
    @DisplayName("Добавление техники в список желаемого")
    @Test
    void addTechInWishListTest() {
        String tech = "Ноутбуки";

        page.openMainPage()
                .clearAll()
                .inputTextInSearchField(tech)
                .addProductInWishList()
                .openPageByWay("/profile/wishlist/")
                .checkAmountOfProductInWishList();
    }

    @Tag("Delete") @Tag("Cart")
    @DisplayName("Удаление техники из корзины")
    @Test
    void delTechFromCartTest() {
        String tech = "Ноутбуки";

        page.openMainPage()
                .clearAll()
                .inputTextInSearchField(tech)
                .addProductInCart()
                .openPageByWay("/cart")
                .checkAmountOfProductInCart()
                .delProductFromCart()
                .checkCartIsEmpty();
    }

    @Tag("Delete") @Tag("WishList")
    @DisplayName("Удаление техники из списока желаемого")
    @Test
    void delTechFromWishListTest() {
        String tech = "Ноутбуки";

        page.openMainPage()
                .clearAll()
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
                .clearAll()
                .clickHelp()
                .checkHelp();
    }
}
