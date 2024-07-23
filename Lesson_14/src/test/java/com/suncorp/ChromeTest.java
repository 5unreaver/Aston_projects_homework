package com.suncorp;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ChromeTest {
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement button = driver.findElement(By.xpath
                ("//button[@class='btn btn_gray cookie__cancel']"));
        button.click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Order(4)
    void testContinueButton() {
        WebElement phoneNumberField = driver.findElement(By.xpath
            ("//input[@placeholder='Номер телефона']"));
        phoneNumberField.sendKeys("297777777");

        WebElement priceField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        priceField.sendKeys("100");

        WebElement continueButton = driver.findElement(By.xpath
            ("//form[@class='pay-form opened']//button[@class='button button__default ']"));
        continueButton.click();
    }

    @Test
    @Order(5)
    void testCommunicationServices() {
        WebElement phoneFieldCommunicationServices = driver.findElement(By.xpath("//input[@placeholder='Номер телефона']"));
        assertEquals("Номер телефона", phoneFieldCommunicationServices.getAttribute("placeholder"), "Надпись в поле 'Номер телефона' некорректна.");
        testFieldsTotalAndMail();
    }

    @Test
    @Order(6)
    void testHomeInternet() {
        openDropbox();
        WebElement homeInternet = driver.findElement(By.xpath("//p[@class='select__option' and text()='Домашний интернет']"));
        homeInternet.click();

        WebElement contractHomeInternetField = driver.findElement(By.xpath("//input[@placeholder='Номер абонента']"));
        assertEquals("Номер абонента", contractHomeInternetField.getAttribute("placeholder"), "Надпись в поле 'Номер абонента' некорректна.");

        testFieldsTotalAndMail();
    }

    @Test
    @Order(7)
    void testInstallmentPlan() {
        openDropbox();
        WebElement installmentPlan = driver.findElement(By.xpath("//p[@class='select__option' and text()='Рассрочка']"));
        installmentPlan.click();

        WebElement contractInstallmentPlanField = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"));
        assertEquals("Номер счета на 44", contractInstallmentPlanField.getAttribute("placeholder"), "Надпись в поле 'Номер счета' некорректна.");

        testFieldsTotalAndMail();
    }

    @Test
    @Order(8)
    void testDebt() {
        openDropbox();
        WebElement debtTab = driver.findElement(By.xpath("//p[@class='select__option' and text()='Рассрочка']"));
        debtTab.click();

        WebElement debtContractField = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 2073']"));
        assertEquals("Номер счета на 2073", debtContractField.getAttribute("placeholder"), "Надпись в поле 'Номер счета' некорректна.");

        testFieldsTotalAndMail();
    }

    // Полностью пункт 2 домашнего задания
    @Test
    @Order(8)
    void testAfterContinue() {
        testContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        Assert.assertEquals("100.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".pay-description__cost > span:nth-child(1)"))).getText());

        WebElement titlePriceAfterContinue = driver.findElement(By.cssSelector(".pay-description__cost > span:nth-child(1)"));
        assertEquals("100.00 BYN",
                titlePriceAfterContinue.getText(), "Цена на кпопке не совпадает.");

        WebElement buttonPriceFieldAfterContinue = driver.findElement(By.cssSelector(".colored.disabled"));
        assertEquals("Оплатить 100.00 BYN",
                buttonPriceFieldAfterContinue.getText(), "Цена сверху не совпадает.");

        WebElement phoneFieldAfterContinue = driver.findElement(By.cssSelector(".pay-description__text > span"));
        assertEquals("Оплата: Услуги связи Номер:375297777777",
                phoneFieldAfterContinue.getText(), "Номер не совпадает.");

        WebElement cardNumberFieldAfterContinue = driver.findElement(By.xpath("//div[@class='content ng-tns-c46-1']/label"));
        assertEquals("Номер карты",
                cardNumberFieldAfterContinue.getText(), "Надпись в поле 'Номер карты' некорректна.");

        WebElement cvcNumberFieldAfterContinue = driver.findElement(By.xpath("//div[@class='content ng-tns-c46-5']/label"));
        assertEquals("CVC",
                cvcNumberFieldAfterContinue.getText(), "Надпись в поле 'CVC' некорректна.");

        WebElement validityFieldAfterContinue = driver.findElement(By.xpath("//div[@class='content ng-tns-c46-4']/label"));
        assertEquals("Срок действия",
                validityFieldAfterContinue.getText(), "Надпись в поле 'Срок действия' некорректна.");

        WebElement cardownerFieldAfterContinue = driver.findElement(By.xpath("//div[@class='content ng-tns-c46-3']/label"));
        assertEquals("Имя держателя (как на карте)",
                cardownerFieldAfterContinue.getText(), "Надпись в поле 'Имя держателя (как на карте)' некорректна.");

        List<WebElement> paymentLogosAfterContinue = driver.findElements(By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img"));
        assertFalse(paymentLogosAfterContinue.isEmpty(), "Логотипы платёжных систем не найдены.");
    }

    // Тестирование полей "Сумма" и "mail"
    public void testFieldsTotalAndMail() {
        WebElement totalField = driver.findElement(By.xpath("//input[@placeholder='Сумма']"));
        assertEquals("Сумма", totalField.getAttribute("placeholder"), "Надпись в поле 'Сумма' некорректна.");

        WebElement mailField = driver.findElement(By.xpath("//input[@placeholder='E-mail для отправки чека']"));
        assertEquals("E-mail для отправки чека", mailField.getAttribute("placeholder"), "Надпись в поле 'E-mail' некорректна.");
    }

    // Открытие выпадающего списка
    public void openDropbox() {
        WebElement selectDrop = driver.findElement(By.xpath("//button[@class='select__header']"));
        selectDrop.click();
    }
}