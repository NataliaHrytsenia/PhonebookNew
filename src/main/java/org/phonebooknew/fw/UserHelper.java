package org.phonebooknew.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.phonebooknew.models.User;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a:nth-child(4)"));
    }

    public void ClickOnSignOutButton() {
        click(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("a:nth-child(4)"));
    }

    public void clickOnRegistrationButton() {
        click(By.xpath("//button[text()='Registration']"));
    }

    public void fillLoginRegistrationForm(User user) {


        type(By.cssSelector("[placeholder='Email']"), user.getEmail()); //сделали рефакторинг, теперь это короткая запись private void type, описан ниже

        //enter Password
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }

    public void login() {
        clickOnLoginLink();

        //enter email
        fillLoginRegistrationForm(new User().
                setEmail("mono@gmail.com").
                setPassword("Moni12345!"));

        //click on Login Button
        clickOnLoginButton();
    }
}
