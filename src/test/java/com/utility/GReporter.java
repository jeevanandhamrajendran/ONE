package com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GReporter {

	  public ExtentTest testParent;
	  public static String reportPath;
	  public static int passCountD = 0;
	  public static int pass = 0;
	  public static int fail = 0;
	  public static int failCountD = 0;
	  public static int passCountM = 0;
	  public static int failCountM = 0;
	  public static int passCount = 0;
	  public static int FailCount = 0;
	  public static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
	  public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	  public static ThreadLocal<Boolean> isPassed = new ThreadLocal<Boolean>();
	  public static Map<String, GReporter> classReportMap = new HashMap<String, GReporter>();
	  public static Map<String, Map<String, Map<String, ArrayList<Map<String, Boolean>>>>> mailOverview = new HashMap<String, Map<String, Map<String, ArrayList<Map<String, Boolean>>>>>();
	  private static ExtentReports extentD;
	  private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName());
	  
	  public static String htmReport = "";

	  /**
	   * initReport() constructs the Extent Report
	   * 
	   * @param suiteName
	   */
	  public static void initReport(String suiteName) {
	    String path = "./custom_report/";
	    String fileName = new SimpleDateFormat("yyyyMMddhhmm").format(new Date());

	    new File(path + "Report_" + fileName).mkdirs();
	    reportPath = path + "Report_" + fileName;
	    LOGGER.log(Level.INFO, "The report path is ------ " + reportPath);
	    LOGGER.log(Level.INFO, "Into Init Report");
	   
	    String css = ".test-node-name .categoryDriver {background-color: #22b5e1; border-radius: 2px; color: #fff; font-size: 12px; margin-right: 3px; padding: 2px 4px; font-family: Roboto, Nunito, 'Source Sans Pro', Arial;font-weight: 400;line-height: 1.5;}"
	        + ".test-node-name .categoryDevice {background-color: #22b5e1; border-radius: 2px; color: #fff; font-size: 12px; margin-right: 3px; padding: 2px 4px; font-family: Roboto, Nunito, 'Source Sans Pro', Arial;font-weight: 400;line-height: 1.5;}"
	        + ".test-node-name .categoryBrowser {background-color: #22b5e1; border-radius: 2px; color: #fff; font-size: 12px; margin-right: 3px; padding: 2px 4px; font-family: Roboto, Nunito, 'Source Sans Pro', Arial;font-weight: 400;line-height: 1.5;}"
	        + ".test-node-name .categoryOS {background-color: #22b5e1; border-radius: 2px; color: #fff; font-size: 12px; margin-right: 3px; padding: 2px 4px; font-family: Roboto, Nunito, 'Source Sans Pro', Arial;font-weight: 400;line-height: 1.5;}";
	    	
	        String dateTime = new SimpleDateFormat("yyyyMMdd-hhmm").format(new Date());
	        htmReport = "Jeeva_Execution_Result" + dateTime + ".htm";
	        
	        System.out.println("Report Name: " + htmReport);

	        extentD = new ExtentReports(reportPath + "/" + htmReport, true);
	        //extentD.config().documentTitle("UM Hybrid Framework").reportName("Test Results Desktop").reportHeadline("- UM Framework");
	        //extentD.config().insertCustomStyles(css);


	    
	  }

	  /**
	   * Constructor of UMReporter class In Turn calls the initParent() which starts
	   * the extent report
	   * 
	   * @param className
	   * @param testName
	   * @param suiteName
	   */
	  public GReporter(String className, String testName, String suiteName) {
	    initParent(className, testName, suiteName);
	  }

	  /**
	   * Log Execution Status with its Step Name.
	   * 
	   * @param logStatus
	   *          - Status of the test
	   * @param stepName
	   *          - Name of the Step executed
	   */
	  public static void log(LogStatus logStatus, String stepName) {
	    //test.get().log(logStatus, stepName);
	    String path = "";
	    switch (logStatus) {
	      case PASS:
	        String SSValue = ("YES");
	        if (SSValue.equalsIgnoreCase("YES")) {
	          try {
	            path = "";
	            test.get().log(logStatus, stepName + test.get().addScreenCapture(path));
	          } catch (Exception e) {
	            test.get().log(LogStatus.FAIL, "Failed to capture screen shot. " + stepName);
	          }
//	          test.get().log(logStatus, stepName + test.get().addScreenCapture(path));
	        } else {
	         // test.get().log(logStatus, stepName);
	        }
	        break;
	      case FAIL:
	        LOGGER.log(Level.INFO, "Inside Fail");
	        try {
	          test.get().log(logStatus, stepName + test.get().addScreenCapture(path));
	        } catch (Exception e) {
	          LOGGER.log(Level.INFO, "Inside Fail catch ");
	          test.get().log(LogStatus.FAIL, "Failed to capture screenshot. " + stepName);
	        }
	        isPassed.set(false);
	        // Assert.fail();
	        break;
	      case INFO:
	    	  break;
	      case SKIP:
	    	  break;
	      case WARNING:
	        test.get().log(logStatus, stepName);
	        break;
	      case ERROR:
	    	  try {
	    	  } catch (Exception e1) {
				e1.printStackTrace();
			}
	          test.get().log(logStatus, stepName + test.get().addScreenCapture(path));
	    	  isPassed.set(false);
	          break;
	      case FATAL:
	    	  break;
	      case UNKNOWN:
	        try {
	          test.get().log(logStatus, stepName + test.get().addScreenCapture(path));
	        } catch (Exception e) {
	          test.get().log(LogStatus.FAIL, "Failed to capture screenshot. " + stepName);
	        }
	        isPassed.set(false);
	        LOGGER.log(Level.INFO, isPassed.get().toString());
	        // Assert.fail();
	        break;
	      default:
	        break;
	    }
	    LOGGER.log(Level.INFO, sdf.format(new Date()) + " " + isPassed.get());
	  }

	  /**
	   * starts the extent report with and without screen shots for Desktop and
	   * Mobile
	   * 
	   * @param className
	   * @param testName
	   * @param suiteName
	   */
	  public void initParent(String className, String testName, String suiteName) {
	      testParent = extentD.startTest(className, testName);
	  }

	  /**
	   * This method is called before each and every test to set the OS, Browser,
	   * Environment and Res_Height details.
	   * 
	   * @param testName
	   *          - Name of the test
	   * @param suiteName
	   *          - Name of the Suite
	   */
	  public static void initTest(String featureName, String scenarioName) {
	    String hw = null;
	    scenarioName = "SCENARIO : "+scenarioName + " <span class='categoryOS'>" + "" + "</span>" + " <span class='categoryBrowser '>"
	            + "" + "</span>" + " <span class='categoryEnvironment '>" + "" + "</span>"
	            + " <span class='categoryheightwidth '>" + "" + "</span>";
	    isPassed.set(true);

	    test.set(getExtent().startTest(scenarioName, "description"));

	  }

	  /**
	   * Assigns the Platform details before each and every test.
	   * 
	   * @param catogory
	   *          - Platform Category
	   */
	  public static void assignCatogory(String Catogory) {
	    test.get().assignCategory(Catogory);
	  }

	  /**
	   * Ends the Extent Report after all the tests has been done This is called in
	   * After Class.
	   * 
	   * @param suiteName
	   *          - Name of the Suite
	   */
	  public void endParent(String suiteName) {
	      extentD.endTest(testParent);
	  }

	  /**
	   * endReport() flush and closes the Extent Report. This is called in After
	   * Suite.
	   * 
	   * @param suiteName
	   *          - Name of the Suite
	   */
	  public static void endReport(String suiteName) {
	      extentD.flush();
	      extentD.close();
	  }

	  /**
	   * getExtent() returns either desktop report or mobile report path.
	   * 
	   * @return - Extent Desktop or Extent Mobile
	   */
	  private static ExtentReports getExtent() {
	        return extentD;
	  }


	  /**
	   * append Parent is called after each and every test to log the execution
	   * status count.
	   */
	  public void appendParent() {
	    testParent.appendChild(test.get());

	      if (isPassed.get()) {
	        passCountD = passCountD + 1;                
	        pass= pass+1; 
	        
	      } else {
	        failCountD = failCountD + 1;                 
	        fail=fail+1;
	       
	      }
	   
	    test.remove();
	    isPassed.remove();
	  }


}
