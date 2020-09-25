package com.bab.core.base;

import com.bab.core.driver.MobileDriverFactory;
import com.bab.domain.helpers.AndroidCapabilityHelper;
import com.bab.domain.page_object.android.AuthenticationPage;
import com.bab.domain.page_object.android.HomePage;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;

public class MobileBase {

    protected AuthenticationPage authenticationPage;
    protected HomePage homePage;

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
