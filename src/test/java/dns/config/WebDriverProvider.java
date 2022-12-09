package dns.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    public void setWebDriverConfiguration() {

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browserPosition = config.getBrowserPosition();

        Configuration.browser = System.getProperty("browser_name", config.getBrowserName());
        Configuration.browserVersion = System.getProperty("browser_version", config.getBrowserVersion());
        Configuration.browserSize = System.getProperty("browser_size", config.getBrowserSize());

        String env = System.getProperty("environment");
        if (env != null && env.equals("remote")) {
            Configuration.remote = config.getRemoteUrl();

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
