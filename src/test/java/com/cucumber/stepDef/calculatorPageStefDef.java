package com.cucumber.stepDef;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.pages.calculatorPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class calculatorPageStefDef extends BaseSteps {
	calculatorPage calPg = null;

	@When("^I check \"([^\"]*)\" page is opened$")
	public void i_check_page_is_opened(String arg1) throws Throwable {
		calculatorPage.verifypreCalcPage();

	}

	@Then("^I see information icon for all fields for KiwiSaver Retirement Calculator$")
	public void i_see_information_icon_for_all_fields_for_KiwiSaver_Retirement_Calculator()
			throws Throwable {
		calculatorPage.verifyAllInformationIcons();

	}
	
	
	@When("^I enter \"([^\"]*)\"and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and_and_and_and_and_and_and_and(String empStatus, String age, String salary, String rate, String currKSBal, String volContri, String frequency, String profile, String savingGoalRet) throws Throwable {
		calculatorPage.enterAge(age);
		calculatorPage.selectEmpStatus(empStatus);
		try{
		switch (empStatus) {		
		case "Employed":
			calculatorPage.enterSalary(salary);
			calculatorPage.selectRate(rate);
			calculatorPage.selectRiskProfile(profile);
			//calculatorPage.clickKiwiSaverProjectionBtn();
			//calculatorPage.getRetProjAmt();
			break;
		case "Self-employed":
			calculatorPage.enterCurrentKSBal(currKSBal);
			calculatorPage.enterVolContri(volContri);			
			calculatorPage.selectFrequency(frequency);
			calculatorPage.selectRiskProfile(profile);
			calculatorPage.enterSavingGoalAmount(savingGoalRet);
			//calculatorPage.clickKiwiSaverProjectionBtn();
			//calculatorPage.getRetProjAmt();
			break;
		case "Not employed":
			calculatorPage.enterCurrentKSBal(currKSBal);
			calculatorPage.enterVolContri(volContri);
			calculatorPage.selectFrequency(frequency);
			calculatorPage.selectRiskProfile(profile);
			calculatorPage.enterSavingGoalAmount(savingGoalRet);
			//calculatorPage.clickKiwiSaverProjectionBtn();
			
			break;
		default:
			break;
		}
	} catch (Exception e) {
		e.printStackTrace();
	} 
	}   
	

	@When("^I click on view your kiwisaver retirement projections button$")
	public void i_click_on_view_your_kiwisaver_retirement_projections_button()
			throws Throwable {
		calculatorPage.clickKiwiSaverProjectionBtn();
		

	}

	@Then("^I check the project balance at retirement$")
	public void i_check_the_project_balance_at_retirement() throws Throwable {
		calculatorPage.getRetProjAmt();

	}

}
