package com.bab.domain.page_object.android;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.MobileDriverFactory.getMobileDriver;

public class AuthenticationPage {

    private By emailField = By.id("com.github.fgoncalves.qa:id/email");
    private By passwordField = By.id("com.github.fgoncalves.qa:id/password");
    private By signInButton = By.id("com.github.fgoncalves.qa:id/email_sign_in_button");

    private WebDriverWait webDriverWait;

    public AuthenticationPage() {
        webDriverWait = new WebDriverWait(getMobileDriver(), 10, 30);
    }

    public void enterEmailForLogin(String email) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void submitLoginForm() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}