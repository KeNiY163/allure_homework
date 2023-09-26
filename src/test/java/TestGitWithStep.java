import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestGitWithStep {

    private static final String Repos = "KeNiY163/allure_homework";
    private static final String IssueName = "Hello Allure!";

    @Test
    @DisplayName("Проверка наличия ишью в репозитории с именем \"Hello Allure!\"")
    public void stepTest(){

        step("Открытие главной страницы гитхаба", () -> {
            Selenide.open("https://github.com/");
        });

        step("Поиск репозитория " + Repos, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(Repos).pressEnter();
        });

        step("Нажатие по найденому репозиторию " + Repos, () -> {
            $(By.linkText(Repos)).click();
        });

        step("Открытие ишью репозитория", () -> {
            $("#issues-tab").click();
        });

        step("Проверка наличия в списке ишью с названием " + IssueName, () -> {
            $(withText(IssueName)).should(Condition.exist);
        });

    }

    @Test
    @DisplayName("Проверка наличия ишью в репозитории с названием \"Hello Allure!\" и с выполнением пошаговой модели теста")
    public void AnnotatedStepTest(){

        StepsWeb steps = new StepsWeb();

        steps.openMainPage();
        steps.searchRepository(Repos);
        steps.clickOnRepositoryLink(Repos);
        steps.openIssuesTab();
        steps.shouldSeeIssue(IssueName);

    }

}
