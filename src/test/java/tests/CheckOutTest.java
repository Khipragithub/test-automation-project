package tests;

import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.CheckOut;
import pages.Home;
import utils.DriverFactory;

public class CheckOutTest extends CheckOut{
	Home hm= new Home();
	
	@Test
	public void checkoutpayment() {
		System.out.println("Executing CheckOut test...");
		DriverFactory.workonopenedchrome();
		clickcheckout();
		validateproductdetails();
		clickcheckoutbutton();
		enterPersonalDetails("aa","bb","cc","dd","Karnataka","560066");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enterCardDetails("11111111","09/30","123","Automation");
	}
	
}
