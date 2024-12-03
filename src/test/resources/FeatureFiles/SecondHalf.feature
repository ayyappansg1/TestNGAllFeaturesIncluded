#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Second Half

  Background: 
    When the user launched the Web application

  @smoke
  Scenario: GeoLocation
    Given the user clicks the GeoLocation Button
    When the user clicks on WhereAmI button
    Then the user should see the Latitude "12.906197" and Longitude "80.225775"

  @smoke
  Scenario: Horizontal Slider
    Given the user clicks the HorizontalSlider Button
    When the user clicks and move the slider to last
    Then the user should see the range text as 5

  @smoke
  Scenario: Hovers
    Given the user clicks the Hovers Button
    When the user mouse hover to all three images
    Then the user should see names of <first> and <second> and <third> names as below
      | first | second | third |
      | user1 | user2  | user3 |

  @smoke
  Scenario: Infinite Scroll
    Given the user clicks the InfiniteScroll Button
    When the user scroll 5 times
    Then the user should see the contents

  @smoke
  Scenario: Inputs
    Given the user clicks the Inputs Button
    When the user Enters 245445 in the textbox and click increase button
    Then the user should see the count should be increased by one

  @smoke
  Scenario: Jquery menus
    Given the user clicks the JQueryUIMenus Button
    When the user mouse hover to enabled
    Then the user should see the "Downloads" and "Back to JQuery UI" tab
    And the user clicks on Back to JQuery ui tab and landed on respective page
    Then the user should see "Menu" hyperlink
    And the user clicks on it
    Then the user should redirect to menu page again
    And the user mouse hover to downloads tab
    Then the user should see "PDF" and "CSV" and "Excel" tab
    And the user clicks on pdf
    Then the user should be able to download sample pdf

  @smoke
  Scenario: JavaScript Alerts
    Given the user clicks the JavaScriptAlerts Button
    When the user clicks on click for JS alert
    Then the user should see "You successfully clicked an alert" in result
    And the user clicks on click for JS Confirm
    Then the user should be see "You clicked: Ok"
    And the user clicks on JS Confirm alert and clicks dismiss
    Then the user should be see the "You clicked: Cancel"
    And the user clicks on JS prompt alert and enters the "sangar" text
    Then the user should see prompt alert "You entered: sangar"

  @smoke
  Scenario: JavaScript onload event error
    Given the user clicks the JavaScriptOnloadEventError Button
    When the user clicks on the landing page
    Then the user should see the error message contains "JavaScript error in the onload event"

  @smoke
  Scenario: Key Presses
    Given the user clicks the KeyPresses Button
    When the user Enters different keyboard actions like "ENTER" "TAB" "SHIFT" "CONTROL" "SPACE"
    Then the user should see these texts "ENTER" "TAB" "SHIFT" "CONTROL" "SPACE" in UI

  @smoke
  Scenario: Large and Deep DOM
    Given the user clicks the LargeAndDeepDOM Button
    When the user fetches particular value from the table using proper xpath
    Then the user should see that value should be 6.22

  @smoke
  Scenario: multiple windows
    Given the user clicks the MultipleWindows Button
    When the user clicks the clickhere button
    Then the user should navigate to new window and "New Window" text

  @smoke
  Scenario: Nested Frames
    Given the user clicks the NestedFrames Button
    When the user on the landing page and validate bottom text "BOTTOM"
    Then the user on the topframe and should see right frame text "RIGHT"

  @smoke
  Scenario: Notification Message
    Given the user clicks the NotificationMessage Button
    When the user clicks Click here button
    Then the user should see "Action successful" or "Action unsuccesful, please try again" message
    And the user clicks again until new message appears not be same as above one
    Then the user should see opposite to previous one

 Scenario: Redirect Link
    Given the user clicks the RedirectLink Button
    When the user clicks Click here button
    Then the user on the "status_codes" url page

  @smoke
  Scenario: SecureFileDownload Link
    Given the user clicks the SecureFileDownload Button with scrollToLast
    When the user enters the credentials
    When the user clicks on random file to download
    Then the user should see the downloaded file in Local download folder

  @smoke
  Scenario: ShadowDom
    Given the user clicks the ShadowDom Button
    When the user Extracting text from first paragraph it should match with "Let's have some different text!"
    Then the user Extracting text from second paragraph it should match with "Let's have some different text!" and "In a list!"

  @smoke
  Scenario: Shifting Content
    Given the user clicks the ShiftingContent Button
    When the user clicks menu Element he should see Menus "Home" "About" "Contact Us" "Portfolio" "Gallery"
    And the user clicks the click home button and it should redirect to home page
    When the user clicks the An image element and clicks the Click here button
    And the user should be able to see the image moved to new location
    When the user clicks on list
    And the user should see lists dynamically changes for every refresh

  @smoke
  Scenario: SlowResources
    Given the user clicks the SlowResources Button
    When the user noticing the slowResourceAPI it should give 503

  @smoke
  Scenario: SortableDataTables
    Given the user clicks the SortableDataTables Button
    When the user clicks sorting in LastName table all the elements should be in sorting order from first table
    When the user clicks sorting in Firstname table all the elements should be in sorting order from first table
    When the user clicks sorting in Email table all the elements should be in sorting order from first table
    When the user clicks sorting in Due table all the elements should be in sorting order from first table
    When the user clicks sorting in WebSite table all the elements should be in sorting order from first table
    When the user clicks sorting in LastName table all the elements should be in sorting order from second table
    When the user clicks sorting in Firstname table all the elements should be in sorting order from second table
    When the user clicks sorting in Email table all the elements should be in sorting order from second table
    When the user clicks sorting in Due table all the elements should be in sorting order from second table
    When the user clicks sorting in WebSite table all the elements should be in sorting order from second table
@smoke
  Scenario: Status codes
    Given the user clicks the StatusCodes Button
    When the user clicks the 200 hyperlink api should return 200
    When the user clicks the 301 hyperlink api should return the 301 redirection
    When the user clicks the 404 hyperlink api should return 404 not found
    When the user clicks the 500 hyperlink api should return 500 server side issue
