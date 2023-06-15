package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Page {
	WebDriver driver;
	public Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver2,60), this);
	}
	@FindBy(css = "div._3wFoIb.row")
	WebElement popup;
	public WebElement getPopup() {
		return popup;
	}
	@FindBy(css = "button._2KpZ6l._2doB4z")
	WebElement closePopup;
	public WebElement getClosepopup() {
		return closePopup;
	}
	@FindBy(css = "img._2xm1JU")
	WebElement flipkartlogo;
	public WebElement getFlipkartlogo() {
		return flipkartlogo;
	}
	@FindBy(css = "input._3704LK")
	WebElement search;
	public WebElement getSearch() {
		return search;
	}
	@FindAll(@FindBy(css= "div._4rR01T"))
	List<WebElement> products;
	public List<WebElement> getProducts() {
		return products;
	}
	@FindBy(css = "div._4rR01T:first-of-type")
	WebElement firstProduct;
	public WebElement getFirst() {
		return firstProduct;
	}
	@FindBy(css="span.B_NuCI")
	WebElement productPage;
	public WebElement getProductpage() {
		return productPage;
	}
	

}