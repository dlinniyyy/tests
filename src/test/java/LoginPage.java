import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BaseTest {
    //Поле логин
    private final SelenideElement userNameField = $("#username");
    //Поле пароль
    private final SelenideElement userPass = $("input[type='password']");
    //Кнопка вход
    private final SelenideElement loginButton = $("button[type='submit']");
    //Заголовок H2
    private final SelenideElement hyLabel = $("h2");
    //Кнопка выход
    private final SelenideElement logoutButton = $(".mb-3");

    //Открытие URL
    public void OpenPage(){
        String URL = "http://qa-stand-login.inzhenerka.tech/login";
        Selenide.open(URL);
    }
    public void SetUsername(String username){
        //Метод ввода логина
        userNameField.setValue(username);

    }
    public void SetPass (String pass){
        //Метод ввода пароля
        userPass.setValue(pass);
    }
    public void Login(){
        //Метод нажатия на кнопку входа
        loginButton.click();
    }
    public void H2Test(String h2lable){
        hyLabel.exists();
        hyLabel.shouldHave(text(h2lable));
    }
    public void Logout(){
        //Метод нажатия на кнопку выход
        logoutButton.click();
    }
}
