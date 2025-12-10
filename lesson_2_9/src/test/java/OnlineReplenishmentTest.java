import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class OnlineReplenishmentTest {

    static private WebDriver driver;

    @BeforeAll
    public static void beforeTests() {
        driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        WebElement denieButton = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
        denieButton.click();
    }

    @DisplayName("Тест названия блока")
    @Test
    void blockNameTest() {
        WebElement name = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        System.out.println(name.getText());
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", name.getText());
    }

    @DisplayName("Тестирование логотипов платежных систем")
    @Test
    void logoTest() {
        List<String> cardsTestData = new ArrayList<>();
        cardsTestData.add("Visa");
        cardsTestData.add("Verified By Visa");
        cardsTestData.add("MasterCard");
        cardsTestData.add("MasterCard Secure Code");
        cardsTestData.add("Белкарт");

        List<String> actualCardsLogos = new ArrayList<>();

        List<WebElement> iconElementsList = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li"));

        for(WebElement iconElement : iconElementsList) {
            actualCardsLogos.add(iconElement.findElement(By.tagName("img")).getAttribute("alt"));
        }

        Assertions.assertEquals(cardsTestData, actualCardsLogos);
    }

    @DisplayName("Тестирование ссылки 'Подробнее о сервисе'")
    @Test
    void serviceLinkTest() {
        WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        link.click();
        System.out.println(driver.getCurrentUrl());
        Assertions.assertEquals(expectedLink, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @DisplayName("Тестирование кнопки 'Продолжить'")
    @Test
    void continueButtonTest() {
        WebElement phoneInput = driver.findElement(By.className("phone"));
        phoneInput.click();
        phoneInput.sendKeys("297777777");

        WebElement amountInput = driver.findElement(By.className("total_rub"));
        amountInput.click();
        amountInput.sendKeys("100");

        WebElement continueButton = driver.findElement((By.xpath("//button[contains(text(), 'Продолжить')]")));
        continueButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-app")));
        WebElement popUp = driver.findElement(By.className("bepaid-app"));
        Assertions.assertTrue(popUp.isDisplayed());
    }

    @AfterAll
    public static void afterTests() {
        driver.close();
    }
}
