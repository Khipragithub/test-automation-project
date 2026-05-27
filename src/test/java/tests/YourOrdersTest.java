package tests;

import org.testng.annotations.Test;

import baseclass.BaseClass;
import pages.Home;
import pages.Orders;
import utils.DriverFactory;

public class YourOrdersTest extends Orders{

	Home hm= new Home();
	
	@Test
	public void yourorders() {
		System.out.println("Executing YourOrders test...");
		DriverFactory.workonopenedchrome();
		DriverFactory.cometohomepage();
		clickmyaccount();
		verifyorders();
	}
	
}
