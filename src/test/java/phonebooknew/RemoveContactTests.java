package phonebooknew;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!app.getUser().isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            app.getUser().ClickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().login();

        //click on ADD Link
        app.getContact().addContact();

    }

    @Test
    public void removeContactPositiveTest(){
        int sizeBefore = app.getContact().sizeOfContacts();//actual Resalts

        //СЦЕНАРИЙ
        //кликаем на карточку с контактом
        //кликаем на кнопку REMOVE
        //assert contact is removed


        //кликаем на карточку с контактом
        app.getContact().removeContact();

        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();


        //assert contact is removed
        Assert.assertEquals(sizeAfter,sizeBefore-1);

    }

}
