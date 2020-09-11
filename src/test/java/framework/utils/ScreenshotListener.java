package framework.utils;

import framework.browser.Browser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if (!result.isSuccess() && Browser.isInit()) {

            WebDriver driver = Browser.getBrowser().getDriver();
            TakesScreenshot scrShot = ((TakesScreenshot) driver);
            try {
                File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                String fileName =  "failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png";
                File destFile = new File(reportDirectory + "/" + fileName);
                //FileUtils.copyFile(srcFile, destFile);
                Reporter.log("<img src=\"" + fileName + "\" height='600' width='1200'/>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
