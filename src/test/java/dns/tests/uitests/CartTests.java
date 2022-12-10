package dns.tests.uitests;

import dns.pages.DnsCartPage;
import dns.pages.DnsListOfProducts;
import dns.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@Tag("Cart")
@DisplayName("UI тесты на сайт DNS")
public class CartTests extends TestBase {
    private final String tech = "Ноутбуки";
    DnsMainPage mainPage = new DnsMainPage();
    DnsListOfProducts productPage = new DnsListOfProducts();
    DnsCartPage cartPage = new DnsCartPage();

    @Tag("Add")
    @DisplayName("Добавление техники в корзину")
    @Test
    void addTechInCartTest() {
        mainPage.openMainPage()
                .inputTextInSearchField(tech);
        productPage
                .addProductInCart();
        mainPage
                .openPageByWay("/cart");
        cartPage
                .checkAmountOfProductInCart();
    }

    @Tag("Delete")
    @DisplayName("Удаление техники из корзины")
    @Test
    void delTechFromCartTest() {
        mainPage.openMainPage()
                .inputTextInSearchField(tech);
        productPage
                .addProductInCart();
        mainPage
                .openPageByWay("/cart");
        cartPage
                .checkAmountOfProductInCart()
                .delProductFromCart()
                .checkCartIsEmpty();
    }
}