package com.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Dhinakaran
 * @created 10-Sep-2022
 * @module Reusable methods of selenium
 *
 */
public class ReuseableMethods {

	public static WebDriver driver;

	/**
	 * 
	 * @param browser
	 * @param url
	 */
	public static void launchBrowser(String browser, String url) {

		// Browser launcher and load url

		switch (browser) {

		case "CHROME":

			// Chrome Browser

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			break;

		case "FIREFOX":

			// Firefox Browser

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			break;

		case "SAFARI":

			// Safari Browser

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			break;

		case "EDGE":

			// Edge Browser

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			break;

		case "IE":

			// Internet Explorer

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			break;

		case "OPERA":

			// Opera Browser

			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();

		default:
			break;
		}
	}

	/**
	 * 
	 * @param id
	 * @return element
	 */
	public static WebElement findElementID(String id) {

		// Find element using id

		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	/**
	 * 
	 * @param className
	 * @return element
	 */
	public static WebElement findElementClass(String className) {

		// Find element using className

		WebElement element = driver.findElement(By.className(className));
		return element;
	}

	/**
	 * 
	 * @param tagName
	 * @return element
	 */
	public static WebElement findElementTag(String tagName) {

		// Find element using tagName

		WebElement element = driver.findElement(By.tagName(tagName));
		return element;
	}

	/**
	 * 
	 * @param name
	 * @return element
	 */
	public static WebElement findElementName(String name) {

		// Find element using name

		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	/**
	 * 
	 * @param xpath
	 * @return element
	 */
	public static WebElement findElementXpath(String xpath) {

		// Find element using xpath

		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	/**
	 * 
	 * @param linkText
	 * @return element
	 */
	public static WebElement findElementLinkText(String linkText) {

		// Find element using LinkText

		WebElement element = driver.findElement(By.linkText(linkText));
		return element;
	}

	/**
	 * 
	 * @param cssSelector
	 * @return element
	 */
	public static WebElement findElementCSS(String cssSelector) {

		// Find element using css locator

		WebElement element = driver.findElement(By.cssSelector(cssSelector));
		return element;
	}

	/**
	 * 
	 * @param element
	 */
	public static void scrollIntoView(WebElement element) {

		// Scroll into view

		JavascriptExecutor jk = (JavascriptExecutor) driver;
		jk.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public static void screenshot(String filename) throws IOException {

		// Take screenshot

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "/Screenshots/" + filename + ".png");
		FileUtils.copyFile(src, des);
	}
}
