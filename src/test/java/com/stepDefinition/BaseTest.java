package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

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
		plugin = "json:target/cucumber-reports/CucumberTestReport.json"
			)	

public class BaseTest {

	public static WebDriver driver;
	 private TestNGCucumberRunner testNGCucumberRunner;
	 
	
	@BeforeClass
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver(options);
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
    }

    /**
     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
     *         objects.
     */
    @DataProvider
    public Object[][] scenarios() {
        return testNGCucumberRunner.provideScenarios();
    }

    
	@AfterClass
	public void tearDown() {
		//Reporter.loadXMLConfig(new File("extent-config.xml"));
		//driver.close();
	}
	
	public void openBrowser() {
		
		driver = new ChromeDriver();
	}
}
