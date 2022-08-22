import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestReadMore {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://dev-magento2-migration.mylittleroom.ch/";
        Configuration.timeout = 10000;
    }

    @CsvFileSource (resources = "MLR-810-URLs.csv")
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on DESKTOP (1280x1024)")
    void readMore_desktop (String storePrefix, String url_path) {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1280x1024";
        PO.readMore(storePrefix, url_path);
    }

    @CsvFileSource (resources = "MLR-810-URLs.csv")
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on MOBILE (390x844)")
    void readMore_mobile (String storePrefix, String url_path) {
        Configuration.browser = "chrome";
        Configuration.browserSize = "390x844";
        PO.readMore(storePrefix, url_path);
    }

    @CsvFileSource (resources = "MLR-810-URLs.csv")
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on TABLET (820x1180)")
    void readMore_tablet (String storePrefix, String url_path) {
        Configuration.browser = "chrome";
        Configuration.browserSize = "820x1180";
        PO.readMore(storePrefix, url_path);
    }
}

