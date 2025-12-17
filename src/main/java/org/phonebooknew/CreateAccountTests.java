package org.phonebooknew;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    //ПОШАГОВЫЙ СЦЕНАРИЙ ТЕСТОВ

    //precondition: что пользователь разлогинен
    //click on Login Link
    //enter email
    //enter Password
    //click on Registration button
    //assert Sign button  displayed (убедиться что кнопка Sign Up есть)


    //precondition: что пользователь разлогинен
    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!isElementPresent(By.cssSelector("a:nth-child(4)"))){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            driver.findElement(By.xpath("//button[contains(.,'Sign Out')]")).click(); //кликни на кнопку Sign Out (локатор)
        }

        //click on Login Link
        driver.findElement(By.cssSelector("a:nth-child(4)")).click();
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        //enter email
        driver.findElement(By.cssSelector("[placeholder='Email']")).click(); //кликаем на поле Email+ локатор поля
        driver.findElement(By.cssSelector("[placeholder='Email']")).clear(); //очищаем поле от лишней информации + локатор поля
        driver.findElement(By.cssSelector("[placeholder='Email']")).sendKeys("mono@gmail.com"); //добавляем стринговое значение в поле в формате Email

        //enter Password
        driver.findElement(By.cssSelector("[placeholder='Password']")).click(); //кликаем на поле Password+ локатор поля
        driver.findElement(By.cssSelector("[placeholder='Password']")).clear(); //очищаем поле от лишней информации + локатор поля
        driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("Moni12345!");// пароль минимум 8 символов, разный регистр букв

        //click on Registration button
        driver.findElement(By.xpath("//button[text()='Registration']")).click();

        //assert Sign button  displayed (убедиться что кнопка Sign Up есть)
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }
}
