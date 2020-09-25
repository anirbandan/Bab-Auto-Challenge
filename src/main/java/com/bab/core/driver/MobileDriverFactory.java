package com.bab.core.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileDriverFactory {

    static AndroidDriver<MobileElement> androidDriver;
    static AppiumDriverLocalService appiumService;
    static String appiumUrl;

    public static void startAppiumServerAndSetDriver(DesiredCapabilities capabilities) throws MalformedURLException{

        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        appiumUrl = appiumService.getUrl().toString();
        androidDriver = new AndroidDriver<>(new URL(appiumUrl), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public static void quitDriverAndStopAppium() {
        androidDriver.quit();
        appiumService.stop();
    }

    public static AndroidDriver getMobileDriver() {
        return androidDriver;
    }
}
