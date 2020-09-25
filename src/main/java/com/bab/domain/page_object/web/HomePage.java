package com.bab.domain.page_object.web;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.WebDriverFactory.getWebDriver;
import static com.bab.domain.helpers.AppParametersHelper.getBaseUrl;

public class HomePage {
    private By signInButton = By.className("login");
    private WebDriverWait webDriverWait;

    public HomePage () {
        webDriverWait = new WebDriverWait(getWebDriver(), 10, 30);
    }

    @Step("Launch browser and open URL")
    public void openAndValidate() {
        String baseURL = getBaseUrl();
        getWebDriver().get(baseURL);
        checkElementClickable(signInButton);
    }

    @Step("Click Sign in button to enter username and password")
    public void goToAuthenticationPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void checkElementClickable(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}