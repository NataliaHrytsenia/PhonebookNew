package org.phonebooknew;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            ClickOnSignOutButton();
        }

        //click on Login Link
        clickOnLoginLink();

        //enter email
        fillLoginRegistrationForm("mono@gmail.com", "Moni12345!");

        //click on Login Button
        click(By.xpath("//button[.='Login']"));

        //click on ADD Link
        click(By.cssSelector("[href='/add']"));

    }

    @Test

    public void addContactPositiveTests(){

        //СЦЕНАРИЙ
        //заполнить все поля в форме контакта
        //кликнуть на кнопку SAVE
        //проверить добавлен ли контакт в список контактов


        //заполнить все поля в форме контакта
        type(By.cssSelector("input:nth-child(1)"), "Nati");
        type(By.cssSelector("input:nth-child(2)"), "Müller");
        type(By.cssSelector("input:nth-child(3)"), "1234567891");
        type(By.cssSelector("input:nth-child(4)"), "nati@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Leipzig");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");

        //кликнуть на кнопку SAVE
        click(By.cssSelector(".add_form__2rsm2 button"));

        //проверить добавлен ли контакт в список контактов
        Assert.assertTrue(isContactAdded("Karl"));

    }

    @AfterMethod
    public void postCondition() {
        //кликаем на карточку с контактом
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //кликаем на кнопку REMOVE
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }
}


