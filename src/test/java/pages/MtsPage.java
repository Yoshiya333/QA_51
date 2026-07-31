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
}