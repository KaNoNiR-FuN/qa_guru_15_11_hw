package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSoftAssertionsTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Проверка наличия примеров JUnit5 на странице SoftAssertions")
    @Test
    public void junit5AtSoftAssertionsTest() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $$(".details-reset").findBy(visible).shouldBe(text("SoftAssertions")).click();
        $(".markdown-body").shouldBe(text("3. Using JUnit5 extend test class:"));

    }
}
