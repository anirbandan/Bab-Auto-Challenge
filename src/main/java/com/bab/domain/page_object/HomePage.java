package com.bab.domain.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.DriverFactory.getDriver;

public class HomePage {
    private By signInButton = By.className("login");
    private WebDriverWait webDriverWait;

    public HomePage () {
        webDriverWait = new WebDriverWait(getDriver(), 10, 30);
    }

    public void openAndValidate() {
        String baseURL = "http://automationpractice.com/index.php";
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