package phonebooknew;

import org.phonebooknew.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

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
        if (!app.getUser().isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            app.getUser().ClickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() { //метод регистрации нового пользователя (негативный тест)
        //enter email
        app.getUser().fillLoginRegistrationForm(new User().setEmail("hyi@gm.com").setPassword("Moni12345!"));

        //click on Registration button
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

}

