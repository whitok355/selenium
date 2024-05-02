package org.example;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ProfilePage {

    public SelenideElement editBtn(){
        return $x("//*[@title='More options']");
    }
    public SelenideElement birthdayInput(){
        return $x("//*[@type='date']");
    }
    public SelenideElement birthdayValue(){
        return $x("//*[contains(text(), 'Date of birth')]//following-sibling::div");
    }
    public SelenideElement btnSubmit(){
        return $x("//*[@type='submit']");
    }
    public void changeValueBirthday(String value){
        editBtn().shouldBe(visible).click();
        birthdayInput().shouldBe(visible).sendKeys(value);
        btnSubmit().should(visible).click();
    }

    public String getBirthdayValue(){
        return birthdayValue().getText();
    }
}
