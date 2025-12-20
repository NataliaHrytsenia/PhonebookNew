package org.phonebooknew.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {// связан с хелперами только ссылаясь на них
    WebDriver driver; //объявление переменной

    UserHelper user;

    ContactHelper contact;

    HomePageHelper homePage;


    public void init() {
        driver = new ChromeDriver();// при кроссбраузерном тестировании нужно переключать на другие браузеры
        driver.get("https://telranedu.web.app"); //открываем ссылку на сайт
        driver.manage().window().maximize(); //развернуть окно до размеров экрана
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //время ожидания загрузки всех элементов

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public UserHelper getUser() {//getter
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public void stop() {
        driver.quit();
    }

    //@Test
    //public void newUserRegistrationPositiveTest() { //метод регистрации нового пользователя
        //enter email
       // fillLoginRegistrationForm(new User().setEmail("mono@gmail.com").setPassword("Moni12345!"));

        //click on Registration button
        //clickOnRegistrationButton();

        //assert Sign button  displayed (убедиться что кнопка Sign Up есть)
        //Assert.assertTrue(isElementPresent2(By.xpath("//button[contains(.,'Sign Out')]")));
    }

//}
