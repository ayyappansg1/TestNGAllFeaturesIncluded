package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import helper.LocalHelper;

public class HomePage extends LocalHelper{
	private static final Logger logger = LogManager.getLogger(HomePage.class);
	//private volatile static HomePage instance;
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	public static HomePage getInstance() {
//		if (instance == null) {
//			//synchronized (HomePage.class) {
//				if (instance == null) {
//					instance = new HomePage();
//				}
//			//}
//		}
//		return instance;
//	}
	@CacheLookup
	@FindBy(xpath = "//a[contains(@href,'add')]")
	private WebElement addRemoveElement;
	@FindBy(xpath = "//button[text()='Add Element']")
	private WebElement addElementButton;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteElementButton;
	@FindBy(xpath = "//a[text()='Basic Auth']")
	private WebElement basicAuthButton;
	@FindBy(css = "div p")
	private WebElement authSuccessMessage;
	@FindBy(xpath = "//a[text()='Broken Images']")
	private WebElement brokenImageButton;
	@FindBy(xpath = "//a[text()='Challenging DOM']")
	private WebElement challengingDomButton;
	@FindBy(xpath = "//a[@class='button alert']")
	private WebElement randomButton;
	@FindBy(xpath = "//a[text()='Checkboxes']")
	private WebElement checkBoxButton;
	@FindBy(xpath = "//a[text()='Context Menu']")
	private WebElement ContextMenuButton;
	@FindBy(xpath = "//a[text()='Disappearing Elements']")
	private WebElement disappearingButton;
	@FindBy(css = "#hot-spot")
	private WebElement rectangleBox;
	@FindBy(css = "#checkboxes input")
	private List<WebElement> checkBoxes;
	@FindBy(xpath = "//ul//li")
	private List<WebElement> pageHeaders;
	By seventhRow = By.xpath("//tr[5]//td");
	By rowHeader = By.xpath("//thead//th");
	@FindBy(css = "#column-a")
	private WebElement ABox;
	@FindBy(css = "#column-b")
	private WebElement BBox;
	@FindBy(xpath = "//a[text()='Drag and Drop']")
	private WebElement dragAndDropButton;
	@FindBy(xpath = "//a[text()='Dropdown']")
	private WebElement dropDownButton;
	@FindBy(id = "dropdown")
	private WebElement dropdownLocator;
	@FindBy(xpath = "//a[text()='Dynamic Content']")
	private WebElement dynamicContentButton;
	@FindBy(xpath = "//div[@id='content']//div[@class='large-10 columns']")
	private List<WebElement> dynamicContents;
	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	private WebElement dynamicControlButton;
	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	private WebElement dynamicLoadingButton;
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement inputCheckBox;
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeButton;
	@FindBy(xpath = "//button[text()='Add']//following::p")
	private WebElement goneText;
	@FindBy(xpath = "//button[text()='Remove']//following::p")
	private WebElement backText;
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputTextBox;
	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement enableButton;
	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement disableButton;
	@FindBy(xpath = "//button[text()='Enable']//following::p")
	private WebElement disabledMessage;
	@FindBy(xpath = "//button[text()='Disable']//following::p")
	private WebElement enabledMessage;
	@FindBy(xpath = "//a[contains(@href,'loading/1')]")
	private WebElement example1;
	@FindBy(xpath = "//a[contains(@href,'loading/2')]")
	private WebElement example2;
	@FindBy(xpath = "//button[text()='Start']")
	private WebElement startButton;
	@FindBy(xpath = "//div[@id='finish']/h4")
	private WebElement helloWorldMessage;
	@FindBy(xpath = "//a[text()='Entry Ad']")
	private WebElement entryAd;
	@FindBy(xpath = "//a[text()='Exit Intent']")
	private WebElement exitIntent;
	@FindBy(xpath = "//div[@class='modal-footer']//p")
	private WebElement closebutton;
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement modalTitle;
	@FindBy(css = ".example h3")
	private WebElement verificationPurpose;
	@FindBy(xpath = "//a[text()='File Download']")
	private WebElement fileDownload;
	@FindBy(xpath = "//a[text()='File Upload']")
	private WebElement fileUpload;
	@FindBy(xpath = "//a[text()='Floating Menu']")
	private WebElement floatingMenu;
	@FindBy(xpath = "//a[text()='Forgot Password']")
	private WebElement forgotPassword;
	@FindBy(xpath = "//a[text()='Form Authentication']")
	private WebElement formAuthentication;
	@FindBy(xpath = "//a[text()='Frames']")
	private WebElement frames;
	@CacheLookup
	@FindBy(xpath = "//a[text()='Geolocation']")
	private WebElement geoLocation;
	@FindBy(xpath = "//a[text()='Horizontal Slider']")
	private WebElement horizontalSlider;
	@FindBy(xpath = "//a[text()='Hovers']")
	private WebElement hovers;
	@FindBy(xpath = "//a[text()='Infinite Scroll']")
	private WebElement infiniteScroll;
	@FindBy(xpath = "//a[text()='Inputs']")
	private WebElement inputs;
	@FindBy(xpath = "//a[text()='JQuery UI Menus']")
	private WebElement jqueryUIMenus;
	@FindBy(xpath = "//a[text()='JavaScript Alerts']")
	private WebElement javaScriptAlerts;
	@FindBy(xpath = "//a[text()='JavaScript onload event error']")
	private WebElement javaScriptOnloadEventError;
	@FindBy(xpath = "//a[text()='Key Presses']")
	private WebElement keyPresses;
	@FindBy(xpath = "//a[text()='Large & Deep DOM']")
	private WebElement largeAndDeepDom;
	@FindBy(xpath = "//a[text()='Multiple Windows']")
	private WebElement multipleWindows;
	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFramees;
	@FindBy(xpath = "//a[text()='Notification Messages']")
	private WebElement notificationMessages;
	@FindBy(xpath = "//a[text()='Redirect Link']")
	private WebElement redirectLink;
	@FindBy(xpath = "//a[text()='Secure File Download']")
	private WebElement secureFileDownload;
	@FindBy(xpath = "//a[text()='Shadow DOM']")
	private WebElement shadowDom;
	@FindBy(xpath = "//a[text()='Shifting Content']")
	private WebElement shiftingContent;
	@FindBy(xpath = "//a[text()='Slow Resources']")
	private WebElement slowResources;
	@FindBy(xpath = "//a[text()='Sortable Data Tables']")
	private WebElement sortableDataTables;
	@FindBy(xpath = "//a[text()='Status Codes']")
	private WebElement statusCodes;
	@FindBy(xpath = "//a[text()='Typos']")
	private WebElement typos;
	@FindBy(xpath = "//a[text()='WYSIWYG Editor']")
	private WebElement WYSIWYGEditor;
	@FindBy(css = "#file-upload")
	private WebElement chooseFileButton;
	@FindBy(css = ".example a")
	private List<WebElement> allFiles;
	@FindBy(xpath = "//h3[text()='File Uploaded!']")
	private WebElement fileUploadedSuccessMessage;
	@FindBy(css = "#file-submit")
	private WebElement uploadButton;
	@FindBy(css = "#uploaded-files")
	private WebElement uploadedFileName;
	@FindBy(xpath = "//a[@href='#home']")
	private WebElement homeTab;
	@FindBy(xpath = "//a[@href='#news']")
	private WebElement newsTab;
	@FindBy(xpath = "//a[@href='#contact']")
	private WebElement contactTab;
	@FindBy(xpath = "//a[@href='#about']")
	private WebElement aboutTab;
	@FindBy(css = "body h1")
	private WebElement forgotPasswordMessage;
	@FindBy(css = "#email")
	private WebElement emailTextBox;
	@FindBy(xpath = "//i[text()='Retrieve password']")
	private WebElement retrivePassword;
	@FindBy(xpath = "//div[@class='flash success']")
	private WebElement loginSuccessMessage;
	@FindBy(css = "#username")
	private WebElement usernameBox;
	@FindBy(css = "#password")
	private WebElement passwordBox;
	@FindBy(css = ".radius")
	private WebElement loginButton;
	@FindBy(css = ".subheader em")
	private List<WebElement> usernamePassword;
	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFrame;
	@FindBy(xpath = "//a[text()='iFrame']")
	private WebElement iFrame;
	@FindBy(xpath = "//iframe")
	private WebElement insideIFrame;
	@FindBy(css = "#tinymce")
	private WebElement frameContent;
	@FindBy(xpath = "//frame[@src='/frame_top']")
	private WebElement mainFrame;
	@FindBy(xpath = "//frame[@src='/frame_middle']")
	private WebElement middleFrame;
	@FindBy(css = "#content")
	private WebElement middleContent;

	public void clickAddRemoveElementButton() {
		logger.info("Trying to Click Add Remove Element Button from the homepage");
		clickElement(addRemoveElement, driver);
		logger.info("Element Clicked SuccessFully");
	}

	public void clickAddElementButton() {
		logger.info("Trying to Click Add Element Button from the inside page");
		clickElement(addElementButton, driver);
		logger.info("Element Clicked SuccessFully");
	}

	public boolean verifyDeleteElementPresentOrNot() {
		logger.info("Verifying the Delete element button Disabled");
		return verifyElement(deleteElementButton);
	}

	public void clickDeleteElementButton() {
		logger.info("Trying to Click Delete Element Button from the inside page");
		clickElement(deleteElementButton, driver);
		logger.info("Element Clicked SuccessFully");
	}

	public void clickBasicAuthButton() {
		logger.info("Trying to Click Basic auth Button from the inside page");
		clickElement(basicAuthButton, driver);
	}

	public void sendValuesToTheAuthenticationBoxUsingRobot(String username, String password) throws AWTException {
		logger.info("Trying to Enter the Username and password");
		passingValuesInWindowPopup(username, password);
	}

	public void sendValuesToTheAuthenticationBox(String username, String password) {
		logger.info("Trying to Enter the Username and password");
		handlingAlert(driver, username, password, "accept");
	}

	public boolean verifySuccessMessage() {
		logger.info("Grabing success Message");
		String textContent = getTextContent(authSuccessMessage,driver);
		return textContent.contains("Congratulations! You must have");
	}

	public void clickBrokenImageButton() {
		logger.info("Trying to Click Broken image Button from the inside page");
		clickElement(brokenImageButton, driver);
	}

	public int fetchBrokenImageLinks(List<String> useDevToolstoGrabAPINetworks) throws IOException {
		List<String> fetchOnlyImageUrls = fetchOnlyImageUrls(useDevToolstoGrabAPINetworks);
		return returnBrokenImagesUrl(fetchOnlyImageUrls);
	}

	public void clickChallengingDomButton() {
		logger.info("Trying to Click Random Button from the inside page");
		clickElement(challengingDomButton, driver);
	}

	public void clickRandomButton() {
		logger.info("Trying to Click Random Button from the inside page");
		clickElement(randomButton, driver);
	}

	public Map<String, String> fetchColumnValues() {
		logger.info("Trying to Fetch row Values");
		List<String> seventhRowValues = getAllTextContents(seventhRow,driver);
		List<String> rowHeaderValues = getAllTextContents(rowHeader,driver);
		Map<String, String> combineTwoListAndReturnMap = combineTwoListAndReturnMap(rowHeaderValues, seventhRowValues);
		Set<Entry<String, String>> entrySet = combineTwoListAndReturnMap.entrySet();
		for (Entry<String, String> entry : entrySet) {
			logger.info(entry);
		}
		return combineTwoListAndReturnMap;
	}

	public void clickCheckboxesButton() {
		logger.info("Trying to Click Checkboxes Button from the inside page");
		clickElement(checkBoxButton, driver);
	}

	public void checkAllCheckboxOptions() {
		logger.info("Trying to Click All the checkboxes");
		clickAllCheckboxes(checkBoxes);
	}

	public boolean verifyFirstAndSecondBox() {
		boolean flag = false;
		for (WebElement webElement : checkBoxes) {
			if (webElement.isSelected()) {
				flag = true;
			}
		}
		return flag;
	}

	public void clickContextMenuButton() {
		logger.info("Trying to Click Checkboxes Button from the inside page");
		clickElement(ContextMenuButton, driver);
	}

	public void rightClickOnRectangleBox() {
		rightClickOnElement(rectangleBox, driver);
	}

	public String handlingAlert() {
		return handlingAlertWithGetText(driver);
	}

	public void clickDisappearingElementsButton() {
		logger.info("Trying to Click Disappearing Button from the inside page");
		clickElement(disappearingButton, driver);
	}

	public int compareTheCountings() {
		return refreshThePageWithPreviousElementsCount(pageHeaders,driver);
	}

	public void clickDragAndDropButton() {
		logger.info("Trying to Click Drog and Drop Button from the Home page");
		clickElement(dragAndDropButton, driver);
	}

	public void performDragDropInPage() {
		logger.info("Dragging and dropping box A to B");
		performDragAndDrop(ABox, BBox, driver);

	}

	public String verifyVisibilityOfINterchangedBoxes() {
		return extractTextFromParticularElement(ABox, driver);
	}

	public void clickDropDownButton() {
		logger.info("Trying to Click DropDown Button from the Home page");
		clickElement(dropDownButton, driver);
	}

	public void selectGivenOptionFromDropdown(String option) {
		logger.info("Selecting particular Option From Dropdown");
		handlingDropdown(dropdownLocator, option, driver);
	}

	public String fetchSelectedOptionFromDropdown() {
		logger.info("Fetching Selected Dropdown option");
		return selectedOptionFromDropdown(dropdownLocator, driver);
	}

	public void clickDynamicContentButton() {
		logger.info("Trying to Click dynamicContentButton Button from the Home page");
		clickElement(dynamicContentButton, driver);
	}

	public boolean dynamicContentsComparision() {
		List<String> allTextContents1 = getAllTextContents(dynamicContents,driver);
		refreshTheCurrentPage(driver);
		List<String> allTextContents2 = getAllTextContents(dynamicContents,driver);
		return allTextContents1.contains(allTextContents2);
	}

	public void clickDynamicControlsButton() {
		logger.info("Trying to Click dynamicControlButton Button from the Home page");
		clickElement(dynamicControlButton, driver);
	}

	public void performActionsOnCheckBox() {
		logger.info("Click Checkbox");
		clickElement(inputCheckBox, driver);
		Assert.assertTrue(verifyCheckBoxChecked(inputCheckBox, driver));
		logger.info("Click Remove Button");
		clickElement(removeButton, driver);
	}

	public boolean verifyGoneText(String text) {
		logger.info("Verify Gone Text");
		return getTextContent(goneText,driver).equalsIgnoreCase(text);
	}

	public void performAddButtonAgain() {
		logger.info("Click Add Button");
		clickElement(addButton, driver);
	}

	public boolean verifyBackText(String text) {
		logger.info("Verify Back Text");
		return getTextContent(backText,driver).equalsIgnoreCase(text);
	}

	public boolean verifyTextBoxDisabled() {
		logger.info("Verify Text Box disabled");
		return verifyEnabledElement(inputTextBox);
	}

	public void clickEnableButton() {
		logger.info("Trying to Click Enable Button from the Home page");
		clickElement(enableButton, driver);
		sendValue(inputTextBox, driver, "SANGAR");
	}

	public boolean verifyEnabledMessage(String text) {
		logger.info("Verifying Enabled Message");
		return getTextContent(enabledMessage,driver).equals(text);
	}

	public void clickDisableButton() {
		logger.info("Trying to Click Disable Button from the Home page");
		clickElement(disableButton, driver);
	}

	public boolean verifyDisabledMessage(String text) {
		logger.info("Verifying Disabled Message");
		return getTextContent(disabledMessage,driver).equals(text);
	}

	public void clickDynamicLoadingButton() {
		logger.info("Trying to Click dynamicLoadingButton Button from the Home page");
		clickElement(dynamicLoadingButton, driver);
	}

	public void clickElement1WithActions() {
		logger.info("Trying to Click Example1");
		clickElement(example1, driver);
		clickElement(startButton, driver);
	}

	public boolean verifyHelloWorldMessage(String text) {
		logger.info("Fetch HeloWorld text");
		return getTextContent(helloWorldMessage,driver).equals(text);
	}

	public void clickElement2WithActions() {
		logger.info("Go back to main page");
		getBackToPreviousPage(driver);
		logger.info("Trying to Click Example2");
		clickElement(example2, driver);
		clickElement(startButton, driver);
	}

	public void clickEntryAdButton() {
		logger.info("Trying to Click EntryAd Button from the Home page");
		clickElement(entryAd, driver);
	}

	public boolean verifyModelTitle(String text) {
		logger.info("Model box opened");
		return getTextContent(modalTitle,driver).contains(text);
	}

	public boolean clickCloseButtonAndVerifyPopupClosed() {
		clickElement(closebutton, driver);
		return verifyElement(verificationPurpose);
	}

	public void clickExitIntentButton() {
		logger.info("Trying to Click ExitIntent Button from the Home page");
		clickElement(exitIntent, driver);
	}

	public void movingCursorAwayFromPage() throws AWTException {
		logger.info("Cursor move away");
		mouseHoverAwayFromPage(driver);
	}

	public boolean verifyModalWindowOpened(String text) {
		logger.info("Checking Model Window Opened");
		return getTextContent(modalTitle,driver).contains(text);
	}

	public void clickFileDownloadButton() {
		logger.info("Trying to Click File Download Button from the Home page");
		clickElement(fileDownload, driver);
	}

	public void clickFileUploadButton() {
		logger.info("Trying to Click File Upload Button from the Home page");
		clickElement(fileUpload, driver);
	}

	public void clickFloatingMenuButton() {
		logger.info("Trying to Click Floating Menu Button from the Home page");
		clickElement(floatingMenu, driver);
	}

	public void clickForgotPasswordButton() {
		logger.info("Trying to Click Forgot password Button from the Home page");
		clickElement(forgotPassword, driver);
	}

	public void clickFormAuthenticationButton() {
		logger.info("Trying to Click Form Authenitication Button from the Home page");
		clickElement(formAuthentication, driver);
	}

	public void clickFramesButton() {
		logger.info("Trying to Click frame Button from the Home page");
		clickElement(frames, driver);
	}

	public void clickGeoLocationButton() {
		logger.info("Trying to Click GeoLocation Button from the Home page");
		clickElement(geoLocation, driver);
	}

	public void clickHorizontalSliderButton() {
		logger.info("Trying to Click Horizontal Slider Button from the Home page");
		clickElement(horizontalSlider, driver);
	}

	public void clickHoversButton() {
		logger.info("Trying to Click Hovers Button from the Home page");
		clickElement(hovers, driver);
	}

	public void clickInfiniteScrollButton() {
		logger.info("Trying to Click InfiniteScroll Button from the Home page");
		clickElement(infiniteScroll, driver);
	}

	public void clickInputsButton() {
		logger.info("Trying to Click Inputs Button from the Home page");
		clickElement(inputs, driver);
	}

	public void clickJQueryUIMenusButton() {
		logger.info("Trying to Click JQueryUIMenus Button from the Home page");
		clickElement(jqueryUIMenus, driver);
	}

	public void clickJavaScriptAlertsButton() {
		logger.info("Trying to Click JavaScript Alerts Button from the Home page");
		clickElement(javaScriptAlerts, driver);
	}

	public void clickJavaScriptOnloadEventErrorButton() {
		logger.info("Trying to Click JavaScript Alerts OnLoadEvent error from the Home page");
		clickElement(javaScriptOnloadEventError, driver);
	}

	public void clickKeyPressesButton() {
		logger.info("Trying to Click KeyPresses from the Home page");
		clickElement(keyPresses, driver);
	}

	public void clickLargeAndDeepDOMButton() {
		logger.info("Trying to Click Large and Deep from the Home page");
		clickElement(largeAndDeepDom, driver);
	}

	public void clickMultipleWindowsButton() {
		logger.info("Trying to Click MultipleWindows from the Home page");
		clickElement(multipleWindows, driver);
	}

	public void clickNestedFramesButton() {
		logger.info("Trying to Click NestedFrames from the Home page");
		clickElement(nestedFramees, driver);
	}

	public void clickNotificationMessageButton() {
		logger.info("Trying to Click NotificationMessages from the Home page");
		clickElement(notificationMessages, driver);
	}

	public void clickRedirectLinkButton() {
		logger.info("Trying to Click RedirectLink from the Home page");
		clickElement(redirectLink, driver);
	}

	public void clickSecurefiledownloadButton() {
		logger.info("Trying to Click SecureFileDownload from the Home page");
		scrollToLast(driver);
		clickElement(secureFileDownload, driver);
	}

	public void clickShadowDomButton() {
		logger.info("Trying to Click ShaodwDom from the Home page");
		clickElement(shadowDom, driver);
	}

	public void clickShiftingContentButton() {
		logger.info("Trying to Click Shifting Content from the Home page");
		clickElement(shiftingContent, driver);
	}

	public void clickSlowResourcesButton() {
		useDevToolstoGrabAPINetworks(driver);
		logger.info("Trying to Click SlowResourcesfrom the Home page");
		clickElement(slowResources, driver);
	}

	public void clickSortableDataTablesButton() {
		logger.info("Trying to Click SortableDataTables the Home page");
		clickElement(sortableDataTables, driver);
	}

	public void clickStatusCodesButton() {
		logger.info("Trying to Click statusCodes the Home page");
		clickElement(statusCodes, driver);
	}

	public void clickTyposButton() {
		logger.info("Trying to Click Typos the Home page");
		clickElement(typos, driver);
	}

	public void clickWYSIWYGEditorButton() {
		logger.info("Trying to Click WYSIWYGEditor from the Home page");
		clickElement(WYSIWYGEditor, driver);
	}

	public String downloadRandomFile() {
		logger.info("trying to click random file");
		return clickRandomElement(allFiles,driver);
	}

	public boolean verifyDownloadedFile(String fileName) throws InterruptedException {
		logger.info("Fetching File name");
		Thread.sleep(5000);
		return verifyFileName(fileName);
	}

	public void selectButton() {
		logger.info("Trying to Click WYSIWYGEditor from the Home page");
		clickElement(WYSIWYGEditor, driver);
	}

	public String clickAndUploadFile() throws AWTException {
		logger.info("Clicking File upload Button");
		String uploadFileUsingSendKeys = uploadFileUsingSendKeys(chooseFileButton);
		// String uploadFileUsingRobot =
		// uploadFileUsingRobot();
		clickElement(uploadButton, driver);
		return uploadFileUsingSendKeys;
	}

	public boolean verifyFilesUpload(String successMessage) {
		logger.info("Verifying the success message");
		return getTextContent(fileUploadedSuccessMessage,driver).contains(successMessage);
	}

	public boolean verifyFileName(String fileName) {
		logger.info("Verifying the uploaded File");
		return getTextContent(uploadedFileName,driver).contains(fileName);
	}

	public void clickHomeTab() {
		logger.info("Trying to HomeTab");
		clickElement(homeTab, driver);
	}

	public void clickNewsTab() {
		logger.info("Trying to NewsTab");
		clickElement(newsTab, driver);
	}

	public void clickcontactTab() {
		logger.info("Trying to contactTab");
		clickElement(contactTab, driver);
	}

	public void clickaboutTab() {
		logger.info("Trying to aboutTab");
		clickElement(aboutTab, driver);
	}

	public boolean verifyUrlForEachClickTab(String tab) {
		return verifyUrlContainsExpectedText(tab, driver);
	}

	public void enterPasswordAndClickRetrivePassword() {
		logger.info("Enter Email");
		sendValue(emailTextBox, driver,
				new Faker().name().firstName() + "@yopmail.com");
		clickElement(retrivePassword, driver);
	}

	public boolean verifyRetrivePasswordMessage() {
		return getTextContent(forgotPasswordMessage,driver).contains("Internal Server");
	}

	public void enterUsernameAndPasswordGrabbedFromwebPage() {
		logger.info("Grab username and password from web page");
		List<String> allTextContents = getAllTextContentsPlain(usernamePassword,driver);
		sendValue(usernameBox, driver, allTextContents.get(0));
		sendValue(passwordBox, driver, allTextContents.get(1));
		logger.info("Cick  Login button");
		clickElement(loginButton, driver);
	}

	public boolean verifySuccessMessageAfterLogin(String message) {
		String textContent = getTextContent(loginSuccessMessage,driver);
		logger.info("Text content from web page:" + textContent);
		logger.info("Feature file content:" + message);
		return textContent.contains(message);
	}

	public void clickNestedFrame() {
		clickElement(nestedFrame, driver);
	}

	public void clickIFrame() {
		getBackToPreviousPage(driver);
		clickElement(iFrame, driver);
	}

	public String getTextFromIFrame() {
		switchToFrame(driver, insideIFrame);
		String textContent = getTextContent(frameContent,driver);
		switchToParent(driver);
		return textContent;
	}

	public String getTextFromNestedFrameMiddle() {
		switchToFrame(driver, mainFrame);
		switchToFrame(driver, middleFrame);
		String textContent = getTextContent(middleContent,driver);
		switchToParent(driver);
		return textContent;
	}

}
