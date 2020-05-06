package test;

import framework.page.AuthenticationPage;
import framework.page.RegisterFormPage;
import framework.page.browser.Browser;
import framework.page.browser.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateUserTest {

    private final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    @BeforeMethod
    public void beforeMethod() {
        Browser.getBrowser(BrowserFactory.Browser.CHROME).navigate(url);
    }

    @AfterMethod
    public void afterMethod() {
        Browser.getBrowser(BrowserFactory.Browser.CHROME).getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void quit() {
        Browser.getBrowser(BrowserFactory.Browser.CHROME).getDriver().quit();
    }

    @Test
    public void createUserWithUnicodeTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        String email ="test&#09@mail.com";
        authenticationPage.createAccount(email);

        RegisterFormPage registerFormPage = new RegisterFormPage();
        Assert.assertEquals(registerFormPage.getEmail(), email);
    }

    @Test
    public void createUserWithSpaceNameTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        String email = System.currentTimeMillis() + "test1234@mail.com";
        authenticationPage.createAccount(email);

        RegisterFormPage registerFormPage = new RegisterFormPage();
        registerFormPage.createAccount("  ",
                "  ", "", "     ", "as", "as", "v", "v",
                "Alabama", "00000", "United States", "+375261856", "v");
        Assert.assertTrue(registerFormPage.isAlertDisplayed());
    }

    @Test
    public void address2DisapearedAfterWritingIncorrectInfoTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        String email = System.currentTimeMillis() + "test1234@mail.com";
        authenticationPage.createAccount(email);

        RegisterFormPage registerFormPage = new RegisterFormPage();
        registerFormPage.createAccount("",
                "t", "", "     ", "", "as", "v", "v",
                "Alabama", "00000", "United States", "+375261856", "v");
        Assert.assertTrue(registerFormPage.isAlertDisplayed());
        Assert.assertTrue(registerFormPage.isAddress2Displayed());
    }

}
