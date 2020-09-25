package com.bab.domain.page_object.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.WebDriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MyAccountPage {

    private By heading = By.cssSelector("h1");
    private By welcomeText = By.className("info-account");
    private By signOutButton = By.className("logout");
    private By menuCategories = By.cssSelector(".sf-menu>li");

    private WebDriverWait webDriverWait;

    public MyAccountPage() {
        webDriverWait = new WebDriverWait(getDriver(), 10, 30);
    }

    public void assertMyAccountPage() {
        assertThat(webDriverWait.until(ExpectedConditions.elementToBeClickable(heading)).getText(), is("MY ACCOUNT"));
        assertThat(webDriverWait.until(ExpectedConditions.elementToBeClickable(welcomeText)).getText(),
                containsString("Welcome to your account."));
        assertThat(webDriverWait.until(ExpectedConditions.elementToBeClickable(signOutButton)).isDisplayed(), is(true));
    }
}
