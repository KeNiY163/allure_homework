import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class StepsWeb extends BaseTest {

    @Step("Открытие целевой страницы")
    public void openMainPage(){

        Selenide.open("https://github.com/");

    }

    @Step("Поиск репозитория {repos} через поиск гитхаба")
    public void searchRepository(String repos){

        $(".search-input-container").click();
        $("#query-builder-test").setValue(repos).pressEnter();

        takeScreenshot();

    }

    @Step("Открытие репозитория с ссылкой {repos}")
    public void clickOnRepositoryLink(String repos) {
        $(By.linkText(repos)).click();

        takeScreenshot();

    }

    @Step("Открытие ишью")
    public void openIssuesTab() {
        $("#issues-tab").click();

        takeScreenshot();

    }

    @Step("Проверка наличия ишью {issue} в списке")
    public void shouldSeeIssue(String issue) {
        $(withText(issue)).should(Condition.exist);

        takeScreenshot();

    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
