package com.utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stepDefinition.BaseTest;

public class Util {

	public void launchURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void selectText(WebElement ele, String text) throws InterruptedException {
		ele.sendKeys(text);
		Thread.sleep(1000);
		//ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
	}

	public void assertion(boolean flag, String msg) {
		Assert.assertTrue(flag, msg);
	}
	
	public void click(WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click_Action(WebElement ele,WebDriver driver) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(ele).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void explicit_wait_for_title_present(String title,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void explicit_wait_for_visibilityOfAllElements(WebElement elements,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void click_canvas(WebElement canvasElement,WebDriver driver) {
		Actions builder = new Actions(driver);
		builder.clickAndHold(canvasElement).moveByOffset(10, 50).
		moveByOffset(50,10).
		moveByOffset(-10,-50).
		moveByOffset(-50,-10).release().perform();
	}
	
	
}
