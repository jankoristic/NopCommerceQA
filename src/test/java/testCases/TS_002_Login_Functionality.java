package testCases;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ReadXLSdata;

public class TS_002_Login_Functionality extends BaseClass {
  
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_LF_001(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(hp.logout.isDisplayed(), true);
	  
	}
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_LF_002(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(lp.messageError.isDisplayed(), true);
	  
	}
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_LF_003(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(lp.messageError.isDisplayed(), true);
	  
	}
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_LF_004(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(lp.messageError.isDisplayed(), true);
	  
	}
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_LF_005(String email, String password) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(email);
		lp.enterPassword(password);
		lp.clickLogin();
		
		softassert.assertEquals(lp.messageError.isDisplayed(), true);
	  
	}
}
