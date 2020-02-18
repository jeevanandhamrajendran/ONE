package com.pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stepDefinition.BaseTest;
import com.utility.Util;

public class SearchBusTickets {

	Util util = new Util();

	public SearchBusTickets() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	@FindBy(xpath = "//span[@class='f-bold busFound']")
	private List<WebElement> isBusFound;
	public void isBusFound() throws InterruptedException {
		if(!(isBusFound.size() > 0)) {
			util.assertion(false, "No busses found.");
		}else {
			util.assertion(true, isBusFound.get(0).getText()+" found.");
		}
	}
	
	@FindBy(xpath="//div[@class='button view-seats fr']")
	private WebElement searchBusButton;
	public void searchBusButton() {
		util.click(searchBusButton);
	}
	
	@FindBy(xpath="//div[@class='button hide-seats fr']")
	private WebElement hideSeatsButton;
	public void hideSeatsButton() {
		util.explicit_wait_for_visibilityOfAllElements(hideSeatsButton);
	}
	public WebElement getHideSeatsButton() {
		return hideSeatsButton;
	}
	
	@FindBy(xpath="//canvas")
	private WebElement seatSelect;
	public void seatSelect() {
		util.click_canvas(seatSelect);
	}
	
	@FindBy(xpath="//span[text()='sholinganallur']/parent::div//preceding-sibling::div[@class='radio-css ']/div")
	private WebElement selectBoardingPointRadioBtn;
	public void selectBoardingPointRadioBtn() {
		util.click(selectBoardingPointRadioBtn);
	}
	
	@FindBy(xpath="//span[text()='Panjim']/parent::div//preceding-sibling::div[@class='radio-css ']/div")
	private WebElement selectDroppingPointRadioBtn;
	public void selectDroppingPointRadioBtn() {
		util.click(selectDroppingPointRadioBtn);
	}
	
	@FindBy(xpath="//button[@class='button continue inactive']")
	private WebElement proceedToBookBtn;
	public void clickProceedToBookBtn() {
		util.click(proceedToBookBtn);
	}
	
	@FindBy(className = "circle-tick")
	private List<WebElement> circleTick;
	public void verifyCircleTick() throws InterruptedException {
		if(!(circleTick.size() > 0)) {
			util.assertion(false, "Green color circle tick mark is not present");
		}else {
			util.assertion(true, isBusFound.get(0).getText()+" - Green color circle tick mark is present.");
		}
	}
	
	
	@FindBy(xpath="//div[@class='skipRet '][text()='REMOVE RETURN']")
	private WebElement removeReturnLink;
	public void clickRemoveReturnLink() {
		util.click(removeReturnLink);
	}
	
}
