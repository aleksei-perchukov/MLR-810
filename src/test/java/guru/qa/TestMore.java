package guru.qa;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestMore {

    static void readMore (String storePrefix, String url_path) {
        step("Open {0}{1} URL)", () -> open(storePrefix + url_path + ".html"));
        step("Assert that 'Read more' button is visible", () -> {
            $(".category-view").$(".readmore").shouldBe(visible);
        });
        step("Click on 'Read more' button", () -> $(".category-view").$(".readmore").click());
        step("Assert that 'Read more' button changed to 'Read less' button", () -> {
            $(".category-view").$(".readless").shouldBe(visible);
        });
        step("Click on 'Read less' button", () -> $(".category-view").$(".readless").click());
        step("Adding attachments (Source code, Screenshot and video)", TestBase::addAttachments);
        step("Close browser", Selenide::closeWindow);
        }
}
