// Автотесты UI авторизация в JL3 Mozilla firefox. Korotchenko AS. 2023
package aero.s7.jl.autotest.ui;

import aero.s7.jl.autotest.common.DriverCore;
import aero.s7.jl.autotest.common.DriverType;
import aero.s7.jl.autotest.common.Helper;
import aero.s7.jl.autotest.common.Constant;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationFirefoxUITest {

    DriverCore driver;

    @Before
    public void setupFirefox () {
        driver = new DriverCore(DriverType.FIREFOX);
        driver.getDriver().manage().window().maximize();
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.getDriver().get(Constant.BASE_URL);
        // для версий драйвера firefox после вер.111
        //driver.getDriver().findElement(By.xpath("//*[contains(text(),'Дополнительно...')]")).click();
        //driver.getDriver().findElement(By.xpath("//*[contains(text(),'Принять риск и продолжить')]")).click();
    }

    @Test
    public void loginFirefox () {

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
    public void loginFirefoxNameError () {

        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']")).click();
        driver.getDriver().findElement(By.xpath("//*[@id='usernameUserInput']"))
                .sendKeys(Constant.LOGIN_NAME_WRONG, Keys.TAB, Constant.LOGIN_PASS);
        driver.getDriver().findElement(By.xpath("//*[@class='ui primary large button']")).click();

        Helper.wait(3000);

        final String actualValue = "Ошибка авторизации, проверьте учетные данные";
        String expectedValue = driver.getDriver().findElement(By.xpath("//*[contains(text(), 'Ошибка авторизации, проверьте учетные данные')]")).getText();
        assertThat(expectedValue).isEqualTo(actualValue);
    }

    @Test
    public void loginFirefoxPassError () {

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
    public void closeSessionFirefox () {
        driver.getDriver().quit();
    }

}
