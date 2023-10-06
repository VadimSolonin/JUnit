package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import pages.JavaRushMainPage;
import pages.components.verifyComponent;

public class TestBase {
    JavaRushMainPage javaRushMainPage = new JavaRushMainPage();
    verifyComponent verifyComponent = new verifyComponent();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://javarush.com/";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
