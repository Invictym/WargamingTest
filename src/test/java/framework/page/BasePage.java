package framework.page;

import framework.page.browser.Browser;
import framework.page.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = Browser.getBrowser(BrowserFactory.Browser.CHROME).getDriver();
        PageFactory.initElements(driver, this);
    }
}
