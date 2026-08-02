package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsPaymentTest {

    private WebDriver driver;
    private MtsPage mtsPage;

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mtsPage = new MtsPage(driver);

        mtsPage.openSite();
        mtsPage.acceptCookies();
    }

    @Test
    public void checkPaymentWindowTest() {

        // Заполняем форму
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("50");
        mtsPage.enterEmail("abrakadabra228@test.com");

        // Переходим к оплате
        mtsPage.clickContinue();

        // Переходим в iframe
        mtsPage.switchToPaymentFrame();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ждём появления окна оплаты
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".pay-description__cost")
        ));

        // Проверяем сумму
        assertEquals("50.00 BYN", mtsPage.getPaymentAmount());

        // Проверяем информацию
        assertEquals(
                "Оплата: Услуги связи Номер:375297777777",
                mtsPage.getPaymentInfo()
        );

        // Проверяем кнопку
        assertEquals(
                "Оплатить 50.00 BYN",
                mtsPage.getPayButtonText()
        );

        // Проверяем подписи полей
        assertEquals("Номер карты", mtsPage.getCardNumberLabel());
        assertEquals("Срок действия", mtsPage.getExpireLabel());
        assertEquals("CVC", mtsPage.getCvcLabel());
        assertEquals("Имя и фамилия на карте", mtsPage.getCardHolderLabel());

        // Проверяем логотипы
        assertTrue(mtsPage.visaLogoDisplayed());
        assertTrue(mtsPage.masterCardLogoDisplayed());
        assertTrue(mtsPage.belkartLogoDisplayed());
    }

    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}