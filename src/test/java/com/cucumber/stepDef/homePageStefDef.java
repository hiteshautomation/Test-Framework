package com.cucumber.stepDef;

import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentManager;
import com.cucumber.extent.ExtentTestManager;
import com.cucumber.pages.homePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class homePageStefDef extends BaseSteps {

	protected Scenario scenario;
	static String scenarioName;
	static int i=0;
	//Action_NewCarSearchPage obj_action_NewCarSearchPage= new Action_NewCarSearchPage();
	homePage homePg=null;
	
	@Before
	public void before(Scenario scenario) throws Exception
	{
		i=i+1;
		this.scenario=scenario;
		scenarioName=scenario.getName();
		System.out.println("SCENARIO NAME FOR TEST IS " +scenarioName );
		ExtentTestManager.startTest("Scenario No : "+i+" " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started is :-" + scenario.getName());
		//getDriver().navigate().to("http://google.com");
		setUpFramework();
		//homePg=new homePage();
		//PageFactory.initElements(getDriver(), homePg);
		
		
		
	}
	
	@After
	public void after(Scenario scenario) throws Exception
	{
		if(scenario.isFailed())
		{
			ExtentTestManager.logFail("Scenario failed");
			ExtentTestManager.addScreenShotOnFailure();
		}
		
		else
		{
			ExtentTestManager.logPass("Scenario passed");
			
		}
		ExtentManager.getReporter().flush();
		quitWebDriver();
	}
	
	@Given("^I launch the website on \"([^\"]*)\"$")
	public void i_launch_the_website_on(String browser) throws Throwable {
		openBrowser(browser);
	    ExtentTestManager.logInfo("Browser opened is -->" + browser); 
	    
	}
	
	@Given("^launch browser \"([^\"]*)\"$")
	public void launch_browser(String browserName) throws Throwable {
		 openBrowser(browserName);
		 ExtentTestManager.logInfo("Browser opened is -->" + browserName);
	}
	
	@Given("^I am on application home page$")
	public void i_am_on_application_home_page() throws Throwable {
		
	    getDriver().navigate().to(appURL);
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
