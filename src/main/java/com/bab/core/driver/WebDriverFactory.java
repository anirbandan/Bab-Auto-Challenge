package com.bab.core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;

public class WebDriverFactory {
    static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    static final Map<String, Supplier<WebDriver>> driverMap = new HashMap<>();
    static final Supplier<WebDriver> chromeDriverSupplier = ChromeDriver::new;
    static final Supplier<WebDriver> firefoxDriverSupplier = FirefoxDriver::new;

    static {
        driverMap.put("Chrome", chromeDriverSupplier);
        driverMap.put("Firefox", firefoxDriverSupplier);
    }

    public static void setDriver(String browserType) {
        webDriver.set(driverMap.get(browserType).get());
        webDriver.get().manage().window().maximize();
    }

    public static void quitDriver() {
        if (nonNull(webDriver.get())) {
            webDriver.get().quit();
        }
        webDriver.remove();
    }

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }
}
