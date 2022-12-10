package dns.tests.uitests;


import dns.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@Tag("City")
@DisplayName("UI тесты на сайт DNS")
public class CityTests extends TestBase {

    @DisplayName("Смена города")
    @Test
    void cityChangeTest() {
        DnsMainPage mainPage = new DnsMainPage();
        String city = "Уфа";

        mainPage.openMainPage()
                .citySelectorClick()
                .chooseCity(city)
                .checkCity(city);
    }
}
