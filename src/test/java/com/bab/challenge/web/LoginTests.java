package com.bab.challenge.web;

import com.bab.core.base.BaseTest;
import com.bab.domain.page_object.AuthenticationPage;
import com.bab.domain.page_object.HomePage;
import com.bab.domain.page_object.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
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