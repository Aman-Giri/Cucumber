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

public class Product {
	
	WebDriver driver;
	WebElement productN;
	WebDriverWait wait;
	String[] product;
	String pWordonCart;
	String pWord;
	
	

	@Then("Validate that product page opened or not")
	public void validate_that_product_page_opened_or_not() {
		GenericFunctions genericFunctions = new GenericFunctions(driver);
		genericFunctions.switchtoChildWindow();
		genericFunctions.waitforpageTitle("Apple iPhone 13 (128GB) - Blue : Amazon.in: Electronics");

		ProductPageAssertions productPageAssertions = new ProductPageAssertions(driver);
		productPageAssertions.validateTitle();
		
	}

	@And("Click on add to cart button and click on cart button again")
	public void click_on_add_to_cart_button_and_click_on_cart_button_again() {
		// Click on the cart button
		ProductPage productPage = new ProductPage(driver);
		//clicking on the first cart button
		productPage.clickCart1();
		//waiting for the second cart button
		productPage.clickcartbtn2();
	}

}
