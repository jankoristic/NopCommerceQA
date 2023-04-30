package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[contains(@class, 'notmobile')]//a[@href='/computers']")
	public WebElement computers;
	
	@FindBy(xpath="//ul[contains(@class, 'notmobile')]//a[@href='/desktops']")
	public WebElement desktops;
	
	@FindBy(className="ico-register")
	public WebElement register;
	
	@FindBy(className="ico-login")
	public WebElement login;
	
	@FindBy(className="ico-logout")
	public WebElement logout;
	
	public void clickDesktops() {
		Actions action = new Actions(this.driver);
		action.moveToElement(computers).perform();
		desktops.click();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickRegister() {
		register.click();
	}
}
