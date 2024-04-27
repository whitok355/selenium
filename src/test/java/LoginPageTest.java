import org.example.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest extends AbstractTest{
    @Test
    public void checkAuth200() throws IOException, InterruptedException {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        getDriver().get(getPropertiesValue("BASE_URL"));
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.auth(getLOGIN(), getPASSWORD());
        String title = "Hello, "+ getLOGIN();

        List<WebElement> hello_titles = getDriver().findElements(By.partialLinkText(title));
        assertEquals(1, hello_titles.size());
        assertEquals(title,hello_titles.get(0).getText());
    }

    @Test
    public void checkAuth401() throws IOException {
        String currentStatus = "401";
        String currentMsg = "Invalid credentials.";

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get(getPropertiesValue("BASE_URL"));

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.auth("", "");

        WebElement status = getDriver().findElement(By.xpath("//*[contains(text(), '"+currentStatus+"')]"));
        WebElement errMsq = getDriver().findElement(By.xpath("//*[contains(text(), '"+currentMsg+"')]"));

        assertTrue(status.isDisplayed());
        assertTrue(errMsq.isDisplayed());




    }
}
