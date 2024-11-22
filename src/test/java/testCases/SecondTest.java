package testCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import constants.Constants;
import driverManager.DriverManager;
import pages.HomePage;
import pages.SecondPage;

public class SecondTest extends BaseClass {
	protected SecondPage secondPage;
	protected HomePage homePage;
	String downloadRandomFile;
//
//	@BeforeClass
//	public void beforeClassForObjectInstantiation() throws MalformedURLException {
//		secondPage = new SecondPage(getDriver());
//		homePage = new HomePage(getDriver());
//	}

	@BeforeMethod
	public void launchApplication() throws MalformedURLException {
		secondPage = new SecondPage(getDriver());
		homePage = new HomePage(getDriver());
		launchApplication(Constants.application_url);
	}

	@Test(groups = "sangar")
	public void verifyGeoLocation() {
		homePage.clickGeoLocationButton();
		secondPage.clickWhereAmIButton();
		Assert.assertTrue(
				secondPage.verifyBothLongtitudeAndLatitude("12.906197", "80.225775"),"Both Values are mismatch");
	}
	@Test()
	public void verifyHorizontalSlider() {
		homePage.clickHorizontalSliderButton();
		secondPage.performActionOnSlider();
		Assert.assertTrue(secondPage.verifySliderText(5),"Sliding not happened");
	}
	@Test()
	public void verifyHover() {
		homePage.clickHoversButton();
		Map<String,String> mp1=new LinkedHashMap<String, String>();
		mp1.put("first", "user1");
		Map<String,String> mp2=new LinkedHashMap<String, String>();
		mp2.put("second", "user2");
		Map<String,String> mp3=new LinkedHashMap<String, String>();
		mp3.put("third", "user3");
		List<Map<String,String>>asMap=new LinkedList<Map<String,String>>();
		asMap.add(mp1);
		asMap.add(mp2);
		asMap.add(mp3);
		Assert.assertTrue(secondPage.mouseHoverToEachImage(asMap),"Profile not matches");
	}
	@Test()
	public void verifyInfiniteScroll() throws InterruptedException {
		homePage.clickInfiniteScrollButton();
		secondPage.scrollFiveTimes(5);
	}
	@Test()
	public void verifyInputs() {
		homePage.clickInputsButton();
		secondPage.enterNumberAndClickAdd(245445);
	}
	@Test()
	public void verifyJQueryMenus() {
		homePage.clickJQueryUIMenusButton();
		secondPage.mouseHoverToEnabled();
		Assert.assertTrue(
				secondPage.verifyAfterMouseHoverToEnabledTab("Downloads", "Back to JQuery UI"),"Enabled Tab options mismatch");
		secondPage.clickOnJQueryBackUI();
		Assert.assertTrue(secondPage.verifyMenuHyperLink(),"Menu hyperLink is not visible");
		secondPage.clickMenuRedirectLink();
		secondPage.verifyRedirectionLink("menu");
		secondPage.mouseHoverToDownloadsPage();
		Assert.assertTrue(
				secondPage.verifyDownloadsTabOptions("PDF", "CSV", "Excel"),"Downloads tab not having all these three options");
		secondPage.clicksOnPdfOption();
		Assert.assertTrue(secondPage.verifyDownloadedFile(),"PDF file is not downloaded");
	}
	@Test()
	public void verifyJavaScriptAlerts() {
		homePage.clickJavaScriptAlertsButton();
		secondPage.clickJSAlertButton();
		Assert.assertTrue(secondPage.verifyJSAlertButton("You successfully clicked an alert"),"JS Alert text is not matching");
		secondPage.clickJSAlertConfirmButton();
		Assert.assertTrue(
				secondPage.verifyJSAlertButton("You clicked: Ok"),"JS Alert Confirm text is not matching");
		secondPage.clickJSAlertConfirmWithCancelButton();

		Assert.assertTrue(
				secondPage.verifyJSAlertButton("You clicked: Cancel"),"JS Alert Confirm text is not matching");
		secondPage.clickJSAlertPromptButton("sangar");
		Assert.assertTrue(secondPage.verifyJSAlertButton("You entered: sangar"),"JS Alert Prompt text is not matching");
	}
	@Test()
	public void verifyJavaScriptOnloadEventError() {
		homePage.clickJavaScriptOnloadEventErrorButton();
		Assert.assertTrue(
				secondPage.verifyUserLandingPageAfterClickJSOnloadError(),"User landed in unexpected page");
		Assert.assertTrue( secondPage.verifyJavascriptErrorOnPage("JavaScript error in the onload event"),"Error mismatch or not found");
	}
	@Test()
	public void verifyKeyPresses() {
		homePage.clickKeyPressesButton();
		List<String> asList = Arrays.asList("ENTER","TAB","SHIFT","CONTROL","SPACE");
		secondPage.pressKeysBasedOnGiven(asList);
		List<String> asList1 = Arrays.asList("ENTER","TAB","SHIFT","CONTROL","SPACE");
		Assert.assertTrue(secondPage.verifyKeysPressed(asList1),"List Mismatches");
	}
	@Test()
	public void verifyLargeAndDeepDom() {
		homePage.clickLargeAndDeepDOMButton();
		secondPage.fetchValueFromTable();
		Assert.assertTrue(secondPage.verifyingTheValueWithTableValue(6.22),"Value matching with exact value");
	}
	@Test()
	public void verifyMultipleWindows() {
		homePage.clickMultipleWindowsButton();
		secondPage.clickClickHereNewWindow();
		Assert.assertTrue(secondPage.switchToNewWindowAndGrabText("New Window"),"Value Mismatches in both");
	}
	@Test()
	public void verifyNestedFrames() {
		homePage.clickNestedFramesButton();
		Assert.assertTrue(secondPage.fetchingBottomFrameTextAndVerify("BOTTOM"),"Bottom Frame has issue");
		Assert.assertTrue(secondPage.fetchingRightFrameTextAndVerify("RIGHT"),"Right frame has issue");
	}
	@Test()
	public void verifyNotificationMessage() {
		homePage.clickNotificationMessageButton();
		secondPage.clickClickHereNotification();
		Assert.assertTrue(secondPage.verifyTheFirstNotificationMessage("Action successful","Action unsuccesful, please try again"),"First message not equal");
		secondPage.clickClickHereNotificationUntilNewMessageAppears();
		Assert.assertTrue(secondPage.verifyTheSecondNotification(),"second message not equal");
	}
	@Test()
	public void verifyRedirectLink() {
		homePage.clickRedirectLinkButton();
		secondPage.clickClickHereRedirectLinkbutton();
		Assert.assertTrue(secondPage.verifyURLAfterRedirectClick("status_codes"),"landed in incorrect url");
	}
	@Test()
	public void verifySecureFileDownload() throws AWTException, InterruptedException {
		homePage.clickSecurefiledownloadButton();
		secondPage.enterCredentialsUsingRobot();
		downloadRandomFile = homePage.downloadRandomFile();
		Assert.assertTrue(secondPage.checkDownloadedFileInLocal(downloadRandomFile),"file is not present");
	}
	@Test()
	public void verifyShadowDom() {
		homePage.clickShadowDomButton();
		Assert.assertTrue(secondPage.gettingTextFromFirstParagraphShadowDom("Let's have some different text!"),"first para has non matching text");
		Assert.assertTrue(secondPage.gettingTextFromSeconddParagraphShadowDom("Let's have some different text!", "In a list!"),"SecondPara not matching");
	}
	@Test()
	public void verifyShiftingContent() {
		homePage.clickShiftingContentButton();
		List<String> asList = Arrays.asList("Home","About","Contact Us","Portfolio","Gallery");
		Assert.assertTrue(secondPage.clickMenuElementAndVerifyTabs(asList),"Menus are mismatch");
		Assert.assertTrue(secondPage.clickHomeElementAndRedirectToHomePage(),"Not landed on home page");
		secondPage.clickAnImageButtonAndGetBeforeClickCssValue();
		Assert.assertFalse(secondPage.verifyImageMovedAfterReload(),"Image not moved to new location");
		secondPage.clickList();
		Assert.assertTrue(secondPage.compareContentsForEveryLoad(),"Content not changing dynamically");
	}
	@Test(groups = "sangar")
	public void verifySlowResources() throws URISyntaxException, IOException {
		homePage.clickSlowResourcesButton();
		Assert.assertTrue(secondPage.captureAndReturnUrls(503),"Status Code is not as expected");
	}
	@Test()
	public void verifySortableDataTables() {
		homePage.clickSortableDataTablesButton();
		Assert.assertTrue(secondPage.verifyLastNameFirstTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyFirstNameFirstTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyEmailFirstTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyDueFirstTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyWebSiteFirstTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyLastNameSecondTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyFirstNameSecondTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyEmailSecondTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyDueSecondTable(),"Mismatch after sorting");
		Assert.assertTrue(secondPage.verifyWebSiteSecondTable(),"Mismatch after sorting");
	}
	@Test()
	public void verifyStatusCodes() throws URISyntaxException, IOException {
		homePage.clickStatusCodesButton();
		Assert.assertTrue(secondPage.clickAndValidate200StatusCode(200),"Status Code is not as expected");
		Assert.assertTrue(secondPage.clickAndValidate301StatusCode(301),"Status Code is not as expected");
		Assert.assertTrue(secondPage.clickAndValidate404StatusCode(404),"Status Code is not as expected");
		Assert.assertTrue(secondPage.clickAndValidate500StatusCode(500),"Status Code is not as expected");
	}
	
	
}
