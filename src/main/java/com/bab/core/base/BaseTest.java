package com.bab.core.base;

import com.bab.core.driver.DriverFactory;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    public void setDriver() {
        DriverFactory.setDriver("Chrome");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        DriverFactory.quitDriver();
    }
}
