package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginPage {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement INPUT_LOGIN;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement INPUT_PASSWORD;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement BTN_SUBMIT;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = wait;
    }

    public void auth(String login, String passw) throws IOException {
        INPUT_LOGIN.sendKeys(login);
        INPUT_PASSWORD.sendKeys(passw);
        BTN_SUBMIT.click();
    }

}
