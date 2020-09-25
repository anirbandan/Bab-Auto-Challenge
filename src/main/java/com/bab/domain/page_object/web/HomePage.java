package com.bab.domain.page_object.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.WebDriverFactory.getDriver;
import static com.bab.domain.helpers.AppParametersHelper.getBaseUrl;

public class HomePage {
    private By signInButton = By.className("login");
    private WebDriverWait webDriverWait;

    public HomePage () {
        webDriverWait = new WebDriverWait(getDriver(), 10, 30);
    }

    public void openAndValidate() {
        String baseURL = getBaseUrl();
        getDriver().get(baseURL);
        checkElementClickable(signInButton);
    }

    public void goToAuthenticationPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void checkElementClickable(By by) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}