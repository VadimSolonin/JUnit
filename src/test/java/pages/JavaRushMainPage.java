package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JavaRushMainPage {
    SelenideElement mainPageSubtitleText = $x("//h1[@class='hero-title__main']");
    ElementsCollection sidebarNavLabel = $$(".sidebar-nav-link .sidebar-nav-label"),
            headerLink = $$(".guest-nav__link");

    public JavaRushMainPage openPage() {
        open("");
        mainPageSubtitleText.shouldHave(text("Курсы Java для начинающих"));
        return this;
    }

    public JavaRushMainPage clickNavbarLinkByDataTarget(String value) {
        SelenideElement target = $("[data-site-tour-target=" + value + "]");
        target.click();
        return this;
    }

    public JavaRushMainPage clickNavbarLinkBySearchingText(String value) {
        sidebarNavLabel.findBy(text(value)).click();
        return this;
    }

    public JavaRushMainPage clickHeaderLink(String value) {
        headerLink.findBy(text(value)).click();
        return this;
    }
}
