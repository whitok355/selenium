package org.example;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import java.io.IOException;

public class LoginPage {

    public SelenideElement INPUT_LOGIN(){
        return $x("//input[@type='text']");
    }
    public SelenideElement INPUT_PASSWORD(){
        return $x("//input[@type='password']");
    }
    public SelenideElement BTN_SUBMIT(){
        return $x("//button[@type='submit']");
    }

    public void auth(String login, String passw) throws IOException {
        INPUT_LOGIN().shouldBe(visible).sendKeys(login);
        INPUT_PASSWORD().shouldBe(visible).sendKeys(passw);
        BTN_SUBMIT().shouldBe(visible).click();
    }

}
