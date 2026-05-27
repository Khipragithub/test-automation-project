package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pages.Cart;
import pages.Home;
import utils.DriverFactory;
import baseclass.BaseClass;

public class AddToCartTest extends Cart {
	
	Home hm= new Home();
	
	@Test
	public void addtocartitem() {
		System.out.println("Executing AddToCart test...");
		DriverFactory.workonopenedchrome();
		hm.clickcatalog();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickProduct("Grey jacket");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addtocart();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verfycartitemcount();
	}
	

}
