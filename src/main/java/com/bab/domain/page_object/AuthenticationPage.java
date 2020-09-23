package com.bab.domain.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.DriverFactory.getDriver;

public class AuthenticationPage {

    private By createAccountEmailField = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");

    private WebDriverWait webDriverWait;

    public AuthenticationPage() {
        webDriverWait = new WebDriverWait(getDriver(), 10, 30);
    }

    public void enterEmailForAccountCreation(String email) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(createAccountEmailField)).sendKeys(email);
    }

    public void submitEmailRegistration() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }
}