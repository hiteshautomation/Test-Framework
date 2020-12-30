package com.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentTestManager;

import utils.generalUti;

public class homePage extends BaseSteps {

	@FindBy(xpath = "//a[text()='Contact us']")
	public static WebElement contactUs;

	@FindBy(xpath = "//a[text()='KiwiSaver']")
	public static WebElement kiwiSaverLink;

	@FindBy(xpath = "//a[text()='KiwiSaver calculators']")
	public static WebElement ksCalcBtn;

	// ############################################################################################################
	// Function Name:
	// Input Parameter: None
	// Output Parameter: None
	// Description:
	// Tester:
	// ############################################################################################################
	public static void verifHomePage() {
		try {
			Assert.assertTrue("User fails to route to home page",generalUti.isElementVisible(contactUs));
			ExtentTestManager.logPass("User successfully routes to home page");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("User fails to routes to home page");
		}
	}

	public static void checkMenuOption(String optionName) {
		try {
			Assert.assertTrue("Kiwi Saver option is not displayed on home page",generalUti.isElementVisible(getDriver().findElement(
							By.xpath("//a[text()='" + optionName + "']"))));
			ExtentTestManager.logPass("Kiwi Saver option is displayed on home page");

		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("Kiwi Saver option is not displayed on home page");
		}
	}

	public static void hoverOverMenuItem(String optionName) {

		try {
			Actions action = new Actions(getDriver());
			action.moveToElement(getDriver().findElement(By.xpath("//a[text()='" + optionName + "']"))).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyBtn(String btnName) {
		try {
			generalUti.waitUntilClickable(getDriver().findElement(By.xpath("//a[text()='" + btnName + "']")));
			ExtentTestManager.logPass(btnName + " is displayed and clickable");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(btnName+ " is either not displayed or clickable");
		}
	}

	public static void clickBtn(String btnName) {
		try {
			generalUti.click(getDriver().findElement(By.xpath("//a[text()='" + btnName + "']")));;
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
