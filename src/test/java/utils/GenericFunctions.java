package utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunctions{

	WebDriver driver;
	WebDriverWait wait;

	public GenericFunctions(WebDriver driver) {
		this.driver = driver;
	}

	// Function to switch to child window
	public void switchtoChildWindow() {
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		String parentWindow = it.next(); // This is for the iterator not for the driver
		String childwindow = it.next();
		driver.switchTo().window(childwindow); // driver switching to the childwindow
	}

	// function for explicit wait for the title
	public void waitforpageTitle(String pageTitle) {
		// Explicit wait:
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	//Function for waits 
	public void waitforvisibility(By locator, int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}


