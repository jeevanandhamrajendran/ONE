package com.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.pageFactory.HomePage;
import com.pageFactory.SearchBusTickets;
import com.runner.TestRunner;
import com.utility.Util;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedBus extends TestRunner{
	
	WebDriver driver;
	
	HomePage homePage = new HomePage();
	SearchBusTickets sbt= new SearchBusTickets();
	Util util = new Util();
	
	@Given("^Launch the url - \"([^\"]*)\"$")
	public void launch_the_url(String url) throws Throwable {
		driver = BaseTest.driver;
		util.launchURL(driver,url);
	}

	@When("^Select \"([^\"]*)\" in FROM textbox$")
	public void select_in_FROM_textbox(String from) throws Throwable {
		homePage.selectFromValue(from);
		
	}

	@When("^Select \"([^\"]*)\" in TO textbox$")
	public void select_in_TO_textbox(String to) throws Throwable {
		homePage.selectToValue(to);
	}

	@When("^Select \"([^\"]*)\" in ONWARD DATE$")
	public void select_in_ONWARD_DATE(String onwardDate) throws Throwable {
		homePage.onwardDate();
		homePage.onwardDay(onwardDate);
	}

	@When("^Select \"([^\"]*)\" in RETURN DATE$")
	public void select_in_RETURN_DATE(String returnDate) throws Throwable {
		homePage.returnDate();
		homePage.returnDay(returnDate);
	}

	@When("^Click Search Buses button$")
	public void click_Search_Buses_button() throws Throwable {
	   homePage.searchButton();
	}

	@Then("^Verify the following text -> \"([^\"]*)\" \\(Please make sure atleast one found\\)\\.$")
	public void verify_the_following_text_Please_make_sure_atleast_one_found(String arg1) throws Throwable {
	   util.explicit_wait_for_title_present("Search Bus Tickets");
	   sbt.isBusFound();
	}

	@Then("^Click VIEW SEATS button$")
	public void click_VIEW_SEATS_button() throws Throwable {
		 sbt.searchBusButton();
		 util.explicit_wait_for_visibilityOfAllElements(sbt. getHideSeatsButton());
	}

	@Then("^Select any one of the available seat\\.$")
	public void select_any_one_of_the_available_seat() throws Throwable {
		 //sbt.seatSelect();
		
		Thread.sleep(5000);
	}

	@Then("^Select Sholinganallur radio button for Boarding point$")
	public void select_Sholinganallur_radio_button_for_Boarding_point() throws Throwable {
	   sbt.selectBoardingPointRadioBtn();
	}

	@Then("^Select Panjim radio button for Dropping point$")
	public void select_Panjim_radio_button_for_Dropping_point() throws Throwable {
	   sbt.selectDroppingPointRadioBtn();
	}

	@Then("^Click the PROCEED TO BOOK button$")
	public void click_the_PROCEED_TO_BOOK_button() throws Throwable {
		sbt.clickProceedToBookBtn();
	}

	@Then("^Verify the tick mark icon present or not for ONWARD JOURNEY$")
	public void verify_the_tick_mark_icon_present_or_not_for_ONWARD_JOURNEY() throws Throwable {
	    sbt.verifyCircleTick();
	}

	@Then("^Click the REMOVE RETURN button$")
	public void click_the_REMOVE_RETURN_button() throws Throwable {
	    sbt.clickRemoveReturnLink();
	}

	@Then("^Verify Passenger Details form is displayed or not$")
	public void verify_Passenger_Details_form_is_displayed_or_not() throws Throwable {
	    
	}

	@Then("^Enter Enter Name, Gender and age under Passenger Information$")
	public void enter_Enter_Name_Gender_and_age_under_Passenger_Information() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Enter Email Id as XYZ@zmail\\.com$")
	public void enter_Email_Id_as_XYZ_zmail_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Enter Phone number as (\\d+)$")
	public void enter_Phone_number_as(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Uncheck the \"([^\"]*)\"$")
	public void uncheck_the(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Click PROCEED TO PAY button$")
	public void click_PROCEED_TO_PAY_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the PAYMENT OPTION page is visible\\.$")
	public void verify_the_PAYMENT_OPTION_page_is_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify Your Passenger name is correct or not what you have entered in previous page$")
	public void verify_Your_Passenger_name_is_correct_or_not_what_you_have_entered_in_previous_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify Seat number is correct or not what you have selected$")
	public void verify_Seat_number_is_correct_or_not_what_you_have_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Click back to navigate previous page$")
	public void click_back_to_navigate_previous_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Click back to navigate Home page$")
	public void click_back_to_navigate_Home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Unselect/clear \"([^\"]*)\" in FROM textbox$")
	public void unselect_clear_in_FROM_textbox(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Unselect/Clear \"([^\"]*)\" in TO textbox$")
	public void unselect_Clear_in_TO_textbox(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Unselect/Clear \"([^\"]*)\" in ONWARD DATE$")
	public void unselect_Clear_in_ONWARD_DATE(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
