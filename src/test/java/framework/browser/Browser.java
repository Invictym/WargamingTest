package framework.browser;

import framework.config.AutomationAppContext;
import org.openqa.selenium.WebDriver;

public class Browser {

  private static volatile Browser browser = null;
  private static WebDriver driver;

  private Browser(String host) {
    driver = RemoteDriverFactory.init(host,4444);
  }

  private Browser() {
    driver = BrowserFactory.init();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public static Browser getBrowser() {
    boolean isRemote = AutomationAppContext.getBrowserValues().isRemote();
    Browser localBrowser = browser;
    if (localBrowser == null) {
      synchronized (BrowserFactory.class) {
        localBrowser = browser;
        if (localBrowser == null) {
          browser = isRemote ? new Browser(AutomationAppContext.getBrowserValues().getHost()) : new Browser();
        }
      }
    }
    return browser;
  }

  public static boolean isInit() {
    return driver != null;
  }

  public void navigate(final String url) {
    System.out.println("Navigate to:" + url);
    driver.get(url);
  }

  public void close() {
    driver.close();
    driver = null;
    browser = null;
  }

  public void quite() {
    driver.quit();
    driver = null;
    browser = null;
  }
}
