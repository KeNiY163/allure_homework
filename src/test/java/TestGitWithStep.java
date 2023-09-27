import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestGitWithStep extends BaseTest {

    private static final String REPOS = "KeNiY163/allure_homework";
    private static final String ISSUENAME = "Hello Allure!";

    @Test
    @DisplayName("Проверка наличия ишью в репозитории с именем \"Hello Allure!\"")
    public void stepTest(){

        step("Открытие главной страницы гитхаба", () -> {
            Selenide.open("https://github.com/");
        });

        step("Поиск репозитория " + REPOS, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(REPOS).pressEnter();
        });

        step("Нажатие по найденому репозиторию " + REPOS, () -> {
            $(By.linkText(REPOS)).click();
        });

        step("Открытие ишью репозитория", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия в списке ишью с названием " + ISSUENAME, () -> {
            $(withText(ISSUENAME)).should(Condition.exist);
        });

    }

    @Test
    @DisplayName("Проверка наличия ишью в репозитории с названием \"Hello Allure!\" и с выполнением пошаговой модели теста")
    public void annotatedStepTest(){

        StepsWeb steps = new StepsWeb();

        steps.openMainPage();
        steps.searchRepository(REPOS);
        steps.clickOnRepositoryLink(REPOS);
        steps.openIssuesTab();
        steps.shouldSeeIssue(ISSUENAME);

    }

}
