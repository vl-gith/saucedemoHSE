import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    /*
    1. Открыть страницу saucedemo.com
    2. Ввести в поле username значение standart_user
    3. Оставить поле password пустым
    4. Нажать кнопку "Login"
    5. Проверить, что мы видим сообщение об ошибке с текстом "Epic sadface: Password is required"
     */

    @Test
    public void checkNegativeLoginWithEmptyPassword(){
        WebDriver driver = new ChromeDriver(); // создание экземпляра объекта драйвера

        driver.manage().window().maximize(); // окно браузера на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание элемента, пока он появится на экране

        driver.get("https://www.saucedemo.com/"); // переход на страницу

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = driver.findElement(By.cssSelector("[data-test=error]")).getText();

        Assert.assertEquals(errorMessage, "Epic sadface: Password is required"); // ожидаемый результат
    }

    @Test
    public void checkPositiveLoginWithEmptyPassword(){
        WebDriver driver = new ChromeDriver(); // создание экземпляра объекта драйвера

        driver.manage().window().maximize(); // окно браузера на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //неявное ожидание элемента, пока он появится на экране

        driver.get("https://www.saucedemo.com/"); // переход на страницу

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        boolean titleIsVisible = driver.findElement(By.cssSelector("[data-test=title]")).isDisplayed();

        Assert.assertTrue(titleIsVisible);
    }
}
