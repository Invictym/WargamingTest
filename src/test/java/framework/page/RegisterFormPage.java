package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class RegisterFormPage extends BasePage {

    @FindBy(id = "account-creation_form")
    private WebElement page;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "address1")
    private WebElement addr;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;

    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "id_country")
    private WebElement country;

    @FindBy(id = "phone_mobile")
    private WebElement mobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccount;

    @FindBy(xpath = "//div[contains(@class, \"alert-danger\")]")
    private WebElement alertMessage;

    @FindBy(id = "address2")
    private WebElement address2;

    public RegisterFormPage() {
        Assert.assertTrue(page.isDisplayed(), "Page not opened");
    }

    public void createAccount(String customerFirstName, String customerLastName, String email, String password, String firstName, String lastName,
                              String addr, String city, String state, String postCode, String country, String mobile, String alias) {
        this.customerFirstName.sendKeys(customerFirstName);
        this.customerLastName.sendKeys(customerLastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.addr.sendKeys(addr);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.postCode.sendKeys(postCode);
        this.country.sendKeys(country);
        this.mobile.sendKeys(mobile);
        this.alias.sendKeys(alias);

        submitAccount.click();
    }

    public boolean isAlertDisplayed() {
        try {
            return alertMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public boolean isAddress2Displayed() {
        return address2.isDisplayed();
    }
}
