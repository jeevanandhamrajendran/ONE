Feature: Automating RedBus feature

@redbus
Scenario: Booking Bus Ticket 1
Given Launch the url - "https://www.redbus.in/"
When Select "Koyambedu, Chennai" in FROM textbox
And Select "Goa" in TO textbox
And Select "25-Feb-2020" in ONWARD DATE
#And Select "26-Feb-2020" in RETURN DATE 
And Click Search Buses button
Then Verify the following text -> "XX Buses found" (Please make sure atleast one found). 
#And Click VIEW SEATS button
#And Select any one of the available seat.
#And Select Sholinganallur radio button for Boarding point
#And Select Panjim radio button for Dropping point
#And Click the PROCEED TO BOOK button
#Then Verify the tick mark icon present or not for ONWARD JOURNEY
#And Click the REMOVE RETURN button
#Then Verify Passenger Details form is displayed or not
#And Enter Enter Name, Gender and age under Passenger Information
#And Enter Email Id as XYZ@zmail.com
#And Enter Phone number as 1122334455
#And Uncheck the "Send booking details and updates on watsapp number"
#And Click PROCEED TO PAY button
#Then Verify the PAYMENT OPTION page is visible.
#Then Verify Your Passenger name is correct or not what you have entered in previous page
#Then Verify Seat number is correct or not what you have selected
#And Click back to navigate previous page
#And Click back to navigate Home page
#And Unselect/clear "Koyambedu, Chennai" in FROM textbox
#And Unselect/Clear "Goa (All Locations)" in TO textbox
#And Unselect/Clear "19-Feb-2020" in ONWARD DATE
#Then Close the browser


@redbus
Scenario: Launching yahoo mail 
Given Launch the url - "https://in.yahoo.com/"

@redbus
Scenario:Launching yahoo mail 2
Given Launch the url - "https://in.yahoo.com/"

@redbus @Smoke1
Scenario: Redbus booking
Given Launch the url - "https://www.redbus.in/"
When Select "Koyambedu, Chennai" in FROM textbox
And Select "Karur" in TO textbox
And Select "23-Feb-2020" in ONWARD DATE
#And Select "26-Feb-2020" in RETURN DATE 
And Click Search Buses button
Then Verify the following text -> "XX Buses found" (Please make sure atleast one found). 
#And Click VIEW SEATS button
#And Select any one of the available seat.
#And Select Sholinganallur radio button for Boarding point
#And Select Panjim radio button for Dropping point
#And Click the PROCEED TO BOOK button
#Then Verify the tick mark icon present or not for ONWARD JOURNEY
#And Click the REMOVE RETURN button