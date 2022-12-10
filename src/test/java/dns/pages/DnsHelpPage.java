package dns.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class DnsHelpPage {

    private final String
            helpHead = ".help__head";

    public void checkHelp() {
        step("Проверить, что появилась страницы помощи", () ->
                $(helpHead).shouldHave(text("Помощь")));
    }
}
