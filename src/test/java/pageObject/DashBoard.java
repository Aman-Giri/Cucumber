package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericFunctions;

public class DashBoard extends GenericFunctions {
	
	//dependency Injection
	
	WebDriver driver; 
	
	public DashBoard(WebDriver driver) { //Constructor called first whenever the object is created
		super(driver);
		this.driver = driver;								//This Keyword: This refers to the current class
	}
	
	
	public By searchBox = By.id("twotabsearchtextbox"); //Identifier/ locator
	public By searchBtn = By.id("nav-search-submit-button");
	public By product = By.xpath("//*[contains(text(), 'Apple iPhone 13 (128GB) - Blue')]");
	
	
	//Function for searching the product
	public void searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
	}
	
	//Click on the SearchButton
	public void clickonSearchBtn() {
		driver.findElement(searchBtn).click();
	}
	
	
	//Grab the text of the Product
	public String[] grabProductName() {
		 return driver.findElement(product).getText().split(" ");
	}
	
	public void clickonProduct() {
		driver.findElement(product).click();
	}
	
	
}
