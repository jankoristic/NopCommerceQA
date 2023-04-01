package testCases;

import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import utilities.ReadXLSdata;

public class RegisterTest extends BaseClass {
  
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void register(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		log.info("Clicked on Register");
		
		rp.clickMale();
		log.info("Clicked on Male");
		
		rp.enterFirstName("John");
		log.info("Enter first name");
		
		rp.enterLastName("Smith");
		log.info("Enter first name");
		
		rp.selectDay();
		log.info("Selected day");
		
		rp.selectMonth();
		log.info("Selected month");
		
		rp.selectYear();
		log.info("Selected year");
		
		rp.enterEmail(email);
		log.info("Entered email");
		
		rp.enterPassword(password);
		log.info("Entered password");
		
		rp.enterConfirmPassword(password);
		log.info("Confirmed password");
		
		rp.clickRegister();
		log.info("Clicked register");
		
		try {
			softassert.assertEquals(rp.confirmResult.isDisplayed(), true);
			log.info("Test passed");
			test.pass("Register test passed");
		} catch (Exception e){
			test.fail(e, MediaEntityBuilder.createScreenCaptureFromPath(screenshot.captureScreenshot(driver, "screenshot.png")).build());
		}

  }
}
