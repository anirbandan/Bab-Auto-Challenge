package com.bab.challenge.web;

import com.bab.core.base.TestListener;
import com.bab.core.base.WebBase;
import com.bab.domain.page_object.web.AccountCreationPage;
import com.bab.domain.page_object.web.AuthenticationPage;
import com.bab.domain.page_object.web.HomePage;
import com.bab.domain.page_object.web.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.UUID;

@Listeners({TestListener.class})
public class SignUpTests extends WebBase {

    @BeforeMethod
    public void setUp() {
        super.setDriver();
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        accountCreationPage = new AccountCreationPage();
        myAccountPage = new MyAccountPage();
    }

    @Test
    public void signUpTest() {
        homePage.openAndValidate();
        homePage.goToAuthenticationPage();
        authenticationPage.enterEmailForAccountCreation(UUID.randomUUID().toString() + "@gmail.com");
        authenticationPage.submitEmailRegistration();
        accountCreationPage.fillOutPersonalInformation("Anirban", "Dan", "testpass", "15", "2", "1995");
        accountCreationPage.fillOutAddressInformation();
        accountCreationPage.submitAccountCreation();
        myAccountPage.assertMyAccountPage();
    }
}