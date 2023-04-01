package testCases;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ReadXLSdata;

public class LoginTest extends BaseClass {
  
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void login(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		log.info("Clicked on Log in");
		
		lp.enterEmail(email);
		log.info("Entered email");
		
		lp.enterPassword(password);
		log.info("Entered password");
		
		lp.clickLogin();
		log.info("Clicked Login");
	  
	  
		try {
			softassert.assertEquals(hp.logout.isDisplayed(), true);
			log.info("Test passed");
			test.pass("Login test passed");
		} catch (Exception e){
			test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshot.captureScreenshot(driver, "screenshot.png")).build());
		}
	  
	}
}
