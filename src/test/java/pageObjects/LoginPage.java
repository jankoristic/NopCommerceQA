package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Email")
	public WebElement email;
	
	@FindBy(id="Password")
	public WebElement password;
	
	@FindBy(css=".button-1.login-button")
	public WebElement loginButton;
	
	@FindBy(css="div[class='message-error validation-summary-errors']")
	public WebElement messageError;
	
	@FindBy(id="Email-error")
	public WebElement emailError;
	
	@FindBy(css="a[href='/passwordrecovery']")
	public WebElement forgotPassword;
	
	@FindBy(css="div[class='page password-recovery-page']")
	public WebElement recoveryPage;
	
	@FindBy(css="div[class='bar-notification success']")
	public WebElement notification;
	
	public void enterEmail(String keys) {
		email.clear();
		email.sendKeys(keys);
	}
	public void enterPassword(String keys) {
		password.clear();
		password.sendKeys(keys);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickForgotPassword() {
		forgotPassword.click();
	}
}
