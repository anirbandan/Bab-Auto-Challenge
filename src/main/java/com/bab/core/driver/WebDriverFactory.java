package com.bab.core.driver;

import com.bab.domain.helpers.AppParametersHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static java.util.Objects.nonNull;

public class WebDriverFactory {
    static final ChromeOptions chromeOptions = new ChromeOptions();
    static final FirefoxOptions firefoxOptions = new FirefoxOptions();
    static WebDriver webDriver;

    public static void setDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            chromeOptions.setHeadless(AppParametersHelper.isHeadLess());
            webDriver = new ChromeDriver(chromeOptions);
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            firefoxOptions.setHeadless(AppParametersHelper.isHeadLess());
            webDriver = new FirefoxDriver(firefoxOptions);
        }
        webDriver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (nonNull(webDriver)) {
            webDriver.quit();
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }
}
