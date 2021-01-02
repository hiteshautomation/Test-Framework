package com.cucumber.stepDef;

import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentTestManager;
import com.cucumber.pages.homePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class homePageStefDef extends BaseSteps {

	homePage homePg=null;
	
	@Given("^launch browser \"([^\"]*)\"$")
	public void launch_browser(String browserName) throws Throwable {
		 openBrowser(browserName);
		 ExtentTestManager.logInfo("Browser opened is -->" + browserName);
	}
	
	@Given("^I am on application home page$")
	public void i_am_on_application_home_page() throws Throwable {	
		String s1=BaseSteps.appURL;
		getDriver().navigate().to(BaseSteps.appURL);
	    homePage.verifHomePage();	  
	}

	@When("^I check for the presence of \"([^\"]*)\" option$")
	public void i_check_for_the_presence_of_option(String optionName) throws Throwable {
		homePage.checkMenuOption(optionName);
	    
	}

	@When("^I hover over \"([^\"]*)\"$")
	public void i_hover_over(String optionName) throws Throwable {
		homePage.hoverOverMenuItem(optionName);

	}

	@When("^I check \"([^\"]*)\" button is displayed$")
	public void i_check_button_is_displayed(String btnName) throws Throwable {
		homePage.verifyBtn(btnName);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		homePage.clickBtn(arg1);
	    
	}
}
