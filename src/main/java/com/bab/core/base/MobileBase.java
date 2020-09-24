package com.bab.core.base;

import com.bab.core.driver.MobileDriverFactory;
import com.bab.domain.helpers.AndroidCapabilityHelper;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;

public class MobileBase {

    public void setDriver () {
        try {
            MobileDriverFactory.startAppiumServerAndSetDriver(AndroidCapabilityHelper.getDesiredCapability());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        MobileDriverFactory.quitDriverAndStopAppium();
    }
}
