package framework.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class RemoteDriverFactory {

    private static WebDriver driver;

    public static WebDriver init(String server, int port) {
        ChromeOptions cap = new ChromeOptions();
        try {
            System.out.println("Get browser http://" + server + ":" + port + "/wd/hub");
            driver = new RemoteWebDriver(new URL("http://" + server + ":" + port + "/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
