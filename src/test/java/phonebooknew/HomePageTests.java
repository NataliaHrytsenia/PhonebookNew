package phonebooknew;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase { // этот класс наследник класса TestBase

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHomePage().isHomeComponentPresent()){
            app.getHomePage().clickOnHomeLink();
        }
    }
    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.xpath("//h1[text()='Home Component']"));// найди элемент по этому локатору
        //isHomeComponentPresent(); //вызвала булиновский результат
        //System.out.println("Home Component" + isElementPresent(By.xpath("//h1[text()='Home Component']")));
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent()); //класс который выдает true or false
    }

}
