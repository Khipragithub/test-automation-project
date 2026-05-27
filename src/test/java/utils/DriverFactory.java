package utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import reports.ExtentTestManager;

public class DriverFactory {

    public static WebDriver driver;

    // Browser setup
    public static WebDriver browsersetup() {

        String browser = ConfigReader.getConfigValue("browser");
        String appurl = ConfigReader.getConfigValue("Applicationurl");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get(appurl);
        ExtentTestManager.getTest().info("Launching application");
        System.out.println("Browser launched successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    // Connect to already opened Chrome
    public static void workonopenedchrome() {
    	//launch chrome using below command from cmd 
    	//start chrome.exe --remote-debugging-port=9222 --user-data-dir="C:\tempProfile"
        System.out.println("Executing workonopenedchrome method...");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(
                "debuggerAddress",
                "localhost:9222");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(20));
    }

    // Browser teardown
    public static void teardown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Tear down successful");
        }
    }

    // Navigate to homepage
    public static void cometohomepage() {

        List<WebElement> saucedemo = driver.findElements(
                By.xpath("//a[@href='https://sauce-demo.myshopify.com']"));
        List<WebElement> simple = driver.findElements(
                By.xpath("//*[@id='logo']"));
        if (saucedemo.size() > 0
                && saucedemo.get(0).isDisplayed()) {
            saucedemo.get(0).click();
        }

        else if (simple.size() > 0
                && simple.get(0).isDisplayed()) {
            simple.get(0).click();
        }
    }
}