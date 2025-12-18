package org.phonebooknew;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            ClickOnSignOutButton();
        }

        //click on Login Link
        clickOnLoginLink();
    }

    @Test

    public void loginPositiveTest(){
        //enter email
        fillLoginRegistrationForm("mono@gmail.com", "Moni12345!");

        //click on Login Button
        click(By.xpath("//button[.='Login']"));

        //проверить есть ли кнопка Sign Out
        Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));

    }

}
