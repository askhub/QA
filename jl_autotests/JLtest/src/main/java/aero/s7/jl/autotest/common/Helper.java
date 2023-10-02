package aero.s7.jl.autotest.common;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Helper extends TestBase {

    public static void wait(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static Object jsonValue (String jsonString, String key) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject.get(key);
    }

    public static void notificationControl (String expectedMessage) {
        //String key = expectedMessage.split(" ", 2)[0];
        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath(String.format("//div[contains(text(),'%s')]", expectedMessage))));
        String actualMessage = toast.getText();

        Helper.wait(2000);
        Assert.assertEquals(expectedMessage, actualMessage);

    }

}
