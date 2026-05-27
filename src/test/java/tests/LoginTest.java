package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogIn;
import reports.ExtentTestManager;
import utils.ConfigReader;
import utils.DriverFactory;

public class LoginTest extends LogIn {

    String username;
    String password;

    @Test(retryAnalyzer = reports.RetryAnalyzer.class)
    public void validlogin() throws IOException, InterruptedException {

        System.out.println("Executing Login test...");

        username = ConfigReader.getConfigValue("username");

        password = ConfigReader.getConfigValue("password");

        DriverFactory.workonopenedchrome();

        // Assert.fail("Intentional failure");

        if (!logoutlinkexist()) {

            loginPageToVerify();

            clickLoginLink();

            ExtentTestManager.getTest()
                    .info("Entering username");

            enterLoginUser(username);

            ExtentTestManager.getTest()
                    .info("Entering password");

            enterLoginPassword(password);

            clickSignInButton();

            ExtentTestManager.getTest()
                    .pass("Login successful");
        }

        else {

            System.out.println(
                    "Application is already logged in...");

            ExtentTestManager.getTest()
                    .info("Application already logged in");
        }
    }
}