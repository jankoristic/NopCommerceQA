package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[id^=add-to-cart-button]")
	public WebElement addToCartButton;
	
	@FindBy(css="input[id^=product_enteredQuantity]")
	public WebElement productQuantity;
	
	@FindBy(css="button[id^=add-to-wishlist-button]")
	public WebElement addToWishlistButton;
	
	public void enterQuantity(String keys) {
		productQuantity.clear();
		productQuantity.sendKeys(keys);
	}
}
