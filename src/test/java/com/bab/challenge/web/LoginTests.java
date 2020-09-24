package com.bab.challenge.web;

import com.bab.core.base.WebBase;
import com.bab.domain.page_object.AuthenticationPage;
import com.bab.domain.page_object.HomePage;
import com.bab.domain.page_object.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends WebBase {
    @BeforeMethod
    public void setUp() {
        super.setDriver();
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
    }

    @Test
    public void loginTest() {
        homePage.openAndValidate();
        homePage.goToAuthenticationPage();
        authenticationPage.enterEmailForLogin("babbeltest@gmail.com");
        authenticationPage.enterPassword("testpass");
        authenticationPage.submitLoginForm();
        myAccountPage.assertMyAccountPage();
    }
}