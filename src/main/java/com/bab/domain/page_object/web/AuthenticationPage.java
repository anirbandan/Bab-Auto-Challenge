package com.bab.domain.page_object.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.WebDriverFactory.getDriver;

public class AuthenticationPage {

    private By createAccountEmailField = By.id("email_create");
    private By createAccountButton = By.id("SubmitCreate");

    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");

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