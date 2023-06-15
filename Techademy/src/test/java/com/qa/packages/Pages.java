package com.qa.packages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Pages {
	WebDriver driver;
	public Pages(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver2,60), this);
	}
	@FindBy(css="div.menu-primary-container>ul>li:nth-of-type(3)")
	WebElement contacts;
	public WebElement getContact() {
		return contacts;
	}
	@FindBy(id = "g3-name")
	WebElement name;
	public WebElement getName() {
		return name;
	}
	@FindBy(id = "g3-email")
	WebElement email;
	public WebElement getEmail() {
		return email;
	}
	@FindBy(id = "contact-form-comment-g3-message")
	WebElement message;
	public WebElement getMessage() {
		return message;
	}
	@FindBy(css = "button.wp-block-button__link.has-text-color.has-black-color")
	WebElement contactMe;
	public WebElement getContactme() {
		return contactMe;
	}

}