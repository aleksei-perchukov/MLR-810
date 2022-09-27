package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TestReadMore extends TestBase {
    public static final String readCSVPath = "src/test/resources/MLR-810-URLs.csv";
    public static final String writeCSVPathDesktop = "src/test/resources/MLR-810-URLs-Desktop-filtered.csv";
    public static final String writeCSVPathMobile = "src/test/resources/MLR-810-URLs-Mobile-filtered.csv";
    public static final String writeCSVPathTablet = "src/test/resources/MLR-810-URLs-Tablet-filtered.csv";
    public static String desktopResolution = "1920x1080";
    public static String mobileResolution = "390x844";
    public static String tabletResolution = "820x1180";
    public static Boolean needToRebaseDesktopCSV = Boolean.valueOf(System.getProperty("RebaseDesktopCSV"));
    public static Boolean needToRebaseMobileCSV = Boolean.valueOf(System.getProperty("RebaseMobileCSV"));
    public static Boolean needToRebaseTabletCSV = Boolean.valueOf(System.getProperty("RebaseTabletCSV"));

    @Tag("DesktopTests")
    @CsvFileSource (files = writeCSVPathDesktop)
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on DESKTOP (1280x1024)")
    void readMore_desktop (String storePrefix, String url_path) {
        Configuration.browserSize = desktopResolution;
        TestMore.readMore(storePrefix, url_path);
        System.out.println(storePrefix + url_path + ", DESKTOP OK");
    }

    @Tag("MobileTests")
    @CsvFileSource (files = writeCSVPathMobile)
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on MOBILE (390x844)")
    void readMore_mobile (String storePrefix, String url_path) {
        Configuration.browserSize = mobileResolution;
        TestMore.readMore(storePrefix, url_path);
        System.out.println(storePrefix + url_path + ", MOBILE OK");
    }

    @Tag("TabletTests")
    @CsvFileSource (files = writeCSVPathTablet)
    @ParameterizedTest (name = "{0}{1} contains 'READ MORE' on TABLET (820x1180)")
    void readMore_tablet (String storePrefix, String url_path) {
        Configuration.browserSize = tabletResolution;
        TestMore.readMore(storePrefix, url_path);
        System.out.println(storePrefix + url_path + ", TABLET OK");
    }
}

