package com.bab.core.base;

import com.bab.core.driver.WebDriverFactory;
import com.bab.domain.page_object.AccountCreationPage;
import com.bab.domain.page_object.AuthenticationPage;
import com.bab.domain.page_object.HomePage;
import com.bab.domain.page_object.MyAccountPage;
import org.testng.annotations.AfterMethod;

public class WebBase {

    protected HomePage homePage;
    protected AuthenticationPage authenticationPage;
    protected AccountCreationPage accountCreationPage;
    protected MyAccountPage myAccountPage;

    public void setDriver() {
        WebDriverFactory.setDriver("Chrome");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        WebDriverFactory.quitDriver();
    }
}
