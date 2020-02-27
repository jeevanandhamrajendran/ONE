package com.stepDefinition;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.testautomation.Listeners.ExtentReportListener;
import com.utility.DriverFactory;
import com.utility.GReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@Test
@CucumberOptions(
		features="src/test/resources/features", 
		glue= {"com.stepDefinition"},
		tags = {"@redbus"},
		/*format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },*/
		/*
		 * plugin = {
		 * "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
		 * "json:target/cucumber-reports/CucumberTestReport.json"},
		 */
				plugin = {"pretty","html:target/cucumber-reports/cucumber-pretty/report.html"}
				/*plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}*/
			)	

public class BaseTest extends ExtentReportListener{

	 
	 
	//public WebDriver driver;
	private TestNGCucumberRunner testNGCucumberRunner;
	GReporter classReport;
	
	@BeforeClass
	public void setUp() {
		 testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		
		String suiteName = "Desktop";
		String className ="className";
		String testName ="TestName";
		GReporter.initReport(suiteName);
		classReport = new GReporter(className + " <span class='device-name'> " + testName + "</span>","Regression Test Set", suiteName);
		
	}

	@Test(alwaysRun=true, groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		
		try {
			
			  String fn = cucumberFeature.toString();
			  String sc = pickleEvent.toString();
			  System.out.println(fn);
			  System.out.println(sc);
//			 String fn=cucumberFeature.toString();
			
			 GReporter.initTest(fn,sc);
			DriverFactory.driverInit();
			GReporter.log(LogStatus.PASS,"Browser opened");
			
		} catch (AssertionError | Exception e) {
			GReporter.log(LogStatus.ERROR,e.getMessage());
		}
		
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
		classReport.appendParent();
		DriverFactory.driverCleanUp();
    }
	
	
    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
     *         objects.
     */
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    
	@AfterClass
	public void tearDown() {
		
		classReport.endParent("Desktop");
		GReporter.endReport("Desktop");
		//DriverFactory.driverCleanUp();
	}
	
}
