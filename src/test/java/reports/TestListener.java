package reports;

import baseclass.BaseClass;
import utils.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
	@Override
    public void onStart(ITestContext context) {
        ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTestManager.setTest(
                ExtentManager.getInstance()
                        .createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.FAIL, result.getThrowable());

        try {

        	WebDriver driver = DriverFactory.driver;

            String screenshotPath = ScreenshotUtil.captureScreenshot(
                    driver,
                    result.getMethod().getMethodName());

            ExtentTestManager.getTest()
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentTestManager.getTest()
                .log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getInstance().flush();
    }

}
