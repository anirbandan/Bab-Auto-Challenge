package com.bab.challenge.web;

import com.bab.core.base.TestListener;
import com.bab.core.base.WebBase;
import com.bab.domain.page_object.web.AuthenticationPage;
import com.bab.domain.page_object.web.HomePage;
import com.bab.domain.page_object.web.MyAccountPage;
import org.testng.annotations.*;

import java.util.UUID;

@Listeners({TestListener.class})
public class LoginTests extends WebBase {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        super.setDriver(browser);
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        myAccountPage = new MyAccountPage();
    }

    @DataProvider(name = "data-provider")
    public Object[][] feedTestData() {
        String emailId = "babbeltest@gmail.com";
        String password = "testpass";
        return new Object[][] {{emailId, password}};
    }

    @Test(dataProvider = "data-provider")
    public void loginTest(String emailId, String password) {
        homePage.openAndValidate();
        homePage.goToAuthenticationPage();
        authenticationPage.enterEmailForLogin(emailId);
        authenticationPage.enterPassword(password);
        authenticationPage.submitLoginForm();
        myAccountPage.assertMyAccountPage();
    }
}