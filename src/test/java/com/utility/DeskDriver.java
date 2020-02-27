package com.utility;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

/**
 * Class to manage the desk drivers.
 */
public class DeskDriver implements DriverInterface {
  /**
   * domdriver is an instance of webdriver.
   */
  private WebDriver domDriver = null;
  /**
   * remote driver is initiated to run in parallel browsers.
   */
  private WebDriver remoteDriver = null;

  /**
   * @return
   */
  private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName());

  public WebDriver getNewDriver() {
   
      if (domDriver == null) {
        switch ("Chrome".toUpperCase()) {
          case "FIREFOX":
            domDriver = new FirefoxDriver();
            break;
          case "CHROME":
        	  ChromeOptions options = new ChromeOptions();
      		options.addArguments("--disable-notifications");
      		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");  
      		domDriver = new ChromeDriver(options);
//            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//            domDriver = new ChromeDriver();
            break;
          case "IE10":
            /*
             * System.setProperty("webdriver.ie.driver",
             * "C:\\selenium\\IEDriverServer.exe");
             */
            domDriver = new InternetExplorerDriver();
            break;
          case "IE":
            /*
             * System.setProperty("webdriver.ie.driver",
             * "C:\\selenium\\IEDriverServer.exe");
             */
            domDriver = new InternetExplorerDriver();
            break;
          /*
           * case "API": domDriver = null;
           */
          case "SAFARI":
            domDriver = new SafariDriver();
            break;
          default:
            domDriver = new FirefoxDriver();
            break;
        }
      }
      domDriver.manage().window().maximize();
      return domDriver;

  }

  /**
   * @return
   */
  public WebDriver getRemoteDriver() {
    String selHost ="";// ConfigProp.getPropertyValue("SelHost");
    DesiredCapabilities desiredCap = null;
    try {
      switch ("Browser".toUpperCase()) {
        case "FIREFOX":
          desiredCap = DesiredCapabilities.firefox();
          break;
        case "CHROME":
          // System.setProperty("webdriver.chrome.driver",
          // "C:/chromedriver_win32/chromedriver.exe");
          desiredCap = DesiredCapabilities.chrome();
          desiredCap.setBrowserName("chrome");
          break;
        case "IE":
          LOGGER.log(Level.INFO, "IE - Inside Switch");
          /*
           * System.setProperty("webdriver.ie.driver",
           * "D:\\Users\\saravanan.mariappan\\Desktop\\Server\\
           * IEDriverServer.exe");
           */
          desiredCap = DesiredCapabilities.internetExplorer();
          desiredCap.setBrowserName("internet explorer");
//          String version = ConfigProvider.getConfig("Version");
          desiredCap.setVersion("");
          desiredCap.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 30000);
          desiredCap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true);
          desiredCap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
          desiredCap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
          desiredCap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
          break;
        case "SAFARI":
          SafariOptions options = new SafariOptions();
//          options.setUseCleanSession(true);
          desiredCap = DesiredCapabilities.safari();
          desiredCap.setCapability("webdriver.safari.noinstall", "true");
          desiredCap.setCapability(SafariOptions.CAPABILITY, options);
          break;
        default:
          desiredCap = DesiredCapabilities.firefox();
          break;
      }
      remoteDriver = new RemoteWebDriver(new URL(selHost), desiredCap);
			/*
			 * String strWidth = ConfigProvider.getConfig("Res_Width"); String strHeight =
			 * ConfigProvider.getConfig("Res_Height"); LOGGER.log(Level.INFO, strWidth + "*"
			 * + strHeight); if (!strWidth.isEmpty() && !strHeight.isEmpty()) {
			 * LOGGER.log(Level.INFO, strWidth + "**" + strHeight); int intWidth =
			 * Integer.parseInt(strWidth); int intHeight = Integer.parseInt(strHeight);
			 * remoteDriver.manage().window().setSize(new Dimension(intWidth, intHeight)); }
			 * else { remoteDriver.manage().window().maximize(); }
			 */
    } catch (Exception e) {
      LOGGER.log(Level.INFO, "Driver Issue");
      e.printStackTrace();
    }
    return remoteDriver;
  }
}