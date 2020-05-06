package framework.page.browser;

import org.openqa.selenium.WebDriver;

public class Browser {

  private static volatile Browser browser = null;
  private static WebDriver driver;

  private Browser(BrowserFactory.Browser browser) {
    driver = BrowserFactory.init(browser);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public static Browser getBrowser(BrowserFactory.Browser browserType) {
    Browser localBrawser = browser;
    if (localBrawser == null) {
      synchronized (BrowserFactory.class) {
        localBrawser = browser;
        if (localBrawser == null) {
          browser = new Browser(browserType);
        }
      }
    }
    return browser;
  }

  public void navigate(final String url) {
    driver.get(url);
  }
}
