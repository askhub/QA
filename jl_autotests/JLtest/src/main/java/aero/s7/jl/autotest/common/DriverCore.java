
package aero.s7.jl.autotest.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverCore {

    private final WebDriver driver;

    public WebDriver getDriver () {
        return driver;
    }

    public DriverCore (DriverType driverType) {

        System.setProperty(driverType.getKey(), driverType.getValue());

        driver = switch (driverType) {
            case CHROME -> {
                final ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                yield new ChromeDriver(ops);
            }

            case FIREFOX -> new FirefoxDriver();
        };
    }
}
