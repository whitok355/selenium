package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class UserPage {
    @FindBy(xpath = "//h1[contains(text(), 'Student Page')]/following-sibling::button")
    private WebElement btnAdd;
    @FindBy(xpath = "//div[@class='form-modal-header mdc-dialog__header']//following-sibling::button")
    private WebElement btnClose;
    @FindBy(xpath = "//span[contains(text(), 'Fist Name')]/following-sibling::input")
    private WebElement firstName;
    @FindBy(xpath = "//span[contains(text(), 'Last Name')]/following-sibling::input")
    private WebElement lastName;
    @FindBy(xpath = "//span[contains(text(), 'Birthdate')]/following-sibling::input")
    private WebElement birthdate;
    @FindBy(xpath = "//span[contains(text(), 'Login')]/following-sibling::input")
    private WebElement login;
    @FindBy(xpath = "//span[contains(text(), 'Phone')]/following-sibling::input")
    private WebElement phone;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSave;
    @FindBy(xpath = "//td[@class='mdc-data-table__cell']//following-sibling::button[last()]")
    private List<WebElement> btns;
    public UserPage (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void createUser(){
        btnAdd.click();
        firstName.sendKeys("12wqa");
        lastName.sendKeys("asd23");
        birthdate.sendKeys("11.03.1990");
        login.sendKeys("testUserNumber" + new Random().nextInt(0, 1000));
        phone.sendKeys("98793123213");
        btnSave.click();
        btnClose.click();
    }

    public void clickBlockBtn(int id){
        btns.get(id).click();
    }

}
