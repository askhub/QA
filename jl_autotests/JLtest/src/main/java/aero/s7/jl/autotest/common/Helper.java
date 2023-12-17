package aero.s7.jl.autotest.common;

import aero.s7.jl.autotest.api.Administration.Category;
import aero.s7.jl.autotest.api.Administration.SettingsService;
import aero.s7.jl.autotest.api.Administration.SettingsServiceImpl;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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

    public static void notificationControl (String expectedMessage) {
        //String key = expectedMessage.split(" ", 2)[0];
        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(20));
        WebElement toast = wait.until(visibilityOfElementLocated(By.xpath(String.format("//div[contains(text(),'%s')]", expectedMessage))));
        String actualMessage = toast.getText();

        Helper.wait(2000);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    public static int getMaxSortIndex() {
        SettingsService settingsService = new SettingsServiceImpl();
        List<Category> allCategory = settingsService.getAllCategory();
        Assert.assertNotNull(allCategory);
        List<Integer> sortIndexList = new ArrayList<>();
        for (Category category : allCategory) {
            sortIndexList.add(category.getSortIndex());
        }
        Assert.assertNotNull(sortIndexList);

        int max = sortIndexList.get(0);
        for (int i=0; i < sortIndexList.size(); i++) {
            if (max < sortIndexList.get(i)) {
                max = sortIndexList.get(i);
            }
        }
        return max;
    }

}
