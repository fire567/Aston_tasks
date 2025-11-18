package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class PaymentPage extends BasePage {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By priceLocator = By.xpath("//span[@class = 'ng-star-inserted']");
    private By priceOnButtonLocator = By.xpath("//button[@type = 'submit']/span[contains(text(), 'Оплатить')]");
    private By priceInAgreement = By.xpath("//span[contains(text(), 'Нажимая на кнопку')]");
    private By phoneNumberLocator = By.xpath("//span[contains(text(), 'Оплата: Услуги связи')]");
    private By cardNumberLocator = By.xpath("//input[@formcontrolname='creditCard']/following::label[1]");
    private By validityPeriodLocator = By.xpath("//input[@formcontrolname='expirationDate']/following::label[1]");
    private By cvcLocator = By.xpath("//input[@formcontrolname='cvc']/following::label[1]");
    private By firstAndSecondNamesLocator = By.xpath("//input[@formcontrolname='holder']/following::label[1]");
    private By visaLogoLocator = By.xpath("//img[contains(@src, 'visa-system')]");
    private By mastercardLogoLocator = By.xpath("//img[contains(@src, 'mastercard-system')]");
    private By belkartLogoLocator = By.xpath("//img[contains(@src, 'belkart-system')]");
    private By maestroLogoLocator = By.xpath("//img[contains(@src, 'maestro-system')]");
    private By mirLogoLocator = By.xpath("//img[contains(@src, 'mir-system-ru')]");

    public WebElement getPrice() {
        return driver.findElement(priceLocator);
    }

    public WebElement getPriceOnButton() {
        return driver.findElement(priceOnButtonLocator);
    }

    public WebElement getPhoneNumber() {
        return driver.findElement(phoneNumberLocator);
    }

    public WebElement getAgreement() {
        return driver.findElement(priceInAgreement);
    }

    public WebElement getCardNumber() {
        return driver.findElement(cardNumberLocator);
    }

    public WebElement getValidityPeriod() {
        return driver.findElement(validityPeriodLocator);
    }

    public WebElement getCvc() {
        return driver.findElement(cvcLocator);
    }

    public WebElement getFirstAndSecondNames() {
        return driver.findElement(firstAndSecondNamesLocator);
    }

    public WebElement getVisaLogo() {
        return driver.findElement(visaLogoLocator);
    }

    public WebElement getMastercardLogo() {
        return driver.findElement(mastercardLogoLocator);
    }

    public WebElement getBelkartLogo() {
        return driver.findElement(belkartLogoLocator);
    }

    public WebElement getMaestroLogo() {
        return driver.findElement(maestroLogoLocator);
    }

    public WebElement getMirLogo() {
        return driver.findElement(mirLogoLocator);
    }

    private String findNumbers(WebElement string) {
        return string.getText().replaceAll("\\D+", "");
    };

    private String convertPrice(String expectedPrice) {
        String newExpectedPrice = expectedPrice.replaceAll("\\D+", "");
        if(expectedPrice.contains(".")) {
            if(expectedPrice.split("\\.").length == 2){
                if(expectedPrice.split("\\.")[1].length() == 1){
                    newExpectedPrice += "0";
                }
            }
        } else {
            newExpectedPrice += "00";
        }

        return newExpectedPrice;
    }

    public boolean checkCorrectPrice(String expectedPrice) {
        if (findNumbers(getPrice()).equals(convertPrice(expectedPrice))) return true;
        return false;
    };

    public boolean checkCorrectPriceOnButton(String expectedPrice) {
        if (findNumbers(getPriceOnButton()).equals(convertPrice(expectedPrice))) return true;
        return false;
    };

    public boolean checkCorrectPriceInAgreement(String expectedPrice) {
        if (findNumbers(getAgreement()).equals(convertPrice(expectedPrice))) return true;
        return false;
    };

    public boolean checkCorrectNumber(String expectedNumber) {
        if(expectedNumber.equals(findNumbers(getPhoneNumber()))) return true;
        return false;
    }

    public boolean paymentPlaceholdersCheck() {
        PaymentsPlaceholdersData expectedPlaceholders = new PaymentsPlaceholdersData();

        HashMap<String, String> actualPlaceholders = new HashMap<>();
        actualPlaceholders.put("cardNumber", getCardNumber().getText());
        actualPlaceholders.put("validityPeriod", getValidityPeriod().getText());
        actualPlaceholders.put("cvc", getCvc().getText());
        actualPlaceholders.put("firstAndSecondNames", getFirstAndSecondNames().getText());

        return placeholdersComparsion(expectedPlaceholders, actualPlaceholders);
    };

    public boolean iconsComparsion(HashMap<String, String> actualLogos, PaymentsLogosData expectedLogos) {
        for (String logo : actualLogos.keySet()) {
            String expectedLogo = expectedLogos.getLogosData().get(logo);
            String actualLogo = actualLogos.get(logo);
            if(!actualLogo.contains(expectedLogo)) {
                return false;
            }
        }
        return true;
    }

    public void waitUntilFormIsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-app")));
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cc-number")));
    }

}
