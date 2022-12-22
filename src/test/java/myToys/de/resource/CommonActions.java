package myToys.de.resource;
	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.IOException;
	import java.security.Key;
	import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;
import myToys.de.repository.ProductPurchasePage;

public class CommonActions {
		public static WebDriver driver;
		public void chromelaunch(String url) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
			driver = new ChromeDriver(options);
			driver.get(url);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		public void screenshot(String path) throws IOException {
			TakesScreenshot sc = (TakesScreenshot)driver;
			File source = sc.getScreenshotAs(OutputType.FILE);
			File destination = new File(path);
			FileUtils.copyFile(source, destination);
		}
		public void doubleclick(WebElement element) {
			Actions a = new Actions(driver);
			a.doubleClick(element).build().perform();
		}
		public void contextclick() {
			Actions a = new Actions(driver);
			a.contextClick().build().perform();
		}
		public void scrollup(WebElement element,int index) {
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments["+index+"].scrollIntoView(true)",element);
		}
		public void scrolldown(WebElement element,int index) {
			JavascriptExecutor je = (JavascriptExecutor)driver;
			je.executeScript("arguments["+index+"].scrollIntoView(false)",element);
			}
		public void alertAccept() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		public void alertDismis() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}
		public void alertSendKeys(String values) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(values);
		}
		public void alertGetText() {
			Alert alert = driver.switchTo().alert();
			alert.getText();
		}
	    public void sendkeys(WebElement element,String values) {
			element.sendKeys(values);
		}
		public void click(WebElement element) {
			element.click();
		}
		public void sendKeysAndEnter(WebElement element,String values) {
			element.sendKeys(values,Keys.ENTER);
		}
		public void implicityWait(long seconds) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		}
		public void waitUntilPresenceOfElement(long seconds,String locator ) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		}
		public void waitUntilPresenceOfElements(long seconds,String locator ) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
		}
		public void waitUntilvisibleOfElement(long seconds,String locator ) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		}
		
	}