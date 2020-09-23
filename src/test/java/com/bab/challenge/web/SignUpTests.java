package com.bab.challenge.web;

import com.bab.core.base.BaseTest;
import com.bab.domain.page_object.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTest {

    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        super.setDriver();
        homePage = new HomePage();
    }

    @Test
    public void signUpTest() {
        homePage.openAndValidate();
    }
}