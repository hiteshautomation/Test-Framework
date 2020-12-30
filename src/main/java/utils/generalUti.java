package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentTestManager;

public class generalUti extends BaseSteps {

	public static boolean isElementVisible(WebElement we) {
		
		if (we.isDisplayed()) {
			return true;
		} else {
			System.out.println("The target is null");
			return false;
		}
	}
	
 static void waitUntilElementClickable(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// public static void click(WebDriver driver, By by) {
	public static void waitUntilClickable(WebElement ele) {
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(), 20);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			// ele.click();
		} catch (StaleElementReferenceException ex) {
			// simply retry finding the element in the refreshed DOM
			// getDriver().findElement(by).click();
		} catch (TimeoutException toe) {
			// ExtentTestManager.logInfo("Element identified by " +
			// we.toString() + " was not clickable after 10 seconds");

		}
	}

	public static void waitUntilElementVisible(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void click(WebElement we) {
		try {
			we.click();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	public static void enterText(WebElement we,String data){
		try {
			//getDriver().switchTo().frame(0);
			we.sendKeys(data);

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
