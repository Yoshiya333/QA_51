package pages;

import pages.MtsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {


    //Открываем сайт, принимаем куки, сверяем заголовок указанного блока.
    @Test
    public void openSiteTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();

        By.cssSelector(".pay__wrapper h2");
        String actualTitle = driver.findElement(By.cssSelector(".pay__wrapper h2"))
                .getText()
                .replaceAll("\\s+", " ")
                .trim();
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualTitle);

        driver.quit();
    }

    //Проверяем логотипы банков для оплаты
    @Test
    public void checkPaymentLogosTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();

        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners img"));

        assertEquals(5, logos.size());

        assertEquals("Visa", logos.get(0).getAttribute("alt"));
        assertEquals("Verified By Visa", logos.get(1).getAttribute("alt"));
        assertEquals("MasterCard", logos.get(2).getAttribute("alt"));
        assertEquals("MasterCard Secure Code", logos.get(3).getAttribute("alt"));
        assertEquals("Белкарт", logos.get(4).getAttribute("alt"));

        driver.quit();
    }

    //Проверяем работу ссылки "Подробнее о сервисе"
    @Test
    public void checkMoreInfoLinkTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();

        WebElement moreInfo = driver.findElement(By.linkText("Подробнее о сервисе"));

        moreInfo.click();

        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));

        driver.quit();
    }

    //Проверяем кнопку "Продолжить", предварительно введя данные в необходимые поля.
    @Test
    public void checkContinueButtonTest() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.mts.by");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();

        driver.findElement(By.id("connection-phone"))
                .sendKeys("297777777");

        driver.findElement(By.id("connection-sum"))
                .sendKeys("50");

        driver.findElement(By.id("connection-email"))
                .sendKeys("abrakadabra228@test.com");

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("#pay-connection .button")
                )
        );

        continueButton.click();

        driver.findElement(By.cssSelector("#pay-connection .button"));

        driver.quit();
    }
}