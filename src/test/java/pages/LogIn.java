package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.CommonUtils;
import utils.DriverFactory;

public class LogIn {
	
	// Existing user Login
	By bnrsimple=By.xpath("//*[@id='logo']");
	By lnklogin=By.xpath("//a[text()='Log In']");
	By lnklogout=By.xpath("//a[text()='Log Out']");
	By lblcustomerlogin=By.xpath("//*[text()='Customer Login']");
	By edituseremailaddress=By.xpath("//input[@id='customer_email']");
	By edituserpassord=By.xpath("//input[@id='customer_password']");
	By btnsigin=By.xpath("//input[@value='Sign In']");
	By weloginerror = By.xpath("//*[text()='Incorrect email or password']");

	//LOGIN 
		public void loginPageToVerify() {
			CommonUtils.verifyPage(bnrsimple);
		}
		
		public boolean logoutlinkexist() {
			if (DriverFactory.driver.findElement(lnklogout).isDisplayed() == true) {
				return true;						
			}
			return false;
		}
		
		public void clickLoginLink() {
		    CommonUtils.clickElement(lnklogin, "Login link");
		}

		public void enterLoginUser(String user) {
			CommonUtils.enterData(edituseremailaddress, user);
		}

		public void enterLoginPassword(String password) {
			CommonUtils.enterData(edituserpassord, password);
		}
		
		public void clickSignInButton() throws InterruptedException {
			Thread.sleep(10000);
			CommonUtils.clickElement(btnsigin,"Sign In button");
			CommonUtils.verifyPage(weloginerror);
		}
}
