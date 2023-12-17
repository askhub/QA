package aero.s7.jl.autotest.common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

import java.time.Duration;

public class TestBase {
    public static DriverCore driver;
    public static String token;

    @BeforeClass
    public static void setupChrome() {
        driver = new DriverCore(DriverType.CHROME);
        //driver.getDriver().manage().window().maximize();
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.getDriver().get(Constant.BASE_URL);
        //driver.getDriver().findElement(By.xpath("//*[@id='details-button']")).click();
        //driver.getDriver().findElement(By.xpath("//*[@id='proceed-link']")).click();

        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"))
                .sendKeys(Constant.LOGIN_NAME, Keys.TAB, Constant.LOGIN_PASS);
        driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']")).click();
        Helper.wait(7000);
        token = authToken();
        System.out.println(token);
    }

    @AfterClass
    public static void closeSessionChrome() {
        driver.getDriver().quit();
    }

    public static void headerLink(String chapter) {
        //Helper.wait(1000);
        String chapterXpath = String.format("//button//span[contains(text(), '%s')]", chapter);
        driver.getDriver().findElement(By.xpath(chapterXpath)).click();
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Helper.wait(1000);
    }

    public static String authToken() {
        final WebStorage webStorage = (WebStorage) new Augmenter().augment(driver.getDriver());
        final LocalStorage localStorage = webStorage.getLocalStorage();
        return localStorage.getItem("accessToken");
    }

    public static boolean isChapterPresent(String chapterTitle) {
        //Helper.wait(500);
        String checkingXpath = String.format("//button[@class='_active']//span[contains(text(), '%s')]", chapterTitle);
        Boolean isPresent;
        isPresent = driver.getDriver().findElements(By.xpath(checkingXpath)).size() == 1;
        return isPresent.equals(true);
    }
}