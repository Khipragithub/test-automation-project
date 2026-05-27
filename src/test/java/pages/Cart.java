package pages;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.CommonUtils;
import utils.DriverFactory;

public class Cart{
	By btnaddtocart=By.xpath("//input[@value='Add to Cart']");
	By numcartCount=By.xpath("//span[@id='cart-target-desktop']");
	By lnkgreyjacket=By.xpath("//h3[text()='Grey jacket']");
	
	public void clickProduct(String itemdesc) {
		CommonUtils.clickElement(lnkgreyjacket, itemdesc);	
	}
	
	public void addtocart() {
		CommonUtils.clickElement(btnaddtocart, "Add to Cart");	
	}
	
	public void verfycartitemcount() {
		WebElement element = DriverFactory.driver.findElement(numcartCount);
		String text = element.getText();
		int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));
		if (count>=1) {
		    System.out.println("Cart count displayed as "+count);
		} else {
		    System.out.println("Cart count not displayed after adding item to cart");
		
		}
	}
		
}
