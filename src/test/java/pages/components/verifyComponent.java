package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.title;
import static com.codeborne.selenide.WebDriverConditions.url;

public class verifyComponent {

    SelenideElement articleTitlePage = $x("//h1[@class='article-head__title']");

    public verifyComponent verifyUrl(String pageUrl){
        webdriver().shouldHave(url(pageUrl));
        return this;
    }

    public verifyComponent verifySiteTitle(String titleText){
        webdriver().shouldHave(title(titleText));
        return this;
    }

    public verifyComponent verifyPageArticleText(String titleText){
        articleTitlePage.shouldHave(text(titleText));
        return this;
    }
}
