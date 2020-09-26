package com.bab.challenge.web;

import com.bab.core.base.TestListener;
import com.bab.core.base.WebBase;
import com.bab.domain.page_object.web.AccountCreationPage;
import com.bab.domain.page_object.web.AuthenticationPage;
import com.bab.domain.page_object.web.HomePage;
import com.bab.domain.page_object.web.MyAccountPage;
import org.testng.annotations.*;

import java.util.UUID;

@Listeners({TestListener.class})
public class SignUpTests extends WebBase {

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        super.setDriver(browser);
        homePage = new HomePage();
        authenticationPage = new AuthenticationPage();
        accountCreationPage = new AccountCreationPage();
        myAccountPage = new MyAccountPage();
    }

    @DataProvider(name = "data-provider")
    public Object[][] feedTestData() {
        int testDataVariations = 1;
        Object[][] testData = new Object[testDataVariations][1];
        for (int instance = 0; instance < testDataVariations; instance++) {
            testData[instance][0] = UUID.randomUUID().toString() + "@gmail.com";
        }
        return testData;
    }

    @Test(dataProvider = "data-provider")
    public void signUpTest(String randomEmailId) {
        homePage.openAndValidate();
        homePage.goToAuthenticationPage();
        authenticationPage.enterEmailForAccountCreation(randomEmailId);
        authenticationPage.submitEmailRegistration();
        accountCreationPage.fillOutPersonalInformation("Anirban", "Dan", "testpass", "15", "2", "1995");
        accountCreationPage.fillOutAddressInformation();
        accountCreationPage.submitAccountCreation();
        myAccountPage.assertMyAccountPage();
    }
}