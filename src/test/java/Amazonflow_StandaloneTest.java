import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Amazonflow_StandaloneTest {

	public static void main(String[] args) {
		
		
		//Launch the amazon website
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.in");
		//maximise the window
		driver.manage().window().maximize();
		//global wait or implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//printing the title of page
		System.out.println("The title is: " + driver.getTitle());
		
		//search the Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 13 blue");
		//click on search button
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		//grab the text 
		WebElement productN =  driver.findElement(By.xpath("//span[normalize-space()='Apple iPhone 13 (128GB) - Blue']"));
		String productName = productN.getText();
		System.out.println("The product name is: " + productName);
		//Using String manipulation for getting the apple word
		String[] product = productName.split(" ");
		String pWord = product[0];
		System.out.println(pWord);
		//Clicking on the product
		productN.click(); // after clicking on this we redirected to productPage in another window
		
		//handling the windows 
		Set<String> wh = driver.getWindowHandles(); 
		Iterator<String> it =  wh.iterator();
		String parentWindow = it.next(); // This is for the iterator not for the driver
		String childwindow = it.next();
		driver.switchTo().window(childwindow); // driver switching to the childwindow
		
		//Explicit wait: 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Apple iPhone 13 (128GB) - Blue : Amazon.in: Electronics"));
		
	
		//Asserting the title for the product page
		String expectedTitle = "Apple iPhone 13 (128GB) - Blue : Amazon.in: Electronics";
		String actualTitle = driver.getTitle();
		System.out.println("The Actualtitle is: " + actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		
		//Click on the cart button
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//input[@id='add-to-cart-button']")).click();
		WebElement cart2 = driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input"));
		wait.until(ExpectedConditions.visibilityOf(cart2));
		cart2.click(); //redirecting to the cart page on the same window
		
		//Validating the cart page opened or not  by asserting the title of the cart page
		String expectedTitleforCart = "Amazon.in Shopping Cart";
		String actualCartTitle = driver.getTitle();
		Assert.assertEquals(expectedTitleforCart, actualCartTitle);
		System.out.println("The title assertions are passed");
		
		//Grabbing the text from the cart page 
		WebElement productNonCartpage =  driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Blue"));
		String productNameonCart = productNonCartpage.getText();
		System.out.println("The product name is: " + productNameonCart);
		//Using String manipulation for getting the apple word
		String[] productonCart = productNameonCart.split(" ");
		String pWordonCart = product[0];
		System.out.println(pWordonCart);
		
		//Asserting the product name from the dashboard and cart page
		Assert.assertEquals(pWordonCart, pWord);
		System.out.println("Product Assertions are completed");
		
		driver.quit();
		
		

	}

}
