package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseclass.BaseClass;
import utils.DriverFactory;

public class CommonUtils extends DriverFactory {
	
	// verify if any page exists or visible
		public static void verifyPage(By we) {
			if (DriverFactory.driver.findElement(we).isDisplayed() == true)
				System.out.println(DriverFactory.driver.findElement(we).getText() + " is displayed");
		}

		// Click on an element
		public static void clickElement(By we, String toRportLog) {
			DriverFactory.driver.findElement(we).click();
			System.out.println(toRportLog + " clicked successfully ");
		}

		// enter/edit data into on an element
		public static void enterData(By we, String inputData) {
			DriverFactory.driver.findElement(we).clear();
			DriverFactory.driver.findElement(we).sendKeys(inputData);
			System.out.println(inputData + " entered successfully");
			if (DriverFactory.driver.findElement(we).getText() == inputData) {
				System.out.println(inputData + " entered successfully");
			}

		}

}
