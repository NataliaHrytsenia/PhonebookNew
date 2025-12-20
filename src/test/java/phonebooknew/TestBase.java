package phonebooknew;

import org.phonebooknew.fw.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager();//делегирование через Application Manager

    @BeforeMethod
    public void setUp(){
        app.init(); //метод обращается через Application Manager
    }

    @AfterMethod (enabled = false) //замораживаем закрытие окна пока сами не закроем, чтобы видеть что происходит на странице
    public void tearDown(){

        app.stop();
    }  // родительские класс для всех дочерних

}
