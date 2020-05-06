package framework.page.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver driver;
    private static FirefoxProfile profile;
    private static FirefoxOptions options = new FirefoxOptions();
    private static ChromeOptions optionsChrome = new ChromeOptions();
    private static Map<String, Object> prefs = new HashMap<String, Object>();

    private BrowserFactory() {
    }

    public enum Browser {
        CHROME, FIREFOX
    }

    protected static WebDriver init(Browser browser) {
        String os = System.getProperty("os.name").toLowerCase();

        if (browser.equals(Browser.CHROME)) {
            if (os.indexOf("win") >= 0) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            }
            getChromeProfile();
            driver = new ChromeDriver(optionsChrome);
            driver.manage().window().maximize();
        } else {
            if (os.indexOf("win") >= 0) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            } else {
                System.setProperty("webdriver.gecko.driver", "geckodriver");
            }
            getFirefoxProfile();
            driver = new FirefoxDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    private static void getFirefoxProfile() {
        profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream;application/x-debian-package;application/x-msdownload");
        profile.setPreference("browser.download.dir", System.getProperty("user.dir"));
        options.setProfile(profile);
    }

    private static void getChromeProfile() {
        prefs.put("safebrowsing.enabled", "true");
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        optionsChrome.setExperimentalOption("prefs", prefs);
    }
}
