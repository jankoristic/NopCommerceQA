package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseClass {
  
	@Test
	public void login() {
	  driver.get(read.getURL());
	  HomePage hp = new HomePage(driver);
	  LoginPage lp = new LoginPage(driver);
	  hp.clickLogin();
	  log.info("Clicked on Log in");
	  lp.enterEmail("random@gmail.com");
	  log.info("Entered email");
	  lp.enterPassword("random123");
	  log.info("Entered password");
	  lp.clickLogin();
	  log.info("Clicked Login");
	  
	  if(driver.getTitle().equals("nopCommerce demo store")) {
		  Assert.assertTrue(true);
		  log.info("Test passed");
	  } else {
		  Assert.assertFalse(false);
		  log.error("Test failed");
	  }
	  
  }
}
