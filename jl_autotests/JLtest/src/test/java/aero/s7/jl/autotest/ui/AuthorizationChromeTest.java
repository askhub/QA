package aero.s7.jl.autotest.ui;//Автотесты авторизации JL 3 Google Chrome

import aero.s7.jl.autotest.common.Constant;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.DriverCore;
import aero.s7.jl.autotest.common.DriverType;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationChromeTest {

    DriverCore driver;

    @Before
    public void setupChrome () {
        driver = new DriverCore(DriverType.CHROME);
        driver.getDriver().manage().window().maximize();
    }

    @Test
    public void loginChrome (){
        driver.getDriver().get(Constant.BASE_DEV_URL);
        driver.getDriver().findElement(By.xpath("//*[@id='details-button']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='proceed-link']")).click();

        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"))
                .sendKeys(Constant.LOGIN_NAME, Keys.TAB, Constant.LOGIN_PASS);
        driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']")).click();

        Helper.wait(3000);

        final String actualValue = "Jl";
        String expectedValue = driver.getDriver().getTitle();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void loginChromeNameError () {
        driver.getDriver().get(Constant.BASE_DEV_URL);
        driver.getDriver().findElement(By.xpath("//*[@id='details-button']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='proceed-link']")).click();

        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"))
                .sendKeys(Constant.LOGIN_NAME_WRONG, Keys.TAB, Constant.LOGIN_PASS);
        driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']")).click();

        Helper.wait(3000);

        final String actualValue = "Ошибка авторизации, проверьте учетные данные";
        String expectedValue = driver.getDriver()
                .findElement(By.xpath("//*[contains(text(), 'Ошибка авторизации, проверьте учетные данные')]")).getText();
        assertThat(expectedValue).isEqualTo(actualValue);
    }

    @Test
    public void loginChromePassError () {
        driver.getDriver().get(Constant.BASE_DEV_URL);
        driver.getDriver().findElement(By.xpath("//*[@id='details-button']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='proceed-link']")).click();

        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"))
                .sendKeys(Constant.LOGIN_NAME, Keys.TAB, Constant.LOGIN_PASS_WRONG);
        driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']")).click();

        Helper.wait(3000);

        final String actualValue = "Ошибка авторизации, проверьте учетные данные";
        String expectedValue = driver.getDriver()
                .findElement(By.xpath("//*[contains(text(), 'Ошибка авторизации, проверьте учетные данные')]")).getText();
        assertThat(expectedValue).isEqualTo(actualValue);
    }

    @After
    public void closeSessionChrome () {
        driver.getDriver().quit();
    }


}
