package com.bab.domain.page_object.android;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bab.core.driver.MobileDriverFactory.getMobileDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage {

    private By pictureOfHouse = By.xpath("//android.widget.ImageView[@content-desc=\"Picture of a house\"]");
    private By clickMeButton = By.id("com.github.fgoncalves.qa:id/OutOfHomeBtn");

    private WebDriverWait webDriverWait;

    public HomePage() {
        webDriverWait = new WebDriverWait(getMobileDriver(), 10, 30);
    }

    @Step("Verify details of home page on successful login")
    public void assertHomePage() {
        assertThat(webDriverWait.until(ExpectedConditions.elementToBeClickable(pictureOfHouse)).isDisplayed(), is(true));
        assertThat(webDriverWait.until(ExpectedConditions.elementToBeClickable(clickMeButton)).isDisplayed(), is(true));
    }
}
