package com.bab.challenge.android;

import com.bab.core.base.MobileBase;
import com.bab.core.base.TestListener;
import com.bab.domain.page_object.android.AuthenticationPage;
import com.bab.domain.page_object.android.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "data-provider")
    public Object[][] feedTestData() {
        String emailId = "arthur@gmail.com";
        String password = "98765";
        return new Object[][] {{emailId, password}};
    }

    @Test(dataProvider = "data-provider")
    public void loginTest(String emailId, String password) {
        authenticationPage.enterEmailForLogin(emailId);
        authenticationPage.enterPassword(password);
        authenticationPage.submitLoginForm();
        homePage.assertHomePage();
    }
}
