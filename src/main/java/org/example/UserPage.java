package org.example;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class UserPage {


    public SelenideElement btnAdd(){
        return $x("//h1[contains(text(), 'Student Page')]/following-sibling::button");
    }
    public SelenideElement btnClose(){
        return $x("//div[@class='form-modal-header mdc-dialog__header']//following-sibling::button");
    }

    public SelenideElement firstName(){
        return $x("//span[contains(text(), 'Fist Name')]/following-sibling::input");
    }
    public SelenideElement lastName(){
        return $x("//span[contains(text(), 'Last Name')]/following-sibling::input");
    }
    public SelenideElement birthdate(){
        return $x("//span[contains(text(), 'Birthdate')]/following-sibling::input");
    }
    public SelenideElement login(){
        return $x("//span[contains(text(), 'Login')]/following-sibling::input");
    }
    public SelenideElement phone(){
        return $x("//span[contains(text(), 'Phone')]/following-sibling::input");
    }
    public SelenideElement btnSave(){
        return $x("//button[@type='submit']");
    }
    public ElementsCollection btns(){
        return $$x("//td[@class='mdc-data-table__cell']//following-sibling::button[last()]");
    }
    public void createUser(){
        btnAdd().should(visible).click();
        firstName().should(visible).sendKeys("12wqa");
        lastName().should(visible).sendKeys("asd23");
        birthdate().should(visible).sendKeys("11.03.1990");
        login().should(visible).sendKeys("testUserNumber" + new Random().nextInt(0, 1000));
        phone().should(visible).sendKeys("98793123213");
        btnSave().should(visible).click();
        btnClose().should(visible).click();
    }

    public void clickBlockBtn(int id){
        btns().get(id).should(visible).click();
    }

}
