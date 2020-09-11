package pages;

import framework.BaseForm;
import framework.ui.Button;
import framework.ui.Input;
import org.openqa.selenium.By;

public class AuthenticationPage extends BaseForm {

    Input emailEdText = new Input(By.id("email_create"), "Create email button");

    Button submitBtn = new Button(By.id("SubmitCreate"), "Submit button");

    public AuthenticationPage() {
        super(By.id("create-account_form"), "Auth page");
    }

    public void createAccount(String email) {
        emailEdText.sendKey(email);
        submitBtn.click();
    }
}

