import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.LoginPage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends AbstractTest{
    @Test
    public void checkAuth200() throws IOException, InterruptedException {
        String title = "Hello, "+ getLOGIN();
        LoginPage loginPage = new LoginPage();
        loginPage.auth(getPropertiesValue("login"), getPropertiesValue("password"));

        ElementsCollection hello_titles = $$x("//div[@class='mdc-menu mdc-menu-surface']/..");

        Thread.sleep(2000l);
        assertEquals(1, hello_titles.size());
        assertEquals(title, hello_titles.get(0).getText());
    }

    @Test
    public void checkAuth401() throws IOException, InterruptedException {
        String currentStatus = "401";
        String currentMsg = "Invalid credentials.";

        LoginPage loginPage = new LoginPage();
        loginPage.auth("", "");

        Thread.sleep(2000l);
        SelenideElement status = $x("//*[contains(text(), '"+currentStatus+"')]");
        SelenideElement errMsq = $x("//*[contains(text(), '"+currentMsg+"')]");

        assertTrue(status.isDisplayed());
        assertTrue(errMsq.isDisplayed());
    }
}
