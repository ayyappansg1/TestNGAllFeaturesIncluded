package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import constants.Constants;
import driverManager.DriverManager;
import helper.LocalHelper;
import pages.HomePage;

public class FirstTest extends BaseClass {
	public HomePage homePage;
	List<String> useDevToolstoGrabAPINetworks;
	Map<String, String> tableValues;
	String downloadRandomFile;
	String clickAndUploadFile;

//	@BeforeClass
//	public void beforeClassForObjectInstantiation() throws MalformedURLException {
//	}

	@BeforeMethod
	public void launchApplication() throws MalformedURLException {
		homePage = new HomePage(getDriver());
		launchApplication(Constants.application_url);
	}

	@Test()
	public void verifyAddDeleteElementFunctionalities() {
		homePage.clickAddRemoveElementButton();
		homePage.clickAddElementButton();
		boolean verifyDeleteElementPresentOrNot = homePage.verifyDeleteElementPresentOrNot();
		Assert.assertTrue(verifyDeleteElementPresentOrNot, "ELement is Not displayed");
		homePage.clickDeleteElementButton();
		boolean verifyDeleteElementPresentOrNot2 = homePage.verifyDeleteElementPresentOrNot();
		Assert.assertFalse(verifyDeleteElementPresentOrNot2, "ELement is Still displaying");
	}

	@Parameters(value = { "username", "password" })
	@Test()
	public void verifyBasicAuthenticationVerify(String username, String password) throws AWTException {
		homePage.clickBasicAuthButton();
		homePage.sendValuesToTheAuthenticationBoxUsingRobot(username, password);
		boolean verifySuccessMessage = homePage.verifySuccessMessage();
		Assert.assertTrue(verifySuccessMessage, "Not authorised");
	}

	@Test()
	public void verifyBrokenImages() throws IOException {
		useDevToolstoGrabAPINetworks = LocalHelper.useDevToolstoGrabAPINetworks(DriverManager.getDriver());
		homePage.clickBrokenImageButton();
		int fetchBrokenImageLinks = homePage.fetchBrokenImageLinks(useDevToolstoGrabAPINetworks);
		Assert.assertTrue(fetchBrokenImageLinks > 0, "Count is Zero");
	}

	@Test()
	public void verifyChallengingDom() throws IOException {
		homePage.clickChallengingDomButton();
		homePage.clickRandomButton();
		tableValues = homePage.fetchColumnValues();
		Assert.assertFalse(tableValues.isEmpty(), "Map contains empty Value");
	}

	@Test()
	public void verifyCheckBoxes() throws IOException {
		homePage.clickCheckboxesButton();
		homePage.checkAllCheckboxOptions();
		boolean verifyFirstAndSecondBox = homePage.verifyFirstAndSecondBox();
		Assert.assertTrue(verifyFirstAndSecondBox, "Any one checkbox is irrelavant");
	}

	@Test()
	public void verifyContextMenu() throws IOException {
		homePage.clickContextMenuButton();
		homePage.rightClickOnRectangleBox();
		String handlingAlert = homePage.handlingAlert();
		Assert.assertTrue(handlingAlert.contains("You selected a context menu"), "Text is not matching");
	}

	@Test()
	public void verifyDisappearingElements() {
		homePage.clickDisappearingElementsButton();
		int compareTheCountings = homePage.compareTheCountings();
		Assert.assertTrue(compareTheCountings != 0);
	}

	@Test()
	public void verifyDragAndDrop() {
		homePage.clickDragAndDropButton();
		homePage.performDragDropInPage();
		String verifyVisibilityOfINterchangedBoxes = homePage.verifyVisibilityOfINterchangedBoxes();
		Assert.assertTrue(verifyVisibilityOfINterchangedBoxes.equals("B"), "A not droped in B");
	}

	@Test()
	public void verifyDropdown() {
		homePage.clickDropDownButton();
		homePage.selectGivenOptionFromDropdown("Option 2");
		String fetchSelectedOptionFromDropdown = homePage.fetchSelectedOptionFromDropdown();
		Assert.assertTrue(fetchSelectedOptionFromDropdown.equals("Option 2"), "Selected option is something else");
	}

