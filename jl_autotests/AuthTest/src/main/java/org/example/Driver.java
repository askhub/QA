package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

    private final WebDriver driver;

    public WebDriver getDriver () {
        return driver;
    }

    public Driver (DriverType driverType) {
        System.setProperty(driverType.getKey(), driverType.getValue());

        /* для передачи в другие запросы
        WebStorage webStorage = (WebStorage) new Augmenter().augment(driver.getDriver());
        LocalStorage localStorage = webStorage.getLocalStorage();
        String token = localStorage.getItem("accessToken");
        */

        driver = switch (driverType) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
        };
        //driver.manage().window().maximize();
    }

}
