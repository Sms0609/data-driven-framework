package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static Properties xpathloc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	public static FileReader frxpath;
	

	@BeforeMethod
	public void setUp() throws IOException {
			
		if(driver==null) {
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			frxpath = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\xpathlocators.properties");
			prop.load(fr);
			loc.load(fr1);
			xpathloc.load(frxpath);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("chrome://settings/");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("chrome.settingsPrivate.setDefaultZoom(0.67);");
			//url of website to be tested
			driver.get(prop.getProperty("testurl"));
		}
		
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			/*driver.manage().window().maximize();
			driver.get("firefox://settings/");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("firefox.settingsPrivate.setDefaultZoom(0.67);");*/
			//url of website to be tested
			driver.get(prop.getProperty("testurl"));
		}
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		System.out.println("Teardown successful");
	}
}
