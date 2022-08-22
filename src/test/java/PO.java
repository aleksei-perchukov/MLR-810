

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PO {
    static void readMore (String storePrefix, String url_path) {
        open(storePrefix + url_path + ".html");
        if($(".category-view").$(".readmore").isDisplayed()) {
            $(".category-view").$(".readmore").shouldBe(visible);
            $(".category-view").$(".readmore").click();
            $(".category-view").$(".readless").shouldBe(visible);
            $(".category-view").$(".readless").click();
            System.out.println(storePrefix + url_path + ", OK");
        } else if ($(".category-view").isDisplayed()) {
            if (storePrefix == "en/") {
                $(".category-view").shouldNotHave(text("Read more"));
            }
            if (storePrefix == "de/") {
                $(".category-view").shouldNotHave(text("Mehr lesen"));
            }
            if (storePrefix == "fr/") {
                $(".category-view").shouldNotHave(text("Raccourcir le texte"));
            }
            System.out.println(storePrefix + url_path + ", no 'read more' is visible");
        } else if ($("#maincontent").isDisplayed()) {
            if (storePrefix == "en/") {
                $("#maincontent").shouldNotHave(text("Read more"));
            }
            if (storePrefix == "de/") {
                $("#maincontent").shouldNotHave(text("Mehr lesen"));
            }
            if (storePrefix == "fr/") {
                $("#maincontent").shouldNotHave(text("Raccourcir le texte"));
            }
        }
        else if ($("div.product.attribute.overview.initial").isDisplayed()) {
            $("div.product.attribute.overview.initial").shouldBe(visible);
            System.out.println(storePrefix + url_path + ", PRODUCT PAGE");
        }
        else if ($(".img-responsive.initial.loading").isDisplayed()) {
            $(".img-responsive.initial.loading").shouldBe(visible);
            System.out.println(storePrefix + url_path + ", gift card mobile/tablet");
        }
        else {
            $(".not-found-page__content.initial").shouldBe(visible);
            System.out.println(storePrefix + url_path + ", 404");
        }
    }
}
