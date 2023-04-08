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
	public void TC_RF_001(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.confirmResult.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_002(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.clickMale();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.selectDay();
		rp.selectMonth();
		rp.selectYear();
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(password);
		rp.clickRegister();
		
		softassert.assertEquals(rp.confirmResult.isDisplayed(), true);

  }
	
	@Test
	public void TC_RF_004() {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.clickRegister();
		
		softassert.assertEquals(rp.firstNameError.isDisplayed(), true);
		softassert.assertEquals(rp.lastNameError.isDisplayed(), true);
		softassert.assertEquals(rp.emailError.isDisplayed(), true);
		softassert.assertEquals(rp.passwordError.isDisplayed(), true);
		softassert.assertEquals(rp.confirmPasswordError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_005(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.confirmPasswordError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_006(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.confirmPasswordError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_007(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.messageError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_008(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.emailError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_009(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.firstNameError.isDisplayed(), true);
		softassert.assertEquals(rp.lastNameError.isDisplayed(), true);
		softassert.assertEquals(rp.emailError.isDisplayed(), true);
		softassert.assertEquals(rp.passwordError.isDisplayed(), true);
		softassert.assertEquals(rp.confirmPasswordError.isDisplayed(), true);

  }
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="testdata")
	public void TC_RF_010(String firstName, String lastName, String email, String password, String confirmPassword) {
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		RegisterPage rp = new RegisterPage(driver);
		
		hp.clickRegister();
		rp.enterFirstName(firstName);
		rp.enterLastName(lastName);
		rp.enterEmail(email);
		rp.enterPassword(password);
		rp.enterConfirmPassword(confirmPassword);
		rp.clickRegister();
		
		softassert.assertEquals(rp.passwordError.isDisplayed(), true);

  }
}
