package phonebooknew;

import org.phonebooknew.models.Contact;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() { //проверить что пользователь разлогиненый
        if (!app.getUser().isLoginLinkPresent()){ //знак ! означает отрицание, если нет кнопки (локатор кнопки) LOGIN
            app.getUser().ClickOnSignOutButton();
        }

        //click on Login Link
        app.getUser().login();

        //click on ADD Link
        app.getContact().clickOnAddLink();

    }

    @Test

    public void addContactPositiveTests(){

        //СЦЕНАРИЙ
        //заполнить все поля в форме контакта
        //кликнуть на кнопку SAVE
        //проверить добавлен ли контакт в список контактов


        //заполнить все поля в форме контакта
        app.getContact().fillContactForm(new Contact()
                .setName("Nati")
                .setSurname("Müller")
                .setPhone("1234567891")
                .setEmail("nati@gm.com")
                .setAdress("Leipzig")
                .setDesc("goalkeeper"));

        //кликнуть на кнопку SAVE
        app.getContact().clickOnSaveButton();

        //проверить добавлен ли контакт в список контактов
        Assert.assertTrue(app.getContact().isContactAdded("Karl"));

    }

    @AfterMethod
    public void postCondition() {
        //кликаем на карточку с контактом
        app.getContact().removeContact();
    }

}


