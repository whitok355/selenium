import com.codeborne.selenide.SelenideElement;
import org.example.LoginPage;
import org.example.ProfilePage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfilePageTest extends AbstractTest{

    public SelenideElement menu(){
        return $x("//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']");
    }
    public SelenideElement profileBtn(){
        return $x("//li[@role='menuitem']");
    }

    public SelenideElement closeBtn(){
        return $x("//button[@data-mdc-dialog-action='close']");
    }

    @Test
    public void checkChangeBirthdayValue() throws IOException, InterruptedException {
        String birthdayValue = "11.11.2922";
        LoginPage loginPage = new LoginPage();
        loginPage.auth(getLOGIN(), getPASSWORD());
        menu().should(visible).click();
        profileBtn().should(visible).click();

        Thread.sleep(2000l);
        ProfilePage profilePage = new ProfilePage();
        profilePage.changeValueBirthday(birthdayValue);
        closeBtn().should(visible).click();
        assertEquals(birthdayValue, profilePage.getBirthdayValue());

    }
}
