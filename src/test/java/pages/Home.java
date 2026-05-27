package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.DriverFactory;

public class Home {
	
	By tabhome=By.xpath("//a[text()='Home']");
	By tabcatalog=By.xpath("//a[text()='Catalog']");
	By search=By.xpath("//header//a[text()='Search']");
	By weproducts=By.xpath("//h1[text()='Products']");
		
	public void clickhome() {
		CommonUtils.clickElement(tabhome, "Home");		
	}
	
	public void clickcatalog() {
		CommonUtils.clickElement(tabcatalog, "Catalog");		
	}
	
	public void searchitem(String itemname) {
		CommonUtils.enterData(search, itemname);
	}

}
