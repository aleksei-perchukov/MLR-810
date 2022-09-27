package guru.qa;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestMore {

    static void readMore(String storePrefix, String url_path) {
        step("Open " + storePrefix + url_path + " URL", () -> open(storePrefix + url_path + ".html"));
        step("Assert that 'Read more' button is visible", () -> {
            $(".category-description-wrapper").$(".readmore").shouldBe(visible);
        });
        step("Click on 'Read more' button", () -> $(".category-description-wrapper").$(".readmore").click());
        step("Assert that 'Read more' button changed to 'Read less' button", () -> {
            $(".category-description-wrapper").$(".readless").shouldBe(visible);
        });
        step("Click on 'Read less' button", () -> $(".category-description-wrapper").$(".readless").click());
    }
}
