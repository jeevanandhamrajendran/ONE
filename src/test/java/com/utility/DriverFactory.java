package com.utility;

import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is DriverFactory Class.
 */
public class DriverFactory {
	/**
	 * Thread local variable for current driver.
	 */
	private static ThreadLocal<WebDriver> currentDriver = new ThreadLocal<WebDriver>();
	/**
	 * Static Web Driver for the current driver.
	 */
	private static final Logger LOGGER = Logger.getLogger(String.class.getSimpleName());

	public static WebDriver getCurrentDriver() {
		WebDriver driver = currentDriver.get();
		if (driver != null) {
			return driver;
		} else {
			return null;
		}
	}

	/**
	 * Initializing driver.
	 */
	public static void driverInit() {
//		switch (ConfigProvider.getConfig("Driver").toUpperCase()) {
		switch ("CHROME".toUpperCase()) {
		case "FIREFOX":
			currentDriver.set(new DeskDriver().getNewDriver());
			break;
		case "CHROME":
			currentDriver.set(new DeskDriver().getNewDriver());
			break;
		case "IE":
			currentDriver.set(new DeskDriver().getNewDriver());
			break;
		case "SAFARI":
			currentDriver.set(new DeskDriver().getNewDriver());
			break;
		default:
			LOGGER.log(Level.INFO, "Unknown Driver");
		}
	}

	/**
	 * Flush driver after use.
	 */
	public static void driverCleanUp() {
		WebDriver driver = currentDriver.get();
		if (driver != null) {
			getCurrentDriver().quit();
		}
		currentDriver.remove();
	}
}
