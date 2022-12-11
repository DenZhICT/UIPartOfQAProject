package dns.tests.uitests;

import dns.pages.DnsListOfProducts;
import dns.pages.DnsMainPage;
import dns.pages.DnsWishListPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@DisplayName("UI тесты на сайт DNS")
public class WishListTests extends TestBase {
    private final String tech = "Ноутбуки";
    DnsMainPage mainPage = new DnsMainPage();
    DnsListOfProducts productPage = new DnsListOfProducts();
    DnsWishListPage wishListPage = new DnsWishListPage();

    @Tag("Add")
    @Tag("WishList")
    @DisplayName("Добавление техники в список желаемого")
    @Test
    void addTechInWishListTest() {
        mainPage
                .openMainPage()
                .inputTextInSearchField(tech);
        productPage
                .addProductInWishList()
                .openPageByWay("/profile/wishlist/");
        wishListPage.checkAmountOfProductInWishList();
    }

    @Tag("Delete")
    @Tag("WishList")
    @DisplayName("Удаление техники из списока желаемого")
    @Test
    void delTechFromWishListTest() {
        mainPage
                .openMainPage()
                .inputTextInSearchField(tech);
        productPage
                .addProductInWishList()
                .openPageByWay("/profile/wishlist/");
        wishListPage
                .checkAmountOfProductInWishList()
                .delProductFromWishList()
                .checkWishListIsEmpty();
    }
}