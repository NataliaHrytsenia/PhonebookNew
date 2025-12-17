package org.phonebooknew;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver; //объявление переменной

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();// при кроссбраузерном тестировании нужно переключать на другие браузеры
        driver.get("https://telranedu.web.app"); //открываем ссылку на сайт
        driver.manage().window().maximize(); //развернуть окно до размеров экрана
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //время ожидания загрузки всех элементов
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[text()='Home Component']")).size()>0; // найди хотя бы один элемент на странице
    }

    public boolean isElementPresent(By locator){ //By это название класса, а locator это придумали мы
        return driver.findElements(locator).size()>0; // универсальный метод
    }

    public boolean isElementPresent2 (By locator){
        try {
            driver.findElement(locator);// ищем элемент
            return true;
        } catch (NoSuchElementException ex){
            return false;
        }
    }

    @AfterMethod (enabled = false) //замораживаем закрытие окна пока сами не закроем, чтобы видеть что происходит на странице
    public void tearDown(){
        driver.quit();
    }  // родительские класс для всех дочерних
}
