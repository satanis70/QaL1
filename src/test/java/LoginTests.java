import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests {

    @Test
    void successfulLoginTest(){
        Configuration.holdBrowserOpen = true;
        open("https://qa.guru/cms/system/login");
        $(".login-form").shouldHave(text("Войти"));
        $("[name=email]").setValue("satanis70@gmail.com");
        $("[name=password]").setValue("3&$D-@fM").pressEnter();
        $(".main-header__login").click();
        $(".logined-form").shouldBe(text("Здравствуйте, Никита"));
    }

    @Test
    void unsuccessfulLoginTest(){

    }

    @Test
    void name() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse("16.06.2023", formatter);

        assertEquals(DayOfWeek.FRIDAY, localDate.getDayOfWeek());
    }
}
