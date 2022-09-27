package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.opencsv.exceptions.CsvValidationException;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

import static guru.qa.ProgramCSV.*;

public class TestBase {
    static String remote = System.getProperty("selenide.remote");
    @BeforeAll
    static void configure() throws CsvValidationException, IOException {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        Configuration.baseUrl = "https://demoqa.com";
            if (remote != null) {
                Configuration.remote = "https://user1:1234@" + remote;
            }
            if (TestReadMore.needToRebaseDesktopCSV = true) {
                newReaderDesktop();
            }
            if (TestReadMore.needToRebaseMobileCSV = true) {
                newReaderMobile();
            }
            if (TestReadMore.needToRebaseTabletCSV = true) {
                newReaderTablet();
            }
    }

    static void addAttachments() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        if (remote != null) {
            Attach.addVideo();
        }
    }

    @AfterAll
    static void Bye() {
        System.out.println("Bye-bye!");
    }
}