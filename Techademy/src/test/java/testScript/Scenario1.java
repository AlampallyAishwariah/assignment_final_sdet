package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario1 extends Testbase{
	@Test(priority =0)
	public void pageTitle() {
		Assert.assertEquals("Want to practice test automation? Try these demo sites! | Automation Panda",driver.getTitle());
		}
	@Test(priority = 1,dependsOnMethods = "pageTitle" )
	public void contactPage() {
		p.getContact().click();
		Assert.assertEquals("Contact | Automation Panda", driver.getTitle());
		p.getName().sendKeys("Sample");
		p.getEmail().sendKeys("sample@gmail.com");
		p.getMessage().sendKeys("Hi");
		p.getContactme().click();
		if(driver.getPageSource().contains("Your message has been sent")) {
			Assert.assertTrue(true,"submitted form successfully");
		}else {
			Assert.assertTrue(false,"Form not submitted successfully");
		}
	}
}