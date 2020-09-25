package com.bab.core.base;

import com.bab.core.driver.WebDriverFactory;
import com.bab.domain.page_object.web.AccountCreationPage;
import com.bab.domain.page_object.web.AuthenticationPage;
import com.bab.domain.page_object.web.HomePage;
import com.bab.domain.page_object.web.MyAccountPage;
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
