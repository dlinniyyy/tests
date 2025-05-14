import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class InzhenerkaLoginTest {
    @BeforeAll
    public static void setUp() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/selenide.properties"));
            Configuration.browser = properties.getProperty("selenide.browser");
//            Configuration.startMaximized = Boolean.parseBoolean(properties.getProperty("selenide.startMaximized"));

            Configuration.headless = Boolean.parseBoolean(properties.getProperty("selenide.headless"));
            Configuration.remote = properties.getProperty("selenide.remote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {

        // Открыть страницу входа
        Selenide.open("http://qa-stand-login.inzhenerka.tech/login");

        // Проверка лейбла Логина
        $(By.xpath("//*[text()='Логин:']")).shouldBe(Condition.visible).shouldHave(Condition.text("Логин"));
        // Ввод логина
        $("input[type='text']").setValue("admin");


        // Проверка лейбла пароля
        $(By.xpath("//*[text()='Пароль:']")).shouldHave(Condition.text("Пароль:")).shouldBe(Condition.visible);

        // Ввод пароля
        $(By.name("password")).setValue("admin123");

        // Нажатие кнопки входа
        if ($("button[type='submit']").shouldHave(Condition.text("Войти")).exists()){

            // Клик на кнопку Войти
            $("button[type='submit']").click();
        }

        $("h2").shouldHave(Condition.text("Привет, admin").because("Текст заголовка не совпадает"));
            $(By.xpath("//*[text()='Выйти']")).shouldHave(Condition.text("Выйти").because("Кнопка отсутствуе"));
                // Выход из системы
                $(".mb-3").click();



    }
}