package assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPageAssertions {
	
	WebDriver driver;
	
	public CartPageAssertions(WebDriver driver) {
		this.driver = driver;
	}
	
	//function to assert the title of the Page 
	public void validateCartPageTitle() {
		String expectedTitleforCart = "Amazon.in Shopping Cart";
		String actualCartTitle = driver.getTitle();
		Assert.assertEquals(expectedTitleforCart, actualCartTitle);
		System.out.println("The title assertions are passed");
	}
	
	//function to assert the
	
	
	
}
