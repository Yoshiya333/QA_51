package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openSite() {
        driver.get("https://www.mts.by");
    }

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
    }

    public String getTitle() {
        return driver.findElement(By.cssSelector(".pay__wrapper h2"))
                .getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(By.cssSelector(".pay__partners img"));
    }

    public void clickMoreInfo() {
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
    }

    public void waitForMoreInfoPage() {
        wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void enterPhone(String phone) {
        driver.findElement(By.id("connection-phone")).sendKeys(phone);
    }

    public void enterSum(String sum) {
        driver.findElement(By.id("connection-sum")).sendKeys(sum);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("connection-email")).sendKeys(email);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#pay-connection .button"))).click();
    }

    // Открыть список услуг
    public void openServiceList() {
        driver.findElement(By.cssSelector(".select__header")).click();
    }

    // Выбрать услугу
    public void selectService(String serviceName) {

        openServiceList();

        driver.findElement(
                By.xpath("//p[text()='" + serviceName + "']")
        ).click();
    }

    // Получить placeholder любого поля по id
    public String getPlaceholder(String id) {

        return driver.findElement(By.id(id))
                .getAttribute("placeholder");
    }

    // ---------- Проверка окна оплаты ----------

    // Сумма
    public String getPaymentAmount() {
        return driver.findElement(
                By.cssSelector(".pay-description__cost span")
        ).getText().trim();
    }

    // Информация об оплате
    public String getPaymentInfo() {
        return driver.findElement(
                        By.cssSelector(".pay-description__text span")
                ).getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

    // Текст кнопки "Оплатить"
    public String getPayButtonText() {
        return driver.findElement(
                        By.cssSelector("button.colored span")
                ).getText()
                .replaceAll("\\s+", " ")
                .trim();
    }

// ---------- Названия полей карты ----------

    public String getCardNumberLabel() {
        return driver.findElement(
                By.xpath("//label[text()='Номер карты']")
        ).getText();
    }

    public String getExpireLabel() {
        return driver.findElement(
                By.xpath("//label[text()='Срок действия']")
        ).getText();
    }

    public String getCvcLabel() {
        return driver.findElement(
                By.xpath("//label[text()='CVC']")
        ).getText();
    }

    public String getCardHolderLabel() {
        return driver.findElement(
                By.xpath("//label[text()='Имя и фамилия на карте']")
        ).getText();
    }

// ---------- Логотипы карт ----------

    public boolean visaLogoDisplayed() {
        return driver.findElement(
                By.cssSelector("img[src*='visa-system']")
        ).isDisplayed();
    }

    public boolean masterCardLogoDisplayed() {
        return driver.findElement(
                By.cssSelector("img[src*='mastercard-system']")
        ).isDisplayed();
    }

    public boolean belkartLogoDisplayed() {
        return driver.findElement(
                By.cssSelector("img[src*='belkart-system']")
        ).isDisplayed();
    }

    public void switchToPaymentFrame() {

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector(".payment-widget-iframe")
        ));

    }
}