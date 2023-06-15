package com.qa.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario2 extends TestBase {
	@Test(priority=0)
	public void pop_up_Verification() {
		if(p.getPopup().isDisplayed()) {
			p.getClosepopup().click();
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false,"pop up not closed");
		}
		
	}
	@Test(priority =2, dependsOnMethods = "pop_up_Verification")
	public void flipkartLogo() {
		if(p.getFlipkartlogo().isDisplayed()) {
			Assert.assertTrue(true,"Flipkart logo is present");
			int logoLoc = p.getFlipkartlogo().getLocation().getX();
			if(logoLoc<500) {
				Assert.assertTrue(true,"Logo is on left side");
			}else {
				Assert.assertTrue(false,"Logo is not left side");
			}
		}else {
			Assert.assertTrue(false,"Flipkart logo is not present");
		}
	}
	@Test(priority = 3, dependsOnMethods = "flipkartLogo")
	public void searchItem() {
		p.getSearch().sendKeys("iphone 14");
		p.getSearch().sendKeys(Keys.ENTER);
		System.out.println(p.getProducts().size());
		String firstItem = p.getFirst().getText();
		p.getFirst().click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> li = handler.iterator();
		String ParentHandleId = li.next();
		String ChildHandleId = li.next();
		driver.switchTo().window(ChildHandleId);
		String selectedFirstItemTitle = driver.getTitle();
		if(driver.getPageSource().contains(firstItem)|| selectedFirstItemTitle.contains("APPLE iPhone 14 (Midnight, 128 GB)")) {
			Assert.assertTrue(true,"Navigated to product page");
		}else {
			Assert.assertTrue(false,"Not Navigated to product page");
		}
	}
}

