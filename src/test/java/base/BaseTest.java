package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loginprop = new Properties();
	public static FileReader fr;
	public static FileReader loginPagefr;
	
	@BeforeMethod
	public void setUp() throws IOException {
		if(driver==null) {
			FileReader fr = new FileReader("C:\\Users\\OEM\\automation-workspace\\UIAutomationFramework\\src\\test\\resources\\configfiles\\config.properties");
			FileReader loginPagefr = new FileReader("C:\\Users\\OEM\\automation-workspace\\UIAutomationFramework\\src\\test\\resources\\configfiles\\LoginPage.properties");
			prop.load(fr);
			loginprop.load(loginPagefr);
		}
			
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("baseURL"));
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("baseURL"));
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("Teardown successful");
		
	}

}
