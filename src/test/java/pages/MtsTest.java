import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsTest {

    @Test
    public void openSiteTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        MtsPage mtsPage = new MtsPage(driver);

        mtsPage.openSite();
        mtsPage.acceptCookies();

        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", mtsPage.getTitle());

        driver.quit();
    }

    @Test
    public void checkPaymentLogosTest() {
        WebDriver driver = new ChromeDriver();
        MtsPage mtsPage = new MtsPage(driver);

        mtsPage.openSite();
        mtsPage.acceptCookies();

        List<WebElement> logos = mtsPage.getPaymentLogos();

        assertEquals(5, logos.size());
        assertEquals("Visa", logos.get(0).getAttribute("alt"));
        assertEquals("Verified By Visa", logos.get(1).getAttribute("alt"));
        assertEquals("MasterCard", logos.get(2).getAttribute("alt"));
        assertEquals("MasterCard Secure Code", logos.get(3).getAttribute("alt"));
        assertEquals("Белкарт", logos.get(4).getAttribute("alt"));

        driver.quit();
    }

    @Test
    public void checkMoreInfoLinkTest() {
        WebDriver driver = new ChromeDriver();
        MtsPage mtsPage = new MtsPage(driver);

        mtsPage.openSite();
        mtsPage.acceptCookies();
        mtsPage.clickMoreInfo();
        mtsPage.waitForMoreInfoPage();

        assertTrue(mtsPage.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        driver.quit();
    }

    @Test
    public void checkContinueButtonTest() {
        WebDriver driver = new ChromeDriver();
        MtsPage mtsPage = new MtsPage(driver);

        mtsPage.openSite();
        mtsPage.acceptCookies();
        mtsPage.enterPhone("297777777");
        mtsPage.enterSum("50");
        mtsPage.enterEmail("abrakadabra228@test.com");
        mtsPage.clickContinue();

        driver.quit();
    }

    @Test
    public void checkAllPlaceholdersTest() {

        WebDriver driver = new ChromeDriver();

        MtsPage mtsPage = new MtsPage(driver);

        mtsPage.openSite();

        mtsPage.acceptCookies();

        // -------------------------
        // Услуги связи
        // -------------------------

        assertEquals(
                "Номер телефона",
                mtsPage.getPlaceholder("connection-phone")
        );

        assertEquals(
                "Сумма",
                mtsPage.getPlaceholder("connection-sum")
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getPlaceholder("connection-email")
        );

        // -------------------------
        // Домашний интернет
        // -------------------------

        mtsPage.selectService("Домашний интернет");

        assertEquals(
                "Номер абонента",
                mtsPage.getPlaceholder("internet-phone")
        );

        assertEquals(
                "Сумма",
                mtsPage.getPlaceholder("internet-sum")
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getPlaceholder("internet-email")
        );

        // -------------------------
        // Рассрочка
        // -------------------------

        mtsPage.selectService("Рассрочка");

        assertEquals(
                "Номер счета на 44",
                mtsPage.getPlaceholder("score-instalment")
        );


        assertEquals(
                "Сумма",
                mtsPage.getPlaceholder("instalment-sum")
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getPlaceholder("instalment-email")
        );

        // -------------------------
        // Задолженность
        // -------------------------

        mtsPage.selectService("Задолженность");

        assertEquals(
                "Номер счета на 2073",
                mtsPage.getPlaceholder("score-arrears")
        );

        assertEquals(
                "Сумма",
                mtsPage.getPlaceholder("arrears-sum")
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getPlaceholder("arrears-email")
        );

        driver.quit();
    }
}