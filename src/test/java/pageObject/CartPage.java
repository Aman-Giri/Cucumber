package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericFunctions;

public class CartPage extends GenericFunctions {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// locators
	public By product = By.linkText("Apple iPhone 13 (128GB) - Blue");

	// pagefunctions

	// Grab the text of the Product
	public String[] grabProductName() {
		return driver.findElement(product).getText().split(" ");
	}

}
