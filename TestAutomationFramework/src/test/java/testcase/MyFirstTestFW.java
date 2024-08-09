package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class MyFirstTestFW extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="sampleuser")
	public static void LoginTest(String username, String password) throws InterruptedException 
	{
		
		System.out.println("Clicked successfully");
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		Thread.sleep(Duration.ofSeconds(5));
		
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	}
	
	/*@DataProvider(name="testdata")
	public Object[][] tData()
	{
		return new Object[][]
				{
					{"rc@gmail.com","testaut123456"},
					{"rcvtutail.com","testauto123"},
					{"datatestjava@gmail.com","testautomation123"},
					{"rcv@gmail.com","testautomate123"}
					
				};
	}*/
}
