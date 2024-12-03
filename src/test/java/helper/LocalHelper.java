package helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v128.network.Network;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;

/**
 * Local helper class contains all Reusable action able methods with Wait
 * mechanism added
 */
public class LocalHelper {
	private static final Logger logger = LogManager.getLogger(LocalHelper.class);
//	private volatile static LocalHelper instance;
//	private LocalHelper() {}
//	public static LocalHelper getInstance() {
//		synchronized (LocalHelper.class) {
//			if(instance==null) {
//				instance=new LocalHelper();
//			}
//		}
//		return instance;
//	}

	long waitSeconds = 5;

	public void clickElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].scrollIntoView(true)", element);
		try {
			highLightElement(element,driver);
			element.click();
			logger.info("Clicked using Normal Click");
		} catch (ElementClickInterceptedException e) {
			ex.executeScript("arguments[0].click();", element);
			logger.info("Clicked using Javascript Executor");

		}catch(StaleElementReferenceException e) {
			element.click();
		}
	}

	public void scrollToLast(WebDriver driver) {
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public boolean verifyElement(WebElement element) {
		boolean status = false;
		try {
			if (element != null) {
				status = element.isDisplayed();
			} else {
				logger.info("Element is null.");
				status = false;
			}
		} catch (NoSuchElementException e) {
			logger.info("NoSuchElementException: Element not found.");
			status = false;
		} catch (TimeoutException e) {
			logger.info("TimeoutException: Element was not found within the time limit.");
			status = false;
		} catch (Exception e) {
			logger.info("Exception: An unexpected error occurred - " + e.getMessage());
			status = false;
		}
		return status;
	}

	public boolean verifyEnabledElement(WebElement element) {
		boolean status = false;
		try {
			if (element != null) {
				status = element.isEnabled();
			} else {
				logger.info("Element is null.");
				status = false;
			}
		} catch (NoSuchElementException e) {
			logger.info("NoSuchElementException: Element not found.");
			status = false;
		} catch (TimeoutException e) {
			logger.info("TimeoutException: Element was not found within the time limit.");
			status = false;
		} catch (Exception e) {
			logger.info("Exception: An unexpected error occurred - " + e.getMessage());
			status = false;
		}
		return status;
	}

	public void highLightElement(WebElement element,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].scrollIntoView(true)", element);
		ex.executeScript("arguments[0].setAttribute('style','border:3px solid:red');", element);

	}

	public void handlingAlert(WebDriver driver, String username, String password, String acceptOrDismiss) {
		try {
			Alert alert = driver.switchTo().alert();
			if (username != null) {
				alert.sendKeys(username + Keys.TAB);
				alert.sendKeys(password);
			}
			if (acceptOrDismiss.contains("accept")) {
				alert.accept();
			} else {
				alert.dismiss();
			}
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public void passingValuesInWindowPopup(String username, String password) throws AWTException {
		Robot robot = new Robot();
		Map<Character, Integer> keyEventMap = new HashMap<Character, Integer>();
		keyEventMap.put('A', KeyEvent.VK_A);
		keyEventMap.put('B', KeyEvent.VK_B);
		keyEventMap.put('C', KeyEvent.VK_C);
		keyEventMap.put('D', KeyEvent.VK_D);
		keyEventMap.put('E', KeyEvent.VK_E);
		keyEventMap.put('F', KeyEvent.VK_F);
		keyEventMap.put('G', KeyEvent.VK_G);
		keyEventMap.put('H', KeyEvent.VK_H);
		keyEventMap.put('I', KeyEvent.VK_I);
		keyEventMap.put('J', KeyEvent.VK_J);
		keyEventMap.put('K', KeyEvent.VK_K);
		keyEventMap.put('L', KeyEvent.VK_L);
		keyEventMap.put('M', KeyEvent.VK_M);
		keyEventMap.put('N', KeyEvent.VK_N);
		keyEventMap.put('O', KeyEvent.VK_O);
		keyEventMap.put('P', KeyEvent.VK_P);
		keyEventMap.put('Q', KeyEvent.VK_Q);
		keyEventMap.put('R', KeyEvent.VK_R);
		keyEventMap.put('S', KeyEvent.VK_S);
		keyEventMap.put('T', KeyEvent.VK_T);
		keyEventMap.put('U', KeyEvent.VK_U);
		keyEventMap.put('V', KeyEvent.VK_V);
		keyEventMap.put('W', KeyEvent.VK_W);
		keyEventMap.put('X', KeyEvent.VK_X);
		keyEventMap.put('Y', KeyEvent.VK_Y);
		keyEventMap.put('Z', KeyEvent.VK_Z);

		char[] usernameArray = username.toUpperCase().toCharArray();
		for (char c : usernameArray) {
			robot.keyPress(keyEventMap.get(c));
			robot.keyRelease(keyEventMap.get(c));
		}
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		char[] passwordArray = password.toUpperCase().toCharArray();
		for (char c : passwordArray) {
			robot.keyPress(keyEventMap.get(c));
			robot.keyRelease(keyEventMap.get(c));
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public String getTextContent(WebElement element,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public void fetchBrokenLinksUsingNaturalWidth(WebElement element) {
		element.getAttribute("src");
	}

	public static List<String> useDevToolstoGrabAPINetworks(WebDriver driver) {
		List<String> urls = new LinkedList<String>();
		if (driver instanceof ChromeDriver) {
			// logger.info("Inside ChromeDev Tool");
			ChromeDriver chromeDriver = (ChromeDriver) driver;
			DevTools devTools = chromeDriver.getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devTools.addListener(Network.requestWillBeSent(), request -> {
				 logger.info("URL Fetching"+request.getRequest().getUrl().toString());
				urls.add(request.getRequest().getUrl().toString());
			});
		} else if (driver instanceof EdgeDriver) {
			// logger.info("Inside edge Dev Tool");
			EdgeDriver edgeDriver = (EdgeDriver) driver;
			DevTools devTools = edgeDriver.getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
			devTools.addListener(Network.requestWillBeSent(), request -> {
				// logger.info("URL Fetching"+request.getRequest().getUrl().toString());
				urls.add(request.getRequest().getUrl());
			});
		}
		return urls;
	}

	public List<String> fetchOnlyImageUrls(List<String> urlList) {
		Consumer<String> consumer = (string -> {
			logger.info("First ULR is" + string);
		});
		urlList.forEach(consumer);
		return urlList.stream().filter(url -> url.contains("jpg")).collect(Collectors.toList());
	}

	public int returnBrokenImagesUrl(List<String> urlList) throws IOException {
		Consumer<String> consumer = (string -> {
			logger.info("Before Filtering Broken ULR is" + string);
		});
		urlList.forEach(consumer);
		List<String> urls = new LinkedList<String>();
		for (String string : urlList) {
			URL url = new URL(string);
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			openConnection.setRequestMethod("GET");
			openConnection.connect();
			if (openConnection.getResponseCode() != 200) {
				urls.add(string);
			}
		}
		Consumer<String> consumerAfter = (string -> {
			logger.info("After Filtering Broken ULR is" + string);
		});
		urls.forEach(consumerAfter);
		return urls.size();
	}

	public List<String> getAllTextContents(By elements,WebDriver driver) {
		List<String> li = new LinkedList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(elements, 1));
		List<WebElement> findElements = driver.findElements(elements);
		for (int i = 0; i < findElements.size() - 1; i++) {
			li.add(findElements.get(i).getText());
		}
		return li;
	}

	public List<String> getAllTextContents(List<WebElement> elements,WebDriver driver) {
		List<String> li = new LinkedList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		for (int i = 0; i < elements.size() - 1; i++) {
			li.add(elements.get(i).getText());
		}
		return li;
	}

	public List<String> getAllTextContentsPlain(List<WebElement> elements,WebDriver driver) {
		List<String> li = new LinkedList<String>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		for (int i = 0; i < elements.size(); i++) {
			li.add(elements.get(i).getText());
		}
		return li;
	}

	public Map<String, String> combineTwoListAndReturnMap(List<String> first, List<String> second) {
		Map<String, String> mp = new LinkedHashMap<String, String>();
		for (int i = 0; i < first.size(); i++) {
			mp.put(first.get(i), second.get(i));
		}
		return mp;
	}

	public void clickAllCheckboxes(List<WebElement> element) {
		for (WebElement webElement : element) {
			webElement.click();
		}
	}

	public void rightClickOnElement(WebElement rectangleBox, WebDriver driver) {
		Point location = rectangleBox.getLocation();
		Dimension size = rectangleBox.getSize();
		int x = location.getX() + size.width / 2;
		int y = location.getY() + size.height / 2;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(rectangleBox));
		Actions actions = new Actions(driver);
		actions.moveByOffset(x, y).contextClick().build().perform();
		// actions.contextClick().perform();
	}

	public String handlingAlertWithGetText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		logger.info("Alert Text is " + text);
		alert.accept();
		return text;
	}

	public void refreshTheCurrentPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public int refreshThePageWithPreviousElementsCount(List<WebElement> elements,WebDriver driver) {
		int beforeRefreshCount = elements.size();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
		// DriverManager.getDriver().navigate().refresh();
		int afterRefreshCount = elements.size();
		return beforeRefreshCount - afterRefreshCount;
	}

	public void performDragAndDrop(WebElement fromElement, WebElement toElement, WebDriver driver) {
		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(fromElement));
		actions.dragAndDrop(fromElement, toElement).build().perform();
	}

	public String extractTextFromParticularElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();

	}

	public void handlingDropdown(WebElement element, String option, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		select.selectByVisibleText(option);
	}

	public String selectedOptionFromDropdown(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		Select select = new Select(element);
		WebElement textFromElement = select.getFirstSelectedOption();
		return getTextContent(textFromElement,driver);
	}

	public boolean verifyCheckBoxChecked(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isSelected();
	}

	public void sendValue(WebElement inputTextBox, WebDriver driver, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(inputTextBox));
		try {
			inputTextBox.sendKeys(value);
		} catch (ElementNotInteractableException e) {
			try {
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(value);
			} catch (Exception m) {
				m.printStackTrace();
			}
		}
	}

	public void getBackToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void mouseHoverAwayFromPage(WebDriver driver) throws AWTException {
//		WebElement findElement = DriverManager.getDriver().findElement(By.cssSelector("#flash-messages"));
//		Actions actions=new Actions(driver);
//		actions.moveToElement(findElement,0,0).build().perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, 0);");
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
	}

	public String clickRandomElement(List<WebElement> allFiles,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOfAllElements(allFiles));
		WebElement webElement = allFiles.get(new Random().nextInt(allFiles.size()));
		String fileName = webElement.getText();
		logger.info("Before clicking file name is " + fileName);
		webElement.click();
		return fileName;
	}

	public boolean verifyFileName(String webFileName) {
		logger.info("Checking File");
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		logger.info("During click file:" + webFileName);
		logger.info("Actual Inside VerifyFileName Download Path:" + downloadPath);
		boolean fileExist = false;
		File file = new File(downloadPath);
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			String filename = file2.getName();
			if (filename.contains(webFileName.split("\\.")[0].split(" ")[0])) {
				logger.info("Local Filename is" + filename);
				logger.info("File Found Web name:" + webFileName);
				fileExist = true;
				break;
			}
		}
		return fileExist;
	}

	public String uploadFileUsingSendKeys(WebElement uploadButton) {
		// TODO Auto-generated method stub
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\upload";
		File file = new File(downloadPath);
		File[] listFiles = file.listFiles();
		uploadButton.sendKeys(listFiles[0].getAbsolutePath());
		return listFiles[0].getName();
	}

	public String uploadFileUsingRobot() throws AWTException {
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\upload";
		File file = new File(downloadPath);
		String firstFile = file.listFiles()[0].getAbsolutePath();
		StringSelection string = new StringSelection(firstFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return firstFile;
	}

	public boolean verifyUrlContainsExpectedText(String text, WebDriver driver) {
		return driver.getCurrentUrl().contains(text);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		// driver.switchTo().frame(element);
	}

	public void switchToParent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void slidingUsingMouseAction(WebElement element, WebElement element2,WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).moveToElement(element2).release().build().perform();
	}

	public void mouseHover(WebElement element,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void scrollNumberOfTimes(int num,WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < num; i++) {
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(3000);
		}
	}

	public void sendValueWithArrow(WebElement numberBox2) {
		numberBox2.sendKeys(Keys.ARROW_UP);
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void handlingAlertWithAllPossibleActions(String acceptOrDismiss, String enterText,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		if (enterText == null) {
			switch (acceptOrDismiss) {
			case "accept":
				alert.accept();
				break;
			case "dismiss":
				alert.dismiss();
				break;
			default:
				throw new IllegalArgumentException("invalid option to handle alert");
			}
		} else {
			alert.sendKeys(enterText);
			if (acceptOrDismiss.equals("accept"))
				alert.accept();
			else
				alert.dismiss();
		}
	}

	public List<String> pressKeysAndReturnTextFromChangeOccured(List<String> keysToPress, WebElement element,WebDriver driver) {
		logger.info("Keys to press size is:" + keysToPress.size());
		Actions action = new Actions(driver);
		Map<String, CharSequence> mp = new LinkedHashMap<String, CharSequence>();
		mp.put("TAB", Keys.TAB);
		mp.put("SPACE", Keys.SPACE);
		mp.put("CONTROL", Keys.CONTROL);
		mp.put("SHIFT", Keys.SHIFT);
		mp.put("ENTER", Keys.ENTER);
		List<String> list = new LinkedList<String>();
		for (String string : keysToPress) {
			Set<String> keySet = mp.keySet();
			for (String string2 : keySet) {
				logger.info("KeySet first" + string2);
				logger.info("And List first" + string);
				if (string.equals(string2)) {
					logger.info("Before clicking keys");
//					action.keyDown(mp.get(string2)).build().perform();;
//					action.keyUp(mp.get(string2)).build().perform();;
					action.sendKeys(mp.get(string2)).build().perform();
					;
					logger.info("After clicking keys");
					try {
						String text = element.getText();
						logger.info("Gathered text" + text);
						list.add(text.split(": ")[1]);
					} catch (StaleElementReferenceException e) {
						list.add(element.getText());
					}
					break;
				}
			}
		}
		logger.info("After elements stored:" + list.size());
		return list;
	}

	public String getParentWindow(WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		return parentWindow;
	}

	public void switchToAnotherWindow(String parentWindow,WebDriver driver) {
		Set<String> windowHandles =driver.getWindowHandles();
		logger.info("Now window count is:" + windowHandles.size());
		for (String windowId : windowHandles) {
			if (!windowId.equals(parentWindow)) {
				driver.switchTo().window(windowId);
				break;
			}
		}
	}

	public void switchToParentWindow(String parentWindow,WebDriver driver) {
		driver.switchTo().window(parentWindow);
	}

	public String getTextFromShadowDomAccessing(WebElement shadowHosts, String cssValueOfInside,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		//String shadowRoot=(String) js.executeScript(String.format("return arguments[0].shadowRoot.querySelector('%s').innerText", cssValueOfInside), shadowHost);
//		 //String firstPara = shadowRoot.getText();
//		 String script = "return arguments[0].shadowRoot.querySelector(arguments[1]).innerText";
//		    String shadowRootText = (String) js.executeScript(script, shadowHost, cssValueOfInside);
		WebElement shadowHost = driver.findElements(By.tagName("my-paragraph")).get(0);
//        WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);
//        WebElement paragraph = shadowRoot.findElement(By.cssSelector("p"));
//        String shadowText = paragraph.getText();
		Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
		WebElement paragraph = (WebElement) js.executeScript("return arguments[0].querySelector('p')", shadowRoot);
		String shadowText = paragraph.getText();

		logger.info("First paragra" + shadowText);
		return shadowText;
	}

	public List<String> getTextFromShadowDomAccessingMultiple(WebElement shadowRoots, String cssValueOfInside,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowHost =driver.findElements(By.tagName("my-paragraph")).get(1);
		Object shadowRoot = js.executeScript("return arguments[0].shadowRoot", shadowHost);
		List<WebElement> paragraph = (List<WebElement>) js.executeScript("return arguments[0].querySelectorAll('p')",
				shadowRoot);
		// List<WebElement>
		// elements=(List<WebElement>)js.executeScript(String.format("return
		// arguments[0].shadowRoot.querySelectorAll('%s')",cssValueOfInside),shadowRoot);
		List<String> list = new LinkedList<String>();
		for (WebElement webElement : paragraph) {
			String text = webElement.getText();
			logger.info("Second paragra" + text);
			list.add(text);
		}
		logger.info("List is :" + list);
		return list;
	}

	public String getTextFromShadowDomAccessingWithoutJS(WebElement shadowHost, By actualElement) {
		String firstPara = shadowHost.getShadowRoot().findElement(actualElement).getText();
		logger.info("First paragra" + firstPara);
		return firstPara;
	}

	public List<String> getTextFromShadowDomAccessingMultipleWithoutJS(WebElement shadowRoot, By actualElement) {
		List<WebElement> findElements2 = shadowRoot.getShadowRoot().findElements(actualElement);
		List<String> list = new LinkedList<String>();
		for (WebElement webElement : findElements2) {
			String text = webElement.getText();
			logger.info("Second paragra" + text);
			list.add(text);
		}
		return list;
	}

	public boolean compareTwoListAndCheckItContainsStringIn(List<String> first, List<String> second) {
		boolean status = false;
		for (int i = 0; i < first.size(); i++) {
			for (int j = 0; j < second.size(); j++) {
				if (second.get(j).contains(first.get(i))) {
					status = true;
				} else {
					status = false;
				}
			}
		}
		return status;
	}
	public String getCssValueFromParticularElement(WebElement element,String cssValue) {
		return element.getCssValue(cssValue);
	}
	public void goBack(WebDriver driver) {
		driver.navigate().back();
	}
	public void directlylandOnParticularUrl(String url,WebDriver driver) {
		driver.get(url);
	}
	public int hitParticularAPIUsingInbuiltJava(String url) throws URISyntaxException, IOException {
		URL url2 = new URL(url);
		HttpURLConnection connection=(HttpURLConnection)url2.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int responseCode = connection.getResponseCode();
		logger.info("Actual Status code is :"+responseCode);
		return responseCode;
	}

}
