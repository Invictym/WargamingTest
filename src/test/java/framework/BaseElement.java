package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public abstract class BaseElement extends BaseEntity {

  protected By locator;
  private String name;

  protected BaseElement(final By loc, final String nameOf) {
    locator = loc;
    name = nameOf;
  }

  private void waitForElementPresent(int timeout) {
    getBrowser().getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    new WebDriverWait(getBrowser().getDriver(), timeout)
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    getBrowser().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  private void waitForElementPresent() {
    waitForElementPresent((int) values.getTimeout());
  }

  public void click() {
    waitForElementPresent();
    moveToElement();
    waitElementClickable();
    findElement().click();
  }

  public String getText() {
    int attempts = 0;
    boolean result = false;
    String text = null;
    while (attempts < 2) {
      try {
        moveToElement();
        text = findElement().getText();
        result = true;
        break;
      } catch (StaleElementReferenceException e) {

      }
      attempts++;
    }
    Assert.assertTrue(result);
    return text;
  }
  public By getLocator() {
    return locator;
  }

  public void waitElementClickable() {
    new WebDriverWait(getBrowser().getDriver(), values.getTimeout())
            .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void moveToElement() {
    JavascriptExecutor executor = (JavascriptExecutor) getBrowser().getDriver();
    executor.executeScript("arguments[0].scrollIntoView(true);", findElement());
  }

  private WebElement findElement() {
    return getBrowser().getDriver().findElement(locator);
  }

  public boolean elementIsDisplayed() {
    return findElement().isDisplayed();
  }

  public void waitWithoutException() {

    try {
      waitForElementPresent(3);
    } catch (Exception ex) {
    }
  }

  public void sendKey(String key) {
    waitForElementPresent();
    waitElementClickable();
    moveToElement();
    for (int i = 0; i < 10; i++) {
      try {
        findElement().sendKeys(key);
        break;
      } catch (ElementNotInteractableException ex) {
      }
    }
  }

  public void sendKeyJs(String key) {
    waitForElementPresent();
    waitElementClickable();
    moveToElement();
    JavascriptExecutor executor = (JavascriptExecutor) getBrowser().getDriver();
    executor.executeScript("arguments[0].value='" + key + "';", findElement());
  }

}
