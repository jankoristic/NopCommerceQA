package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	public WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gender-male")
	public WebElement male;
	
	@FindBy(id="gender-female")
	public WebElement female;

	@FindBy(id="FirstName")
	public WebElement firstName;
	
	@FindBy(id="LastName")
	public WebElement lastName;
	
	@FindBy(name="DateOfBirthDay")
	public WebElement dateOfBirthDay;
	
	@FindBy(name="DateOfBirthMonth")
	public WebElement dateOfBirthMonth;
	
	@FindBy(name="DateOfBirthYear")
	public WebElement dateOfBirthYear;
	
	@FindBy(id="Email")
	public WebElement email;

	@FindBy(id="Company")
	public WebElement company;
	
	@FindBy(id="Newsletter")
	public WebElement newsletter;
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(id="ConfirmPassword")
	public WebElement confirmPassword;
	
	@FindBy(id="register-button")
	public WebElement registerButton;
	
	@FindBy(css="div[class=result]")
	public WebElement confirmResult;
	
	public void clickMale() {
		male.click();
	}
	
	public void clickFemale() {
		female.click();
	}
	
	public void enterFirstName(String keys) {
		firstName.clear();
		firstName.sendKeys(keys);
	}
	
	public void enterLastName(String keys) {
		lastName.clear();
		lastName.sendKeys(keys);
	}

	public void selectDay() {
		Select sel = new Select(dateOfBirthDay);
		sel.selectByVisibleText("13");
	}
	
	public void selectMonth() {
		Select sel = new Select(dateOfBirthMonth);
		sel.selectByVisibleText("April");
	}
	
	public void selectYear() {
		Select sel = new Select(dateOfBirthYear);
		sel.selectByVisibleText("1988");
	}
	
	public void enterEmail(String keys) {
		email.clear();
		email.sendKeys(keys);
	}
	
	public void enterPassword(String keys) {
		password.clear();
		password.sendKeys(keys);
	}
	
	public void enterConfirmPassword(String keys) {
		confirmPassword.clear();
		confirmPassword.sendKeys(keys);
	}
	
	public void clickRegister() {
		registerButton.click();
	}
	
}
