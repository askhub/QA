// автотесты JL3
package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {
    @Test (description = "Chrome authorization JL3")
    public void authChrome () {

       Driver driver = new Driver(DriverType.CHROME);

        driver.getDriver().get("https://jl-dev.s7.aero");

        // проходим предупреждение браузера о безопасности
        WebElement addButton = driver.getDriver().findElement(By.xpath("//*[@id='details-button']"));
        addButton.click();
        WebElement mainLink = driver.getDriver().findElement(By.xpath("//*[@id='proceed-link']"));
        mainLink.click();

        // кликаем и заполняем поля формы авторизации и жмем кнопку входа
        WebElement inputLogin = driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"));
        inputLogin.click();
        inputLogin.sendKeys("a.korotchenko", Keys.TAB, "123456789");

        WebElement loginButton = driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']"));
        loginButton.click();

        wait(5000);

        // testNG result
        String actualUrl = "Jl";
        String expectedUrl = driver.getDriver().getTitle();
        Assert.assertEquals(actualUrl, expectedUrl);

        driver.quit();
    }

    @Test (description = "firefox authorization JL3")
    public void authFireFox () {

        Driver driver = new Driver(DriverType.FIREFOX);
        driver.getDriver().get("https://jl-dev.s7.aero");

        // кликаем и заполняем поля формы авторизации и жмем кнопку входа
        WebElement inputLogin = driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"));
        inputLogin.click();
        inputLogin.sendKeys("a.korotchenko", Keys.TAB, "123456789");

        WebElement loginButton = driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']"));
        loginButton.click();

        wait(5000);

        // testNG result
        String actualUrl = "Jl";
        String expectedUrl = driver.getDriver().getTitle();
        Assert.assertEquals(actualUrl, expectedUrl);
        driver.quit();

    }

    public static void wait(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
