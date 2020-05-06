package framework.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationPage extends BasePage {

    @FindBy(id = "email_create")
    private WebElement emailEdText;

    @FindBy(id = "SubmitCreate")
    private WebElement submitBtn;

    @FindBy(id = "create-account_form")
    private WebElement page;

    public AuthenticationPage() {
        Assert.assertTrue(page.isDisplayed(), "Page not opened");
    }

    public void createAccount(String email) {
        emailEdText.sendKeys(email);
        submitBtn.click();
    }
}
