package test;

import framework.browser.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.RegisterFormPage;

public class CreateUserTest {

    private final String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";

    @BeforeMethod
    public void beforeMethod() {
        Browser.getBrowser().navigate(url);
    }

    @AfterMethod
    public void afterMethod() {
        Browser.getBrowser().getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void quit() {
        Browser.getBrowser().getDriver().quit();
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

    }

    @Test
    public void address2DisapearedAfterWritingIncorrectInfoTest() {
        AuthenticationPage authenticationPage = new AuthenticationPage();
        String email = System.currentTimeMillis() + "test1234@mail.com";
        authenticationPage.createAccount(email);

        RegisterFormPage registerFormPage = new RegisterFormPage();

    }

}
