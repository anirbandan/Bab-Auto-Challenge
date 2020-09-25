package com.bab.challenge.android;

import com.bab.core.base.MobileBase;
import com.bab.core.base.TestListener;
import com.bab.domain.page_object.android.AuthenticationPage;
import com.bab.domain.page_object.android.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class})
public class LoginTests extends MobileBase {

    @BeforeMethod
    public void setUp() {
        super.setDriver();
        authenticationPage = new AuthenticationPage();
        homePage = new HomePage();
    }

    @Test
    public void loginTest() {
        authenticationPage.enterEmailForLogin("arthur@gmail.com");
        authenticationPage.enterPassword("98765");
        authenticationPage.submitLoginForm();
        homePage.assertHomePage();
    }
}
