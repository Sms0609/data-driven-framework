package testcase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSdata;

public class UserCreationDDT extends BaseTest{

	@Test(dataProviderClass=ReadXLSdata.class,dataProvider="sampleusercreation")
	
	//same name as excel sheet
	public static void UserCreation(String username, String password) throws InterruptedException 
	{
		
		System.out.println("Webpage load successfully");
		driver.findElement(By.xpath(xpathloc.getProperty("signup"))).click();
		
		Thread.sleep(Duration.ofSeconds(2));
		
		driver.findElement(By.xpath(xpathloc.getProperty("signup_username"))).sendKeys(username);
		driver.findElement(By.xpath(xpathloc.getProperty("signup_password"))).sendKeys(password);
		driver.findElement(By.xpath(xpathloc.getProperty("signup_button"))).click();
		Thread.sleep(Duration.ofSeconds(2));
		
		
		
		Alert alert = driver.switchTo().alert();
        alert.accept();
        
        //Create an instance of Actions class
        Actions actions = new Actions(driver);
        
        // Perform the Enter key press action
        //actions.sendKeys(Keys.ENTER).perform();
        //Thread.sleep(Duration.ofSeconds(3));
        actions.sendKeys(Keys.ESCAPE).perform();
       
        
        Thread.sleep(Duration.ofSeconds(2));
        
    	driver.findElement(By.xpath(xpathloc.getProperty("login"))).click();
    	
    	Thread.sleep(Duration.ofSeconds(2));
    	
		driver.findElement(By.xpath(xpathloc.getProperty("login_username"))).sendKeys(username);
		driver.findElement(By.xpath(xpathloc.getProperty("login_password"))).sendKeys(password);
		//Thread.sleep(Duration.ofSeconds(3));
		driver.findElement(By.xpath(xpathloc.getProperty("login_button"))).click();
		Thread.sleep(Duration.ofSeconds(2));
		
        
		driver.findElement(By.xpath(xpathloc.getProperty("logout"))).click();
		
	}
}