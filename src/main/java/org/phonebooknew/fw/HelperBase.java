package org.phonebooknew.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperBase {
    WebDriver driver; //этот класс сам по себе, ни с чем не связан, поэтому нужен драйвер

    public HelperBase(WebDriver driver) {
        this.driver = driver;
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

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {//сделали рефакторинг и данные локатора отправились в сигнатуру метода Type выше
        if (text !=null){
        click(locator);
        driver.findElement(locator).clear(); //очищаем поле от лишней информации + локатор поля
        driver.findElement(locator).sendKeys(text); //добавляем стринговое значение в поле в формате Email
        }
    }

    //assert alert is appeared (проверяем появилось ли окно с ошибкой что такой пользователь уже существует)
    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.alertIsPresent());//мы ждем появления всплывающего окна 20 секунд
        if (alert==null){
            return false;
        }else{
            driver.switchTo().alert();//switchTo - это перескочить в окно алерта
            alert.accept();//метод accept кликает на кнопку ок чтобы алерт исчез
            return true;
        }

    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
