package baseclass;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

import reports.ExtentManager;
import reports.ExtentTestManager;
import java.lang.reflect.Method;

public class APIBaseClass {

    @BeforeMethod
    public void apiSetup(Method method) {

        System.out.println("API Test Started");

        // Optional future API setup
        // RequestSpecification setup
        // Common headers
        // Auth tokens
        
        // Create Extent Test
        //ExtentTest test = ExtentManager.getInstance().createTest(method.getName());

        //ExtentTestManager.setTest(test);
    }
}