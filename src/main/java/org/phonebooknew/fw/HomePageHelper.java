package org.phonebooknew.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//h1[text()='Home Component']")).size()>0; // найди хотя бы один элемент на странице
    }

    public void clickOnHomeLink() {
        click(By.xpath("//a[.='HOME']"));
    }
}
