import org.example.OnlineReplenishmentPage;
import org.example.PaymentPage;
import org.example.PaymentsLogosData;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OnlineReplenishmentPageTest {
    private static WebDriver driver;

    @BeforeAll
    public static void beforeTests() {
        driver = new ChromeDriver();

        driver.get("https://www.mts.by/");

        WebElement denieButton = driver.findElement(By.xpath("//button[contains(text(), 'Отклонить')]"));
        denieButton.click();
    }

    @DisplayName("Тест названия блока")
    @Test
    @Order(1)
    void blockNameTest() {
        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии",  onlineReplenishmentPage.getBlockName());
    }

    @DisplayName("Тестирование логотипов платежных систем")
    @Test
    @Order(2)
    void logoTest() {
        List<String> cardsTestData = new ArrayList<>();
        cardsTestData.add("Visa");
        cardsTestData.add("Verified By Visa");
        cardsTestData.add("MasterCard");
        cardsTestData.add("MasterCard Secure Code");
        cardsTestData.add("Белкарт");

        List<String> actualCardsLogos = new ArrayList<>();

        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);
        List<WebElement> iconElementsList = onlineReplenishmentPage.getLogosList();

        for(WebElement iconElement : iconElementsList) {
            actualCardsLogos.add(iconElement.findElement(By.tagName("img")).getAttribute("alt"));
        }

        Assertions.assertEquals(cardsTestData, actualCardsLogos);
    }

    @DisplayName("Тестирование ссылки 'Подробнее о сервисе'")
    @Test
    @Order(3)
    void serviceLinkTest() {
        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);
        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        onlineReplenishmentPage.getServiceLink().click();
        System.out.println(driver.getCurrentUrl());
        Assertions.assertEquals(expectedLink, driver.getCurrentUrl());
        driver.navigate().back();
    }

    @DisplayName("Тестирование кнопки 'Продолжить'")
    @Test
    @Order(4)
    void continueButtonTest() {
        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);

        onlineReplenishmentPage.submitForm("297777777", "100");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-app")));
        Assertions.assertTrue(onlineReplenishmentPage.getPopUp().isDisplayed());
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cc-number")));
        driver.findElement(By.id("cc-number")).sendKeys(Keys.ESCAPE);
        driver.switchTo().defaultContent();
    }


    @DisplayName("Проверка плейсхолдеров в форме 'Онлайн пополнение без комиссии'")
    @Test
    @Order(5)
    void PlaceholdersTest() {
        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);

        Assertions.assertTrue(onlineReplenishmentPage.communicationServicesPlaceholdersCheck());

        onlineReplenishmentPage.changeReplanishmentMethod("Домашний интернет");

        Assertions.assertTrue(onlineReplenishmentPage.homeInternetPlaceholdersCheck());

        onlineReplenishmentPage.changeReplanishmentMethod("Рассрочка");

        Assertions.assertTrue(onlineReplenishmentPage.installmentPlanPlaceholdersCheck());

        onlineReplenishmentPage.changeReplanishmentMethod("Задолженность");

        Assertions.assertTrue(onlineReplenishmentPage.DeptPlaceholdersCheck());
    }

    @DisplayName("Тестирование отображения суммы")
    @Test
    @Order(6)
    void priceCheckTest() {
        OnlineReplenishmentPage onlineReplenishmentPage = new OnlineReplenishmentPage(driver);
        onlineReplenishmentPage.changeReplanishmentMethod("Услуги связи");
        String amount = "100.5";
        String phone = "297777777";

        onlineReplenishmentPage.submitForm(phone, amount);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-app")));
        Assertions.assertTrue(onlineReplenishmentPage.getPopUp().isDisplayed());
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cc-number")));
        PaymentPage paymentPage = new PaymentPage(driver);
        Assertions.assertTrue(paymentPage.checkCorrectPrice(amount));
        Assertions.assertTrue(paymentPage.checkCorrectPriceOnButton(amount));
        Assertions.assertTrue(paymentPage.checkCorrectPriceInAgreement(amount));

    }

    @DisplayName("Тестирование отображения номера телефона")
    @Test
    @Order(7)
    void phoneNumberCheckTest() {
        PaymentPage paymentPage = new PaymentPage(driver);
        String number = "375297777777";

        Assertions.assertTrue(paymentPage.checkCorrectNumber(number));
    }

    @DisplayName("Тестирование плейсхолдеров в форме оплаты")
    @Test
    @Order(8)
    void paymentPlaceholdersCheckTest() {
        PaymentPage paymentPage = new PaymentPage(driver);

        Assertions.assertTrue(paymentPage.paymentPlaceholdersCheck());
    }

    @DisplayName("Тестирование логотипов платежных систем в форме оплаты")
    @Test
    @Order(9)
    void paymentsLogosTest() {
        PaymentsLogosData paymentsLogosData = new PaymentsLogosData();
        PaymentPage paymentPage = new PaymentPage(driver);

        HashMap<String, String> actualLogos = new HashMap<>();
        actualLogos.put("visa", paymentPage.getVisaLogo().getAttribute("src"));
        actualLogos.put("mastercard", paymentPage.getMastercardLogo().getAttribute("src"));
        actualLogos.put("belkart", paymentPage.getBelkartLogo().getAttribute("src"));
        actualLogos.put("maestro", paymentPage.getMaestroLogo().getAttribute("src"));
        actualLogos.put("mir", paymentPage.getMirLogo().getAttribute("src"));

        paymentPage.iconsComparsion(actualLogos, paymentsLogosData);

    }
}

