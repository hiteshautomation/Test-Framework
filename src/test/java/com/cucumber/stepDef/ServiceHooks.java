package com.cucumber.stepDef;

import com.aventstack.extentreports.Status;
import com.cucumber.baseSteps.steps.BaseSteps;
import com.cucumber.extent.ExtentManager;
import com.cucumber.extent.ExtentTestManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks extends BaseSteps{
	protected Scenario scenario;
	static String scenarioName;
	static int i=0;
	
	@Before
	public void before(Scenario scenario) throws Exception
	{
		i=i+1;
		this.scenario=scenario;
		scenarioName=scenario.getName();
		System.out.println("SCENARIO NAME FOR TEST IS " +scenarioName );
		ExtentTestManager.startTest("Scenario No : "+i+" " + scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario started is :-" + scenario.getName());
		setUpFramework();	
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

}
