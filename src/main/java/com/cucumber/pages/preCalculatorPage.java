package com.cucumber.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentTestManager;

import utils.generalUti;

public class preCalculatorPage extends BaseSteps{
	
	@FindBy(xpath="//h1[contains(text(),'Westpac KiwiSaver Scheme Risk Profiler')]")
	public static WebElement hdPreCalcPg;
	
	@FindBy(xpath="//a[text()='Click here to get started.']")
	public WebElement btnGetStarted;
	
	public static void verifypreCalcPage() {
		try {
			generalUti.waitUntilElementVisible(hdPreCalcPg);
			Assert.assertTrue("User fails to lands on pre calculator page", generalUti.isElementVisible(hdPreCalcPg));
			ExtentTestManager.logPass("User successfully routes to pre calculator page");
			
		}catch(Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("User fails to lands on pre calculator page");
		}
	}
}
