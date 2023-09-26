import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class TestClearSelenide {

    @Test
    @DisplayName("Check that issues page contains element with text Hello Allure!")
    public void issueTest(){

        Selenide.open("https://github.com/");
        $(".search-input-container").click();
        $("#query-builder-test").setValue("KeNiY163/allure_homework").pressEnter();
        $(By.linkText("KeNiY163/allure_homework")).click();
        $("#issues-tab").click();
        $(withText("Hello Allure!")).should(Condition.exist);

    }

}
