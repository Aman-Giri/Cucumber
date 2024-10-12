package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import assertions.CartPageAssertions;
import assertions.ProductPageAssertions;
import io.cucumber.java.en.*;
import pageObject.CartPage;
import pageObject.DashBoard;
import pageObject.ProductPage;
import utils.GenericFunctions;

public class Cart {
	
	WebDriver driver;
	WebElement productN;
	WebDriverWait wait;
	String[] product;
	String pWordonCart;
	String pWord;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	

	
	@Then("Validate that Add to cart page opened or not")
	public void validate_that_add_to_cart_page_opened_or_not() {
		CartPageAssertions cartPageAssertions = new CartPageAssertions(driver);
		cartPageAssertions.validateCartPageTitle();
	}

	@And("Grab the text of the iPhone from cart page")
	public void grab_the_text_of_the_i_phone_from_cart_page() {
		// Grabbing the text from the cart page
		CartPage cartPage = new CartPage(driver);
		product = cartPage.grabProductName();
		pWordonCart = product[0];
		System.out.println(pWordonCart);
	}

	@Then("Assert that text grabbed from dashboard page and cart page should be same")
	public void assert_that_text_grabbed_from_dashboard_page_and_cart_page_should_be_same() {
		// Asserting the product name from the dashboard and cart page
		Assert.assertEquals(pWordonCart, pWord);
		System.out.println("Product Assertions are completed");

		driver.quit();
	}
}
