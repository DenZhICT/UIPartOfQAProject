package dns.config;

import com.codeborne.selenide.Configuration;

public class WebDriverProvider {

    public void setWebDriverConfiguration() {
        Configuration.baseUrl = "https://www.dns-shop.ru";
        Configuration.browserPosition = "0x0";

        String browser = System.getProperty("browser_name", "chrome");

        if (browser.equals("firefox")){
            Configuration.timeout = 5000; // firefox не успевает прогружать нужные элементы
        }

        Configuration.browser = browser;
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        String env = System.getProperty("environment");
        if (env != null && env.equals("remote")) {
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        }
    }
}
