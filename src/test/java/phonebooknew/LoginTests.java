package phonebooknew;

import org.phonebooknew.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!app.getUser().isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            app.getUser().ClickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().clickOnLoginLink();
    }

    @Test

    public void loginPositiveTest(){
        //enter email
        app.getUser().fillLoginRegistrationForm(new User().setEmail("mono@gmail.com").setPassword("Moni12345!"));

        //click on Login Button
        app.getUser().clickOnLoginButton();

        //проверить есть ли кнопка Sign Out
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test

    public void loginNegativeWithoutLoginTest(){
        //enter email
        app.getUser().fillLoginRegistrationForm(new User().setPassword("mono@gmail.com"));

        //click on Login Button
        app.getUser().clickOnLoginButton();

        //проверить есть ли кнопка Sign Out
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
