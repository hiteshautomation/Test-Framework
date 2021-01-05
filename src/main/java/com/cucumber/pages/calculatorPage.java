package com.cucumber.pages;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
	
	// ############################################################################################################
	// Function Name:verifypreCalcPage
	// Input Parameter: None
	// Output Parameter: None
	// Description: To verify whether user successfully lands on pre calculation page
	// Tester:
	// ############################################################################################################

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

	// ############################################################################################################
	// Function Name:verifyAllInformationIcons
	// Input Parameter: None
	// Output Parameter: None
	// Description: To verify the presence of information icons for all fields on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################
	
	public static void verifyAllInformationIcons() {
		try {
			getDriver().switchTo().frame(0);
			
			for (String s1 : helpIcons) {
				generalUti.waitUntilElementVisible(getDriver().findElement(By.xpath("//label[text()='"+ s1+ "']/../../..//following-sibling::div[contains(@class,'field-cell field-controls')]//div[contains(@class,'field-info ng-scope')]//button")));
				if (generalUti.isElementVisible(getDriver().findElement(By.xpath("//label[text()='"+ s1+ "']/../../..//following-sibling::div[contains(@class,'field-cell field-controls')]//div[contains(@class,'field-info ng-scope')]//button")))) 
				{
					ExtentTestManager.logPass("Help icon for " + s1+ " is displayed");
				}				
				 else{ 
					 ExtentTestManager.logFail("Help icon for " +s1 + "not is displayed"); 
					 isEventSuccessful=false;
				}
			}
			Assert.assertTrue("App fails to display one of help icon",isEventSuccessful);			
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail("Help icons fails to displays information icons");
			//Assert.assertTrue(false);
		}
	}	

	// ############################################################################################################
	// Function enterAge
	// Input Parameter: Age
	// Output Parameter: None
	// Description: To enter age on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################
	
	public static void enterAge(String data) {
		try {
			getDriver().switchTo().frame(0);
			generalUti.waitUntilClickable(currentAge);
			generalUti.enterText(currentAge, data);
			ExtentTestManager.logInfo((data + " (Age) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			//Assert.assertTrue(false);

		}
	}
	
	// ############################################################################################################
	// Function enterSalary
	// Input Parameter: Salary
	// Output Parameter: None
	// Description: To enter salary on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################

	public static void enterSalary(String data) {
		try {
			generalUti.waitUntilClickable(salary);
			generalUti.enterText(salary, data);
			ExtentTestManager.logInfo(("$"+data + " (Salary) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("$" + data + "could not be entered"));
			//Assert.assertTrue(false);
		}
	}

	// ############################################################################################################
	// Function enterCurrentKSBal
	// Input Parameter: Current Kiwi Saver balance
	// Output Parameter: None
	// Description: To enter Current Kiwi Saver balance on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################
	
	public static void enterCurrentKSBal(String data) {
		try {
			generalUti.waitUntilClickable(currKWBalance);
			generalUti.enterText(currKWBalance, data);
			ExtentTestManager.logInfo((data + " (Current Kiwi Saver balance ) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function enterVolContri
	// Input Parameter: Vol Contribution
	// Output Parameter: None
	// Description: To enter voluntary contribution on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################

	public static void enterVolContri(String data) {
		try {
			generalUti.enterText(volContri, data);
			ExtentTestManager.logInfo((data + " (Contribution rate) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function enterSavingGoalAmount
	// Input Parameter: Saving goal amount
	// Output Parameter: None
	// Description: To enter saving goal amount on Kiwi retirement calculator page
	// Tester:
	// ############################################################################################################
	public static void enterSavingGoalAmount(String data) {
		try {
			generalUti.enterText(goalSavRetirementAmt, data);
			ExtentTestManager.logInfo((data + " (Saving Goal Amount) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be entered"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function selectEmpStatus
	// Input Parameter: Employment Status
	// Output Parameter: None
	// Description: A generic function to select various employment status such as Employed or Self Employed or 
	// Not Employed etc. on Kiwi retirement calator page
	// Tester:
	// ############################################################################################################

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
		}
	}
	
	// ############################################################################################################
	// Function selectFrequency
	// Input Parameter: Frequency
	// Output Parameter: None
	// Description: A generic function to select various frequency types such as Weekly or Monthly or Annually 
	// on Kiwi retirement calator page
	// Tester:
	// ############################################################################################################

	public static void selectFrequency(String data) {
		try {
			Thread.sleep(5000);
			frquency.click();
			generalUti.waitUntilClickable(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			generalUti.click(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			ExtentTestManager.logInfo((data + " (Frequency) option selected successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Failed to select " + data));
			//Assert.assertTrue(false);

		}
	}

	// ############################################################################################################
	// Function selectFrequency
	// Input Parameter: Rates
	// Output Parameter: None
	// Description: A generic function to select various rates such as 3% or 4$ etc on Kiwi retirement calator page
	// Tester:
	// ############################################################################################################
	public static void selectRate(String data) {
		try {
			generalUti.click(getDriver().findElement(By.xpath("//span[text()='" + data + "']")));
			ExtentTestManager.logInfo((data + " (Rate) entered successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be selected"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function selectRiskProfile
	// Input Parameter: Risk profiles
	// Output Parameter: None
	// Description: A generic function to select various risk profiles such as 'Defensive' or 'Conservative'
	// etc on Kiwi retirement calator page
	// Tester:
	// ############################################################################################################

	public static void selectRiskProfile(String data) {
		try {
			generalUti.click(getDriver().findElement(By.xpath("//span[contains(text(),'" + data + "')]")));
			ExtentTestManager.logInfo((data + " (Risk profile) selected successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Data for " + data + " could not be selected"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function clickKiwiSaverProjectionBtn
	// Input Parameter: None
	// Output Parameter: None
	// Description: To click on view your Kiwi saver projection button
	// Tester:
	// ############################################################################################################

	public static void clickKiwiSaverProjectionBtn() {
		try {
			generalUti.waitUntilClickable(retProjbtn);
			generalUti.click(retProjbtn);
			ExtentTestManager.logInfo(("Button for retirement projection clicked successfully"));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Kiwi Saver projection button could not be clicked"));
			//Assert.assertTrue(false);
		}
	}
	
	// ############################################################################################################
	// Function getRetProjAmt
	// Input Parameter: None
	// Output Parameter: None
	// Description: To get projection amount
	// Tester:
	// ############################################################################################################

	public static void getRetProjAmt() {
		try {
			generalUti.waitUntilElementVisible(txtProjectBal);
			projectedRetamt = txtProjectBal.getText();
			System.out.println("Proejct retirement amount is -->"+ projectedRetamt);
			ExtentTestManager.logInfo(("Calculated Proejct retirement amount is --> " + projectedRetamt));
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logFail(("Projected retirement amount failed to show"));
			//Assert.assertTrue(false);
		}
	}

}
