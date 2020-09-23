package com.bab.challenge.web;

import com.bab.core.base.BaseTest;
import com.bab.domain.page_object.AccountCreationPage;
import com.bab.domain.page_object.AuthenticationPage;
import com.bab.domain.page_object.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    HomePage homePage;
    AuthenticationPage authenticationPage;
    AccountCreationPage accountCreationPage;

    @BeforeMethod
    public void setUp() {
        super.setDriver();
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        accountCreationPage = new AccountCreationPage();
    }

    @Test
    public void signUpTest() {
        homePage.openAndValidate();
        homePage.goToAuthenticationPage();
        authenticationPage.enterEmailForAccountCreation("test41414@gmail.com");
        authenticationPage.submitEmailRegistration();
        accountCreationPage.fillOutPersonalInformation("Anirban", "Dan", "testpass", "15", "2", "1995");
        accountCreationPage.fillOutAddressInformation();
        accountCreationPage.submitAccountCreation();
    }
}