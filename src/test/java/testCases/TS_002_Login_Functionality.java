package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ReadXLSdata;

public class TS_002_Login_Functionality extends BaseClass {
  
	@Test
	public void TC_LF_001() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(read.getEmail());
		lp.enterPassword(read.getPassword());
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
	
	@Test
	public void TC_LF_004() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.clickLogin();
		
		softassert.assertEquals(lp.emailError.isDisplayed(), true);
	  
	}
	
	@Test
	public void TC_LF_005() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.clickForgotPassword();
		
		softassert.assertEquals(lp.recoveryPage.isDisplayed(), true);
	  
	}
	
	@Test
	public void TC_LF_006() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(read.getEmail());
		lp.enterPassword(read.getPassword());
		lp.clickLogin();
		driver.navigate().back();
		
		softassert.assertEquals(lp.notification.isDisplayed(), true);
	  
	}
	
	@Test
	public void TC_LF_007() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		
		hp.clickLogin();
		lp.enterEmail(read.getEmail());
		lp.enterPassword(read.getPassword());
		lp.clickLogin();
		hp.clickLogout();
		driver.navigate().back();
		
		softassert.assertEquals(hp.login.isDisplayed(), true);
	  
	}
}
