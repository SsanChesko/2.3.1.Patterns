import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Test {

    @BeforeEach
    private void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    int days = 4;
    int daysForSecondMeeting = days + 6;

    @org.junit.jupiter.api.Test
    void shouldTestHappyPath() {
        open("http://localhost:9999/");
        $x("//input[@class='input__control']").val(DataGenerator.city());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(DataGenerator.generateDate(days));
        $("[data-test-id='name'] input").val(DataGenerator.generateName("ru"));
        $("[data-test-id='phone'] input").val(DataGenerator.generatePhone("ru"));
        $x("//span[@class='checkbox__box']").click();
        $(withText("Запланировать")).click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + DataGenerator.generateDate(days)), Duration.ofSeconds(15));
    }

    @org.junit.jupiter.api.Test
    void shouldTestHappyPathWithNewDate() {
        open("http://localhost:9999/");
        $x("//input[@class='input__control']").val(DataGenerator.city());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(DataGenerator.generateDate(days));
        $("[data-test-id='name'] input").val(DataGenerator.generateName("ru"));
        $("[data-test-id='phone'] input").val(DataGenerator.generatePhone("ru"));
        $x("//span[@class='checkbox__box']").click();
        $(withText("Запланировать")).click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + DataGenerator.generateDate(days)), Duration.ofSeconds(15));
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").val(DataGenerator.generateDate(daysForSecondMeeting));
        $(withText("Запланировать")).click();
        $("[data-test-id='replan-notification'] .button").click();
        $(".notification__content").shouldHave(Condition.text("Встреча успешно запланирована на " + DataGenerator.generateDate(daysForSecondMeeting)), Duration.ofSeconds(15));
    }
}

//TODO Слетают тесты с буквой ё