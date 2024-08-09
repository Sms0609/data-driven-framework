package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class SampleDataDrivenTest extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="sampleuser")
	public static void LoginTest2(String username, String password) throws InterruptedException 
	{
		
		System.out.println("Webpage load successfully");
		driver.findElement(By.xpath(loc.getProperty("user_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("password_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("submit_button"))).click();
		driver.findElement(By.xpath(loc.getProperty("logout_button"))).click();
		
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
