package com.cucumber.pages;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentTestManager;

import utils.generalUti;

public class calculatorPage extends BaseSteps {

	@FindBy(xpath = "//h1[contains(text(),'KiwiSaver Retirement Calculator')]")
	public static WebElement hdPage;

	@FindBy(xpath = "//label[text()='Current age']/../../..//following-sibling::div[contains(@class,'field-cell field-controls')]//div[contains(@class,'control-constraints')]//div[contains(@class,'control-row')]//div[contains(@class,'control-cell-wrapper')]//div[contains(@class,'control-cell ng-scope ng-isolate-scope')][1]//div//div//input")
	public static WebElement currentAge;

	@FindBy(xpath = "//label[contains(text(),'Employment status')]")
	public static WebElement lblEmpStatus;

	@FindBy(xpath = "//div[@ng-model='ctrl.data.EmploymentStatus']//div//div[@class='control-well']")
	public static WebElement empStatus;

	@FindBy(xpath = "//div[@class='wpnib-field-annual-income field-group ng-scope ng-isolate-scope']//div[@class='field-cell field-controls']//div[@class='control-well']//input")
	public static WebElement salary;

	@FindBy(xpath = "//span[text()='3%']")
	public static WebElement memContribution3;

	@FindBy(xpath = "//span[text()='4%']")
	public static WebElement memContribution4;

	@FindBy(xpath = "//span[text()='8%']")
	public static WebElement memContribution8;

	@FindBy(xpath = "//div[@label='Current KiwiSaver balance']//div[@type='currency']//div[@class='control-well']//input")
	public static WebElement currKWBalance;

	@FindBy(xpath = "//div[contains(@class,'control-with-period control-with-prefix currency-control')]//div[contains(@class,'control-well')]//input[contains(@type,'text')]")
	public static WebElement volContri;

	@FindBy(xpath = "//div[contains(@class,'well-value ng-binding')]//span[contains(@class,'ng-binding ng-scope')][contains(text(),'Frequency')]")
	public static WebElement frquency;

	@FindBy(xpath = "//span[contains(text(),'Defensive')]")
	public static WebElement defensive;

	@FindBy(xpath = "//span[contains(text(),'Conservative')]")
	public static WebElement conversative;

	@FindBy(xpath = "//span[contains(text(),'Balanced')]")
	public static WebElement balanced;

	@FindBy(xpath = "//span[contains(text(),'View your KiwiSaver retirement projections')]")
	public static WebElement retProjbtn;

	@FindBy(xpath = "//span[contains(@class,'result-value result-currency ng-binding')]")
	public static WebElement txtProjectBal;

	@FindBy(xpath = "//div[contains(@class,'wpnib-field-savings-goal field-group ng-isolate-scope')]//div[contains(@class,'control-cell')]//input[contains(@type,'text')]")
	public static WebElement goalSavRetirementAmt;

	static boolean isEventSuccessful = true;
	static List<String> helpIcons = Arrays.asList("Current age","Employment status", "Current KiwiSaver balance",
			"Voluntary contributions", "Risk profile","Savings goal at retirement");

	static String projectedRetamt;

	public static void verifypreCalcPage() {
		try {
			generalUti.waitUntilElementVisible(hdPage);
			Assert.assertTrue("User fails to route to calculator page",generalUti.isElementVisible(hdPage));
			ExtentTestManager.logPass("User successfully routes to calculator page");
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("User fails to lands on calculator page");
		}
	}

	public static void verifyAllInformationIcons() {
		try {

			getDriver().switchTo().frame(0);
			for (String s1 : helpIcons) {
				if (generalUti.isElementVisible(getDriver().findElement(By.xpath("//label[text()='"+ s1+ "']/../../..//following-sibling::div[contains(@class,'field-cell field-controls')]//div[contains(@class,'field-info ng-scope')]//button")))) 
				{
					ExtentTestManager.logInfo("Help icon for " + s1+ " is displayed");
					//isEventSuccessful = true;
				}				
				 else{ 
					 ExtentTestManager.logInfo("Help icon for " +s1 + "not is displayed"); 
					 isEventSuccessful=false;
				}
			}
			Assert.assertTrue("App fails to display one of help icon",isEventSuccessful);			
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("Help icons fails to displays information icons");
			Assert.assertTrue(false);
		}
	}
	
	

	public static void enterAge(String data) {
		try {
			getDriver().switchTo().frame(0);
			generalUti.waitUntilClickable(currentAge);
			generalUti.enterText(currentAge, data);
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			Assert.assertTrue(false);

		}
	}

	public static void enterSalary(String data) {
		try {
			generalUti.waitUntilClickable(salary);
			generalUti.enterText(salary, data);
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + "could not be entered"));
			Assert.assertTrue(false);
		}
	}

	public static void enterCurrentKSBal(String data) {
		try {
			generalUti.waitUntilClickable(currKWBalance);
			generalUti.enterText(currKWBalance, data);
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			Assert.assertTrue(false);
		}
	}

	public static void enterVolContri(String data) {
		try {
			// generalUti.waitUntilClickable(volContri);
			generalUti.enterText(volContri, data);
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			Assert.assertTrue(false);
		}
	}

	public static void enterSavingGoalAmount(String data) {
		try {
			// generalUti.waitUntilClickable(volContri);
			generalUti.enterText(goalSavRetirementAmt, data);
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			Assert.assertTrue(false);
		}
	}

	public static void selectEmpStatus(String data) {
		try {
			Thread.sleep(5000);
			empStatus.click();
			generalUti.waitUntilClickable(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			generalUti.click(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			ExtentTestManager.logInfo((data + " option selected successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Failed to select option-->" + data));
			Assert.assertTrue(false);
		}
	}

	public static void selectFrequency(String data) {
		try {

			Thread.sleep(5000);
			frquency.click();
			generalUti.waitUntilClickable(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			generalUti.click(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			ExtentTestManager.logInfo((data + " option selected successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Failed to select " + data));
			Assert.assertTrue(false);

		}
	}

	public static void selectRate(String data) {
		try {
			generalUti.click(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			ExtentTestManager.logInfo((data + " entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be selected"));
			Assert.assertTrue(false);
		}
	}

	public static void selectRiskProfile(String data) {
		try {
			generalUti.click(getDriver().findElement(By.xpath("//span[contains(text(),'" + data + "')]")));
			ExtentTestManager.logInfo((data + " option selected successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be selected"));
			Assert.assertTrue(false);
		}
	}

	public static void clickKiwiSaverProjectionBtn() {
		try {
			generalUti.waitUntilClickable(retProjbtn);
			generalUti.click(retProjbtn);
			ExtentTestManager.logInfo(("Button for retirement projection clicked successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Kiwi Saver projection button could not be clicked"));
			Assert.assertTrue(false);
		}
	}

	public static void getRetProjAmt() {
		try {
			generalUti.waitUntilElementVisible(txtProjectBal);
			projectedRetamt = txtProjectBal.getText();
			System.out.println("Proejct retirement amount is -->"+ projectedRetamt);
			ExtentTestManager.logInfo(("Proejct retirement amount is --> " + projectedRetamt));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Projected retirement amount failed to show"));
			Assert.assertTrue(false);
		}
	}

}
