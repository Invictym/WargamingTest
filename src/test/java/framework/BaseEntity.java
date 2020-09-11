package framework;

import framework.browser.Browser;
import framework.config.AutomationAppContext;
import framework.entity.BrowserValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntity {

  BrowserValues values = AutomationAppContext.getBrowserValues();

  @BeforeSuite
  public void init() {

  }

  public Browser getBrowser() {
    return Browser.getBrowser();
  }

  @AfterSuite
  public void exit() {
    getBrowser().getDriver().quit();
  }

  public void openNewWindow() {
    new WebDriverWait(getBrowser().getDriver(), values.getTimeout())
        .until(new ExpectedCondition<Boolean>() {
          @Override
          public Boolean apply(WebDriver driver) {
            return new ArrayList<String>(driver.getWindowHandles()).size() > 1;
          }
        });
    List<String> tabs2 = new ArrayList<String>(getBrowser().getDriver().getWindowHandles());
    getBrowser().getDriver().switchTo().window(tabs2.get(1));
  }
}
