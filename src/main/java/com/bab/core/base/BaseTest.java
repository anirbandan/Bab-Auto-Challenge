package com.bab.core.base;

import com.bab.core.driver.DriverFactory;

public class BaseTest {

    public void setDriver() {
        DriverFactory.setDriver("Chrome");
    }

    public void tearDownDriver() {
        DriverFactory.quitDriver();
    }
}
