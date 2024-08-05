package com.suncorp;

import com.suncorp.pageobject.PaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import junit.framework.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class ChromeTest {
    WebDriver driver;
    PaymentPage paymentPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        paymentPage = new PaymentPage(driver);
        paymentPage.clickCookieButton();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @DisplayName("Проверка секции 'Услуги связи'")
    @Description("Проверка плейсхолдеров всех полей ввода в секции 'Услуги связи'")
    @Test
    void testCommunicationServices() {
        assertEquals("Номер телефона", paymentPage.getPlaceholderText(paymentPage.getPhoneNumberField()), "Надпись в поле 'Номер телефона' некорректна.");
        testFieldsTotalAndMail();
    }

    @DisplayName("Проверка секции 'Домашний интернет'")
    @Description("Проверка плейсхолдеров всех полей ввода в секции 'Домашний интернет'")
    @Test
    void testHomeInternet() {
        paymentPage.selectOption("Домашний интернет");
        assertEquals("Номер абонента", paymentPage.getPlaceholderText(paymentPage.getPhoneSubscriberField()), "Надпись в поле 'Номер абонента' некорректна.");
        testFieldsTotalAndMail();
    }

    @DisplayName("Проверка секции 'Рассрочка'")
    @Description("Проверка плейсхолдеров всех полей ввода в секции 'Рассрочка'")
    @Test
    void testInstallmentPlan() {
        paymentPage.selectOption("Рассрочка");
        assertEquals("Номер счета на 44", paymentPage.getPlaceholderText(paymentPage.getInstallmentPlanField()), "Надпись в поле 'Номер счета' некорректна.");
        testFieldsTotalAndMail();
    }

    @DisplayName("Проверка секции 'Задолженность'")
    @Description("Проверка плейсхолдеров всех полей ввода в секции 'Задолженность'")
    @Test
    void testDebt() {
        paymentPage.selectOption("Задолженность");
        assertEquals("Номер счета на 2073", paymentPage.getPlaceholderText(paymentPage.getDebtField()), "Надпись в поле 'Номер счета' некорректна.");
        testFieldsTotalAndMail();
    }

    @DisplayName("Проверка второй страницы")
    @Description("Проверка плейсхолдеров всех полей ввода после нажатия кнопки 'Продолжить'")
    @Test
    void testAfterContinue() {
        continueButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        Assert.assertEquals("100.00 BYN", wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".pay-description__cost > span:nth-child(1)"))).getText());

        assertEquals("100.00 BYN", paymentPage.getTitlePriceText(), "Цена на кнопке не совпадает.");
        assertEquals("Оплатить 100.00 BYN", paymentPage.getButtonPriceText(), "Цена сверху не совпадает.");
        assertEquals("Оплата: Услуги связи Номер:375297777777", paymentPage.getPhoneFieldText(), "Номер не совпадает.");
        assertEquals("Номер карты", paymentPage.getCardNumberLabelText(), "Надпись в поле 'Номер карты' некорректна.");
        assertEquals("CVC", paymentPage.getCvcNumberLabelText(), "Надпись в поле 'CVC' некорректна.");
        assertEquals("Срок действия", paymentPage.getValidityLabelText(), "Надпись в поле 'Срок действия' некорректна.");
        assertEquals("Имя держателя (как на карте)", paymentPage.getCardOwnerLabelText(), "Надпись в поле 'Имя держателя (как на карте)' некорректна.");
        assertFalse(paymentPage.arePaymentLogosPresent(), "Логотипы платёжных систем не найдены.");
    }

    public void testFieldsTotalAndMail() {
        assertEquals("Сумма", paymentPage.getPlaceholderText(paymentPage.getTotalField()), "Надпись в поле 'Сумма' некорректна.");
        assertEquals("E-mail для отправки чека", paymentPage.getPlaceholderText(paymentPage.getEmailField()), "Надпись в поле 'E-mail' некорректна.");
    }

    public void continueButton() {
        paymentPage.enterPhoneNumber("297777777");
        paymentPage.enterPrice("100");
        paymentPage.clickContinueButton();
    }
}
