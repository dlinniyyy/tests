import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InzhenerkaLoginTest {
    @Test
    @DisplayName("Проверка логина и логаута")
    public void runLoginTest() {

        LoginPage loginPage = new LoginPage();
        loginPage.OpenPage();
        loginPage.SetUsername("user");
        loginPage.SetPass("user123");
        loginPage.Login();
        loginPage.H2Test("Привет, user");
        loginPage.Logout();
    }
}