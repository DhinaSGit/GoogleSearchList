package com.dropDownWeb;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Endpoints.Endpoints;
import com.base.ReuseableMethods;
/**
 * 
 * @author Dhinakaran
 * @created 10-Sep-2022
 * @module Print share price of LIT if found in search suggestion
 *
 */
public class Project extends ReuseableMethods{
	
	static Logger logger = (Logger) LogManager.getLogger();

	String srch="LTI";
	
	@BeforeClass
	private void loadURL() {
		logger.info("Browser launched and url loaded");
		launchBrowser("CHROME", Endpoints.GOOGLE);
	}
	
	@Test
	private void seacrh() {
		POMDrop pd = new POMDrop();
		logger.info("Switching to frame");
		driver.switchTo().frame(pd.getFrame());
		logger.info("Handling frame");
		pd.getNoThanks().click();
		driver.switchTo().defaultContent();
		logger.info("Locating SearchBar and sendKeys");
		pd.getSearchBar().sendKeys(srch);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		logger.info("selecting the requirement using if block");
		if (pd.getSharePrice().isDisplayed()== true) {
			pd.getSharePrice().click();
			logger.info("Printing the requirment");
			System.out.println("Share Price of "+srch+" is: "+pd.getPrice().getText());
		}else {
			logger.info("Print the message");
			System.out.println("Requested search option is not listed");
		}
	}
	
	@AfterClass
	private void closeDriver() {
		logger.info("Close the browser");
		driver.close();
	}
}
