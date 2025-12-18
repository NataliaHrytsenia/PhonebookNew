package org.phonebooknew;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

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

        //заполнить все поля в форме контакта
        type(By.cssSelector("input:nth-child(1)"), "Nati");
        type(By.cssSelector("input:nth-child(2)"), "Müller");
        type(By.cssSelector("input:nth-child(3)"), "1234567891");
        type(By.cssSelector("input:nth-child(4)"), "nati@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Leipzig");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");

        //кликнуть на кнопку SAVE
        click(By.cssSelector(".add_form__2rsm2 button"));

    }

    @Test
    public void removeContactPositiveTest(){
        int sizeBefore = sizeOfContacts();//actual Resalts

        //СЦЕНАРИЙ
        //кликаем на карточку с контактом
        //кликаем на кнопку REMOVE
        //assert contact is removed


        //кликаем на карточку с контактом
        click(By.cssSelector(".contact-item_card__2SOIM"));

        //кликаем на кнопку REMOVE
        click(By.xpath("//button[.='Remove']"));

        pause(1000);

        int sizeAfter = sizeOfContacts();


        //assert contact is removed
        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }
    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts(){ //ищем количество элементов
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }return 0;
}
}
