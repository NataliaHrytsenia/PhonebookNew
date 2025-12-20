package org.phonebooknew.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.phonebooknew.models.Contact;

import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        type(By.cssSelector("input:nth-child(2)"), contact.getSurname());
        type(By.cssSelector("input:nth-child(3)"), contact.getPhone());
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        type(By.cssSelector("input:nth-child(5)"), contact.getAdress());
        type(By.cssSelector("input:nth-child(6)"), contact.getDesc());
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //кликаем на кнопку REMOVE
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactAdded(String text) {
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el : contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

    public int sizeOfContacts(){ //ищем количество элементов
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))){
        return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }return 0;
}

    public void addContact() {
        clickOnAddLink();

        //заполнить все поля в форме контакта
        fillContactForm(new Contact()
                .setName("Nati")
                .setSurname("Müller")
                .setPhone("1234567891")
                .setEmail("nati@gm.com")
                .setAdress("Leipzig")
                .setDesc("goalkeeper"));

        //кликнуть на кнопку SAVE
        clickOnSaveButton();
    }
}
