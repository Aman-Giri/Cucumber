package stepDefinitions;

import java.awt.TextComponent;
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
import utils.TextContextSetup;

public class Dashboard {
	
	WebDriver driver;
	WebElement productN;
	WebDriverWait wait;
	String[] product;
	String pWordonCart;
	String pWord;
	
	TextContextSetup textContextSetup;
	
	public Dashboard(TextContextSetup textContextSetup) {
		this.textContextSetup = textContextSetup;
	}
	
	@Given("Open the Dashboard by navigating to amazon website")
	public void open_the_dashboard_by_navigating_to_amazon_website() {
		// printing the title of page
		System.out.println("The title is: " + driver.getTitle());
	}

	@When("Search the iPhone on dashboard page")
	public void search_the_i_phone_on_dashboard_page() {
		DashBoard dashBoard = new DashBoard(driver);
		dashBoard.searchProduct("iphone 13 blue");
		dashBoard.clickonSearchBtn();
	}
	

	@Then("Grab the text of the iPhone from dashboard page")
	public void grab_the_text_of_the_i_phone_from_dashboard_page() {
		DashBoard dashBoard = new DashBoard(driver);
		product = dashBoard.grabProductName();
		pWord = product[0]; // we are not printing it directly bcz we are using it in assertions in below functions
		System.out.println(pWord); 
	}

	@And("Click on the product")
	public void click_on_the_product() {
		DashBoard dashBoard = new DashBoard(driver);
		dashBoard.clickonProduct();
	}

}
