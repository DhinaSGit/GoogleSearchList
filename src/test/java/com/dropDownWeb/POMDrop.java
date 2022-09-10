package com.dropDownWeb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.ReuseableMethods;
/**
 * 
 * @author Dhinakaran
 * @created 10-Sep-2022
 * @description Page Object Model for locators
 *
 */
public class POMDrop extends ReuseableMethods {

	public POMDrop() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='RNNXgb']//child::input")
	private WebElement searchBar;

	@FindBy(xpath = "//div[@class='gb_Vd gb_Xa gb_Kd']//child::iframe[@role='presentation']")
	private WebElement frame;

	@FindBy(xpath = "//div[@class='QlyBfb']//child::button[@aria-label='No thanks']")
	private WebElement noThanks;

	@FindBy(xpath = "(//li[@data-view-type='1']//child::b[contains(text(),' share price')])[1]")
	private WebElement sharePrice;
	
	@FindBy(xpath = "//div[@class='PZPZlf']//child::span[@jscontroller='B82lxb']")
	private WebElement price;

	/**
	 * 
	 * @return searchBar
	 */
	public WebElement getSearchBar() {
		return searchBar;
	}

	/**
	 * 
	 * @return sharePrice
	 */
	public WebElement getSharePrice() {
		return sharePrice;
	}

	/**
	 * 
	 * @return frame
	 */
	public WebElement getFrame() {
		return frame;
	}

	/**
	 * 
	 * @return noThanks
	 */
	public WebElement getNoThanks() {
		return noThanks;
	}

	/**
	 * 
	 * @return price
	 */
	public WebElement getPrice() {
		return price;
	}

}
