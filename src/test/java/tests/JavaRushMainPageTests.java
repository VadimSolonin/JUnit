package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.JavaRushMainPage;
import pages.components.VerifyComponent;

import java.util.stream.Stream;


@Tags({@Tag("UI"), @Tag("MainPage")})
public class JavaRushMainPageTests extends TestBase {
    JavaRushMainPage javaRushMainPage = new JavaRushMainPage();
    VerifyComponent verifyComponent = new VerifyComponent();

    @CsvSource(value = {
            "QUESTS, https://javarush.com/quests",
            "TASKS, https://javarush.com/tasks",
            "QUIZZES, https://javarush.com/quizzes"
    })
    @ParameterizedTest(name = "Открытие страницы {1} при клике на {0}")
    @Tag("Link")
    void openStudyGroupLinkTest(String target, String actualUrl) {
        javaRushMainPage.openPage();
        javaRushMainPage.clickNavbarLinkByDataTarget(target);
        verifyComponent.verifyUrl(actualUrl);
    }

    @CsvFileSource(resources = "/communitySidebarValues.csv")
    @ParameterizedTest(name = "При нажатии на кнопку боковой панели {0} открывается страница с Заголовком {1}")
    @Tag("Link")
    void openCommunityGroupLinkTest(String value, String url) {
        javaRushMainPage.openPage();
        javaRushMainPage.clickNavbarLinkBySearchingText(value);
        verifyComponent.verifySiteTitle(url);
    }

    static Stream<Arguments> selenideButtonsTest() {
        return Stream.of(
                Arguments.of("ОТЗЫВЫ", "Отзывы"),
                Arguments.of("О НАС", "О JavaRush")
        );
    }

    @MethodSource("selenideButtonsTest")
    @ParameterizedTest(name = "При нажатии на кнопку навигации {0} открывается страница с заголовком {1} первого уровня")
    @Tag("Link")
    void openHeaderNavLinkTest(String navLink, String article) {
        javaRushMainPage.openPage();
        javaRushMainPage.clickHeaderLink(navLink);
        verifyComponent.verifyPageArticleText(article);
    }
}
