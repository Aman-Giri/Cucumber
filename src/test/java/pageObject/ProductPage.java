package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericFunctions;

public class ProductPage extends GenericFunctions {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	//locators
	public By cartBtn1 = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']");
	public By cartBtn2 = By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input");
	
	
	//pagefunctions
	
	//function for clickling the on the first cart buttoni
	public void clickCart1() {
		driver.findElement(cartBtn1).click();
	}
	
	//click on the cart2 button
	public void clickcartbtn2() {
		waitforvisibility(cartBtn2, 5);
		driver.findElement(cartBtn2).click();
	}
}
