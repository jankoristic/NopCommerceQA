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
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(hp.logout.isDisplayed(), true);
	  
	}
}
