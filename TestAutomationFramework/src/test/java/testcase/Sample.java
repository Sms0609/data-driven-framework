package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zoho.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("login_id")).sendKeys("datatestjava@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		Thread.sleep(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name=\"PASSWORD\"]")).sendKeys("testautomation123");
		driver.findElement(By.xpath("//button[normalize-space()=\"Sign in\"]")).click();
	}

}
