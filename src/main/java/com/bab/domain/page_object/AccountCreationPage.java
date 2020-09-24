package com.bab.domain.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

import static com.bab.core.driver.WebDriverFactory.getDriver;

public class AccountCreationPage {

    private By mrsRadioButton = By.id("id_gender2");
    private By firstNameField = By.id("customer_firstname");
    private By lastNameField = By.id("customer_lastname");
    private By passwordField = By.id("passwd");
    private By dayOfBirthSelector = By.id("days");
    private By monthOfBirthSelector = By.id("months");
    private By yearOfBirthSelector = By.id("years");

    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By cityField = By.id("city");
    private By stateField = By.id("id_state");
    private By postCodeField = By.id("postcode");
    private By additionalInfoField = By.id("other");
    private By homePhoneField = By.id("phone");
    private By mobilePhoneField = By.id("phone_mobile");
    private By aliasField = By.id("alias");

    private By registerButton = By.id("submitAccount");

    private WebDriverWait webDriverWait;

    public AccountCreationPage() {
        webDriverWait = new WebDriverWait(getDriver(), 10, 30);
    }

    public void fillOutPersonalInformation(String firstName, String lastName, String password, String day,
                                           String month, String year) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mrsRadioButton)).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(dayOfBirthSelector))).selectByValue(day);
        new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(monthOfBirthSelector))).selectByValue(month);
        new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(yearOfBirthSelector))).selectByValue(year);
    }

    public void fillOutAddressInformation() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(companyField)).sendKeys(UUID.randomUUID().toString());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(address1Field)).sendKeys("Address");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(address2Field)).sendKeys(UUID.randomUUID().toString());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(cityField)).sendKeys(UUID.randomUUID().toString());
        new Select(webDriverWait.until(ExpectedConditions.presenceOfElementLocated(stateField))).selectByValue("2");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(postCodeField)).sendKeys("11111");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(additionalInfoField)).sendKeys("Additional information");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(homePhoneField)).sendKeys("777777777");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(mobilePhoneField)).sendKeys("777777777");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(aliasField)).sendKeys("alias");
    }

    public void submitAccountCreation() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
    }
}
