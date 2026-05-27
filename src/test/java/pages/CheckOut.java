package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.CommonUtils;
import utils.DriverFactory;

public class CheckOut {
	By lnkcheckout=By.xpath("//a[text()='Check Out']");
	By btncheckout=By.xpath("//input[@id='checkout']");
	By btnpaynow=By.xpath("//*[@id='checkout-pay-button']");
	
	public void clickcheckout() {
		System.out.println("Executing clickcheckout method...");
		CommonUtils.clickElement(lnkcheckout, "Check Out");
	}
	
	public void clickcheckoutbutton() {
		CommonUtils.clickElement(btncheckout, "Check Out button");
	}
	
	public void clickpaynow() {
		CommonUtils.clickElement(btnpaynow, "Pay Now");
	}
	
	public void validateproductdetails() {
		// Validate product name
		String productName = DriverFactory.driver.findElement(By.linkText("Grey jacket - Grey jacket")).getText();
		Assert.assertEquals(productName, "Grey jacket - Grey jacket");

		// Validate price
		//String price = DriverFactory.driver.findElement(By.xpath("//*[@id='cart']/form/div[1]/div[3]/div[2]")).getText();
		//Assert.assertEquals(price, "£55.00");

		// Validate quantity
		//String quantity = DriverFactory.driver.findElement(By.xpath("//*[@id='cart']/form/div[1]/div[3]/div[3]")).getAttribute("value");
		//Assert.assertEquals(quantity, "1");

		// Validate total
		//String total = DriverFactory.driver.findElement(By.xpath("//*[contains(text(),'£55.00')]")).getText();
		//Assert.assertEquals(total, "Total £55.00");
	}
	
	public void enterPersonalDetails(String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String pinCode) {

		DriverFactory.driver.findElement(By.name("firstName")).sendKeys(firstName);
		DriverFactory.driver.findElement(By.name("lastName")).sendKeys(lastName);
		DriverFactory.driver.findElement(By.id("shipping-address1")).sendKeys(address);
		DriverFactory.driver.findElement(By.name("city")).sendKeys(city);
		
		DriverFactory.driver.findElement(By.name("zone")).sendKeys(state);
		DriverFactory.driver.findElement(By.name("postalCode")).sendKeys(pinCode);
		System.out.println("Entered personal details successfully...");
		}

	public void enterCardDetails(String cardNumber,
            String expiry,
            String cvv,
            String nameOnCard) {

		DriverFactory.driver.findElement(By.id("number")).sendKeys(cardNumber);
		DriverFactory.driver.findElement(By.id("expiry")).sendKeys(expiry);
		DriverFactory.driver.findElement(By.id("verification_value")).sendKeys(cvv);
		DriverFactory.driver.findElement(By.id("name")).sendKeys(nameOnCard);
		System.out.println("Entered card details successfully...");
		}
}
