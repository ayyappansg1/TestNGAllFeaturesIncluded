#Author: ayyappansg1@gmail.com
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
Feature: Automation Testing Practise for All possible Actions

  Background: 
    When the user launched the Web application

  @smoke
  Scenario: Add and Delete an Element
    Given the user clicks the AddRemoveElement Button
    When the user clicks on Add element Button
    Then the User should be able to view the Delete button
    And the user clicks on Delete Button
    Then the user should not see the Delete Button

  @smoke
  Scenario: Basic Authentication Verify
    Given the user clicks the BasicAuth Button
    When the user passing "<username>" and  "<password>" and press enter
      | admin | admin |
    Then the user should be able to see the success message

  @smoke
  Scenario: Broken Images
    Given the user clicks the Broken image Button
    When the user landing on the landing page

  @smoke
  Scenario: Challenging Dom
    Given the user clicks the ChallengingDom Button
    When the User clicks the Random button from Side Menu
    And the user able to see the table fetch the 7th row
    Then the user should be able to fetch the row values

  @smoke
  Scenario: CheckBoxes
    Given the user clicks the Checkboxes Button
    When the User clicks the first Checkbox and second checkbox
    Then the user should see first checkbox is checked and second is unchecked

  @smoke
  Scenario: ContextMenu
    Given the user clicks the ContextMenu Button
    When the User rightClick inside the rectangle Box
    Then the user should see the alert

  @smoke
  Scenario: Disappearing Elements
    Given the user clicks the DisappearingElements Button
    When the User Refreshes the page
    Then the user should see decrease in count of elements

  @smoke
  Scenario: Drag and Drop
    Given the user clicks the DragAndDrop Button
    When the user click A and Drops in B
    Then the user shoud see the interchange in A and B

  @smoke
  Scenario: DropDown
    Given the user clicks the DropDown Button
    When the user click on Dropdown options and select "Option 2"
    Then the user shoud see the "Option 2" Selected

  @smoke
  Scenario: Dynamic Content
    Given the user clicks the DynamicContent Button
    When the user landed in the page and Gathers the text and refresh the page
    Then the user shoud not see the same content for every Refresh

  @smoke
  Scenario: Dynamic Controls
    Given the user clicks the DynamicControls Button
    When the user clicks on Checkbox and clicks Remove Button
    Then the user should not see checkbox and "It's gone!" Text should appear
    When the user clicks Add Button
    Then the user should see "It's back!"  text
    And the user verify the disabled textbox
    And the user clicks on enable button and then the user should be able to enter text
    Then the user shoud see "It's enabled!"
    And the user clicks on Disable button
    Then the user should see "It's disabled!"

  @smoke
  Scenario: Dynamic Loading
    Given the user clicks the DynamicLoading Button
    When the user clicks on Example1 and click start
    Then the user see "Hello World!" message
    And the user clicks on Example2 and click start
    Then the user should see "Hello World!" message again

  @smoke
  Scenario: EntryAd
    Given the user clicks the EntryAd Button
    When the user see Modal window and title should be "THIS IS A MODAL WINDOW"
    Then the user see close button and able to click

  @smoke
  Scenario: Exit Intent
    Given the user clicks the ExitIntent Button
    When the user is on exit intent page and moves cursor out of page
    Then the user should see modal window with title "THIS IS A MODAL WINDOW"

  @smoke
  Scenario: File Download
    Given the user clicks the FileDownload Button
    When the user clicks on random file to download
    Then the user should see the downloaded file in download folder

  @smoke
  Scenario: File Upload
    Given the user clicks the FileUpload Button
    When the user clicks choose File button and selects the file to be upload
    Then the user should see the success message "File Uploaded!" for File uploaded and file name should appear here

  @smoke
  Scenario: Floating Menu
    Given the user clicks the FloatingMenu Button
    When the user clicks on "HomeTab"
    Then the user should see the "home" in url
    When the user clicks on "NewsTab"
    Then the user should see the "news" in url
    When the user clicks on "contactTab"
    Then the user should see the "contact" in url
    When the user clicks on "aboutTab"
    Then the user should see the "about" in url

  @smoke
  Scenario: Forgot Password
    Given the user clicks the ForgotPassword Button
    When the user enter their email address and clicks retrive password
    Then the user should see the internal server error message

  @smoke
  Scenario: Form Authentication
    Given the user clicks the FormAuthentication Button
    When the user grabs username and password from webpage and clicks login button
    Then the user should see the login success message "You logged into a secure area!"

  @smoke
  Scenario: Frames
    Given the user clicks the Frames Button
    When the user clicks on nested frame
    Then the user should see the text of "MIDDLE" in middle frame
    And the user clicks on iframe
    Then the user should see the "Your content goes" text inside frame
