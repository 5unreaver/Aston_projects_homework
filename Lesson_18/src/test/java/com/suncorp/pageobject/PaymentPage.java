package com.suncorp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локаторы
    private By cookieButton = By.xpath("//button[@class='btn btn_gray cookie__cancel']");
    private By phoneNumberField = By.xpath("//input[@placeholder='Номер телефона']");
    private By phoneSubscriberField = By.xpath("//input[@placeholder='Номер абонента']");
    private By priceField = By.xpath("//input[@placeholder='Сумма']");
    private By continueButton = By.xpath("//form[@class='pay-form opened']//button[@class='button button__default ']");
    private By selectDrop = By.xpath("//button[@class='select__header']");
    private By emailField = By.xpath("//input[@placeholder='E-mail для отправки чека']");
    private By totalField = By.xpath("//input[@placeholder='Сумма']");
    private By installmentPlanField = By.xpath("//input[@placeholder='Номер счета на 44']");
    private By debtField = By.xpath("//input[@placeholder='Номер счета на 2073']");

    private By titlePrice = By.cssSelector(".pay-description__cost > span:nth-child(1)");
    private By buttonPrice = By.cssSelector(".colored.disabled");
    private By phoneField = By.cssSelector(".pay-description__text > span");
    private By cardNumberLabel = By.xpath("//div[@class='content ng-tns-c46-1']/label");
    private By cvcNumberLabel = By.xpath("//div[@class='content ng-tns-c46-5']/label");
    private By validityLabel = By.xpath("//div[@class='content ng-tns-c46-4']/label");
    private By cardOwnerLabel = By.xpath("//div[@class='content ng-tns-c46-3']/label");
    private By paymentLogos = By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img");

    // Методы для взаимодействия
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void enterPrice(String price) {
        driver.findElement(priceField).sendKeys(price);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void openDropDown() {
        driver.findElement(selectDrop).click();
    }

    public void selectOption(String optionText) {
        openDropDown();
        WebElement option = driver.findElement(By.xpath("//p[@class='select__option' and text()='" + optionText + "']"));
        option.click();
    }

    public String getPlaceholderText(WebElement element) {
        return element.getAttribute("placeholder");
    }

    public WebElement getPhoneNumberField() {
        return driver.findElement(phoneNumberField);
    }

    public WebElement getInstallmentPlanField() {
        return driver.findElement(installmentPlanField);
    }

    public WebElement getDebtField() {
        return driver.findElement(debtField);
    }

    public WebElement getPhoneSubscriberField() {
        return driver.findElement(phoneSubscriberField);
    }

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getTotalField() {
        return driver.findElement(totalField);
    }

    public String getTitlePriceText() {
        return driver.findElement(titlePrice).getText();
    }

    public String getButtonPriceText() {
        return driver.findElement(buttonPrice).getText();
    }

    public String getPhoneFieldText() {
        return driver.findElement(phoneField).getText();
    }

    public String getCardNumberLabelText() {
        return driver.findElement(cardNumberLabel).getText();
    }

    public String getCvcNumberLabelText() {
        return driver.findElement(cvcNumberLabel).getText();
    }

    public String getValidityLabelText() {
        return driver.findElement(validityLabel).getText();
    }

    public String getCardOwnerLabelText() {
        return driver.findElement(cardOwnerLabel).getText();
    }

    public boolean arePaymentLogosPresent() {
        List<WebElement> logos = driver.findElements(paymentLogos);
        return logos.isEmpty();
    }

    // Пример дополнительного метода для получения текстового значения с элемента
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
