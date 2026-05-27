package tests;

import java.util.List;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Home;
import utils.DriverFactory;

@Test(retryAnalyzer = reports.RetryAnalyzer.class)
public class HomeTest extends Home{
	
	WebDriver driver = DriverFactory.driver;
	
	public void productlisting() {
		System.out.println("Executing Home test...");
		DriverFactory.workonopenedchrome();
		clickcatalog();
		List<WebElement> products = DriverFactory.driver.findElements(By.xpath("//h2"));	
		if (products.size() > 0) {
		    System.out.println("Products are displayed");
		} else {
		    System.out.println("No products found");
		}
		
	}

}
