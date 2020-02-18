package com.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepDefinition.BaseTest;
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
	
	@FindBy(xpath =  "//*[@id='rb-calendar_onward_cal']/table/tbody//td[text()='19']")
	private WebElement onwardDay;
	public void onwardDay(String str) {
		util.click_Action(onwardDay);
	}
	
	
	@FindBy(id = "return_cal")
	private WebElement returnDate;
	public void returnDate() {
		util.click_Action(returnDate);
	}
	
	@FindBy(xpath =  "//*[@id='rb-calendar_return_cal']/table/tbody//td[text()='26']")
	private WebElement returnDay;
	public void returnDay(String str) {
		util.click_Action(returnDay);
	}
	
	
	@FindBy(id = "search_btn")
	private WebElement searchButton;
	public void searchButton() {
		util.click(searchButton);
		
	}
	
	public HomePage() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
}
