package testScript;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.qa.packages.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	protected WebDriver driver;
	Pages p;
	@Parameters({"Url"})
	@BeforeSuite
	public void setUp(String Url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		p = new Pages(driver);
		driver.manage().window().maximize();
		driver.get(Url);
	
	}
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}