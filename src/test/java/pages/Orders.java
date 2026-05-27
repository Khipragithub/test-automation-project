package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.DriverFactory;

public class Orders {
	By lnkmyaccnt=By.xpath("//header//a[text()='My Account']");
	By weorders=By.xpath("//*[text()='Your Orders']");
	By bnrsaucedemo=By.xpath("//header//*[text()='Sauce Demo']");
	
	public void clickmyaccount() {
		CommonUtils.clickElement(lnkmyaccnt, "My Account");	
	}
	
	public void verifyorders() {
		CommonUtils.verifyPage(weorders);
	}
}
