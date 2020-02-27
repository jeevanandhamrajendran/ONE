package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.DriverFactory;
import com.utility.Util;

public class HomePage {

	Util util = new Util();
	
	@FindBy(id = "src")
	private WebElement fromTxt;
	public void selectFromValue(String str) throws InterruptedException {
		 util.selectText(fromTxt, str); 
	}
	
	
	@FindBy(id = "dest")
	private WebElement toTxt;
	public void selectToValue(String str) throws InterruptedException {
		 util.selectText(toTxt, str); 
	}
	
	
	
	@FindBy(css = "#search > div > div.fl.search-box.date-box.gtm-onwardCalendar > span")
	private WebElement onwardDate;
	public void onwardDate() {
		util.click(onwardDate);
	}
	
	@FindBy(xpath =  "//*[@id='rb-calendar_onward_cal']/table/tbody//td[text()='28']")
	private WebElement onwardDay;
	public void onwardDay(String str) {
		util.click_Action(onwardDay,driver);
	}
	
	
	@FindBy(id = "return_cal")
	private WebElement returnDate;
	public void returnDate() {
		 util.click_Action(returnDate,driver); 
		
	}
	
	@FindBy(xpath =  "//*[@id='rb-calendar_return_cal']/table/tbody//td[text()='29']")
	private WebElement returnDay;
	public void returnDay(String str) {
		util.click_Action(returnDay,driver);
	}
	
	
	@FindBy(id = "search_btn")
	private WebElement searchButton;
	public void searchButton() {
		util.click(searchButton);
		
	}
	
	WebDriver driver = null;
	
	public HomePage() {
		this.driver = DriverFactory.getCurrentDriver();
		PageFactory.initElements(driver, this);
	}
	
}
