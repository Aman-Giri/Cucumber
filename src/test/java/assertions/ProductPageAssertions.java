package assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPageAssertions {
	
	WebDriver driver;
	
	public ProductPageAssertions(WebDriver driver) {
		this.driver = driver;
	}
	
	//Assertion for the title
	public void validateTitle() {
		String expectedTitle = "Apple iPhone 13 (128GB) - Blue : Amazon.in: Electronics";
		String actualTitle = driver.getTitle();
		System.out.println("The Actualtitle is: " + actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
			
}
