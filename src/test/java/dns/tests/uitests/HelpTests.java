package dns.tests.uitests;

import dns.pages.DnsHelpPage;
import dns.pages.DnsMainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UITest")
@Tag("All")
@Tag("Help")
@DisplayName("UI тесты на сайт DNS")
public class HelpTests extends TestBase {

    @DisplayName("Работоспособность помощи")
    @Test
    void helpTest() {
        DnsMainPage mainPage = new DnsMainPage();
        DnsHelpPage helpPage = new DnsHelpPage();

        mainPage
                .openMainPage()
                .clickHelp();
        helpPage.checkHelp();
    }
}
