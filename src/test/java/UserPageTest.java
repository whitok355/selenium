import com.codeborne.selenide.ElementsCollection;
import org.example.LoginPage;
import org.example.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserPageTest extends AbstractTest{

    @Test
    public void checkCreateUser() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();

        loginPage.auth(getLOGIN(), getPASSWORD());

        UserPage userPage = new UserPage();

        Thread.sleep(2000l);
        String quantityUserStart = $x("//div[@class='mdc-data-table__pagination-total']").getText();
        String startQuantityValue = quantityUserStart.substring(quantityUserStart.lastIndexOf("of") +2).trim();

        userPage.createUser();

        Thread.sleep(2000l);
        String quantityUserEnd = $x("//div[@class='mdc-data-table__pagination-total']").getText();
        String endQuantityValue = quantityUserEnd.substring(quantityUserEnd.lastIndexOf("of") +2).trim();

        assertNotEquals(startQuantityValue, endQuantityValue);
        assertEquals( Integer.parseInt(startQuantityValue)  + 1, Integer.parseInt(endQuantityValue));

    }

    @Test
    public void checkBLockUnblockUser() throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.auth(getLOGIN(), getPASSWORD());
        UserPage userPage = new UserPage();

        Thread.sleep(2000l);
        ElementsCollection btns = $$x("//tr/td[position() = 4]");
        int randId = new Random().nextInt(0, btns.size());
        String userStatusStart = btns.get(randId).getText();

        userPage.clickBlockBtn(randId);
        Thread.sleep(2000l);
        String userStatusEnd = btns.get(randId).getText();

        assertNotEquals(userStatusStart, userStatusEnd);
    }
}
