package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	Page p;
	@Parameters({"Url"})
	@BeforeSuite
	public void setUp(String Url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		p = new Page(driver);
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	@AfterSuite
	public void tearDown() {
		driver.quit();
		
	}

}