	@Test()
	public void verifyDynamicContent() {
		homePage.clickDynamicContentButton();
		boolean dynamicContentsComparision = homePage.dynamicContentsComparision();
		Assert.assertFalse(dynamicContentsComparision, "Contents matching even after refresh");
		boolean dynamicContentsComparision2 = homePage.dynamicContentsComparision();
		Assert.assertFalse(dynamicContentsComparision2, "Contents matching even after refresh");
	}

	@Test()
	public void verifyDynamicControlsButton() {
		homePage.clickDynamicControlsButton();
		homePage.performActionsOnCheckBox();
		Assert.assertTrue(homePage.verifyGoneText("It's gone!"));
		homePage.performAddButtonAgain();
		Assert.assertTrue(homePage.verifyBackText("It's back!"));
		Assert.assertFalse(homePage.verifyTextBoxDisabled());
		homePage.clickEnableButton();
		Assert.assertTrue(homePage.verifyEnabledMessage("It's enabled!"));
		homePage.clickDisableButton();
		Assert.assertTrue(homePage.verifyDisabledMessage("It's disabled!"));
	}

	@Test()
	public void verifyEntryAd() {
		homePage.clickEntryAdButton();
		Assert.assertTrue(homePage.verifyModelTitle("THIS IS A MODAL WINDOW"));
		Assert.assertTrue(homePage.clickCloseButtonAndVerifyPopupClosed());

	}

	
	@Test(enabled = true)
	public void verifyExitIntent() throws AWTException {
		homePage.clickExitIntentButton();
		homePage.movingCursorAwayFromPage();
		Assert.assertTrue(homePage.verifyModalWindowOpened("THIS IS A MODAL WINDOW"));
	}

	@Test()
	public void verifyFileDownload() throws InterruptedException {
		homePage.clickFileDownloadButton();
		downloadRandomFile = homePage.downloadRandomFile();
		Assert.assertTrue(homePage.verifyDownloadedFile(downloadRandomFile), "file is not present");
	}

	@Test()
	public void verifyFileUpload() throws AWTException {
		homePage.clickFileUploadButton();
		clickAndUploadFile = homePage.clickAndUploadFile();
		Assert.assertTrue(homePage.verifyFilesUpload("File Uploaded!"), "Success Message not matches");
		Assert.assertTrue(homePage.verifyFileName(clickAndUploadFile), "Uploaded file name not matching");
	}

	@Test()
	public void verifyFloatingMenu() {
		homePage.clickFloatingMenuButton();
		homePage.clickHomeTab();
		Assert.assertTrue(homePage.verifyUrlForEachClickTab("home"), "Url not contain:" + "home");
		homePage.clickNewsTab();
		Assert.assertTrue(homePage.verifyUrlForEachClickTab("news"), "Url not contain:" + "news");
		homePage.clickcontactTab();
		Assert.assertTrue(homePage.verifyUrlForEachClickTab("contact"), "Url not contain:" + "contact");
		homePage.clickaboutTab();
		Assert.assertTrue(homePage.verifyUrlForEachClickTab("about"), "Url not contain:" + "about");
	}
	@Test()
	public void verifyForgotPassword() {
		homePage.clickForgotPasswordButton();
		homePage.enterPasswordAndClickRetrivePassword();
		Assert.assertTrue(homePage.verifyRetrivePasswordMessage(),"Invalid message");
	}
	@Test(groups = "sangar")
	public void verifyFormAuthentication() {
		homePage.clickFormAuthenticationButton();
		homePage.enterUsernameAndPasswordGrabbedFromwebPage();
		Assert.assertTrue( homePage.verifySuccessMessageAfterLogin("You logged into a secure area!"),"Invalid Login  message");
	}
	@Test(groups = "sangar")
	public void verifyFrames() {
		homePage.clickFramesButton();
		homePage.clickNestedFrame();
		Assert.assertTrue(
				homePage.getTextFromNestedFrameMiddle().contains("MIDDLE"),"Nested Frame Content mismatch");
		homePage.clickIFrame();
		Assert.assertTrue(homePage.getTextFromIFrame().contains("Your content goes"),"Iframe Content mismatch");
		
	}
	
}
