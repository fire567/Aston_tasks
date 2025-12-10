package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class OnlineReplenishmentPage extends BasePage {

    private WebDriver driver;

    public OnlineReplenishmentPage(WebDriver driver) {
        this.driver = driver;
    }

    private By blockNameLocator = By.xpath("//h2[contains(text(), 'Онлайн пополнение')]");
    private By banksLogosLocator = By.xpath("//div[@class='pay__partners']/ul/li");
    private By serviceLinkLocator = By.linkText("Подробнее о сервисе");
    private By phoneInputLocator = By.className("phone");
    private By amountInputLocator = By.className("total_rub");
    private By continueButtonLocator = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By popUpLocator = By.className("bepaid-app");
    private By scoreInputLocator = By.className("score");

    public String getBlockName() {
        WebElement blockName = driver.findElement(blockNameLocator);
        return blockName.getText();
    };

    public List<WebElement> getLogosList() {
        List<WebElement> banksLogos = driver.findElements(banksLogosLocator);
        return banksLogos;
    };

    public WebElement getServiceLink() {
        WebElement serviceLink = driver.findElement(serviceLinkLocator);
        return serviceLink;
    }

    public WebElement getPhoneInput() {
        WebElement phoneInput = driver.findElement(phoneInputLocator);
        return phoneInput;
    }

    public WebElement getAmountInput() {
        WebElement amountInput = driver.findElement(amountInputLocator);
        return amountInput;
    }

    public WebElement getContinueButton() {
        WebElement continueButton = driver.findElement(continueButtonLocator);
        return continueButton;
    };

    public WebElement getPopUp() {
        WebElement popUp = driver.findElement(popUpLocator);
        return popUp;
    };

    public WebElement getAccountScoreInput() {
        WebElement scoreInput = driver.findElement(scoreInputLocator);
        return scoreInput;
    }

    public WebElement getDebtScoreInput() {
        WebElement scoreInput = driver.findElement(By.id("score-arrears"));
        return scoreInput;
    }

    public WebElement getEmailInput() {
        WebElement email = driver.findElement(By.className("email"));
        return email;
    }

    public void typePhone(String number) {
        getPhoneInput().click();
        getPhoneInput().sendKeys(number);
    }

    public void typeAmount(String number) {
        getAmountInput().click();
        getAmountInput().sendKeys(number);
    }

    public void submitForm(String phone, String amount) {
        typePhone(phone);
        typeAmount(amount);
        getContinueButton().click();
    }

    public String getAmountPlaceholder() {
        return getAmountInput().getAttribute("placeholder");
    };

    public String getEmailPlaceholder() {
        return getEmailInput().getAttribute("placeholder");
    };

    public String getPhonePlaceholder() {
        return getPhoneInput().getAttribute("placeholder");
    };

    public String getSubscriberNumberPlaceholder() {
        return driver.findElement(By.id("internet-phone")).getAttribute("placeholder");
    }

    public String getAccountScorePlaceholder() {
        return getAccountScoreInput().getAttribute("placeholder");
    };

    public String getDebtScorePlaceholder() {
        return getDebtScoreInput().getAttribute("placeholder");
    };

    public void changeReplanishmentMethod(String methodName) {
        WebElement dropdown = driver.findElement(By.className("select__header"));
        dropdown.click();
        WebElement homeInternetButton = driver.findElement(By.xpath("//p[contains(text(), '" + methodName + "')]"));
        homeInternetButton.click();
    }

    public boolean communicationServicesPlaceholdersCheck() {
        PlaceholdersData expectedPlaceholders = new PlaceholdersData();

        HashMap<String, String> actualPlaceholders = new HashMap<>();
        actualPlaceholders.put("amount", getAmountPlaceholder());
        actualPlaceholders.put("email", getEmailPlaceholder());
        actualPlaceholders.put("phoneNumber", getPhonePlaceholder());

        return placeholdersComparsion(expectedPlaceholders, actualPlaceholders);
    };

    public boolean homeInternetPlaceholdersCheck() {
        PlaceholdersData expectedPlaceholders = new PlaceholdersData();

        HashMap<String, String> actualPlaceholders = new HashMap<>();
        actualPlaceholders.put("amount", getAmountPlaceholder());
        actualPlaceholders.put("email", getEmailPlaceholder());
        actualPlaceholders.put("subscriberNumber", getSubscriberNumberPlaceholder());

        return placeholdersComparsion(expectedPlaceholders, actualPlaceholders);
    };

    public boolean installmentPlanPlaceholdersCheck() {
        PlaceholdersData expectedPlaceholders = new PlaceholdersData();

        HashMap<String, String> actualPlaceholders = new HashMap<>();
        actualPlaceholders.put("amount", getAmountPlaceholder());
        actualPlaceholders.put("email", getEmailPlaceholder());
        actualPlaceholders.put("accountScore", getAccountScorePlaceholder());

        return placeholdersComparsion(expectedPlaceholders, actualPlaceholders);
    };

    public boolean DeptPlaceholdersCheck() {
        PlaceholdersData expectedPlaceholders = new PlaceholdersData();

        HashMap<String, String> actualPlaceholders = new HashMap<>();
        actualPlaceholders.put("amount", getAmountPlaceholder());
        actualPlaceholders.put("email", getEmailPlaceholder());
        actualPlaceholders.put("debtScore", getDebtScorePlaceholder());

        return placeholdersComparsion(expectedPlaceholders, actualPlaceholders);
    };
}
