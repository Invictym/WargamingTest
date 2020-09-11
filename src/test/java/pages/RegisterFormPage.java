package pages;

import framework.BaseForm;
import framework.ui.Input;
import framework.ui.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterFormPage extends BaseForm {

    public RegisterFormPage() {
        super(By.id("account-creation_form"), "");
    }

    private Input customerFirstName = new Input(By.id("customer_firstname"), "Customer input");

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
