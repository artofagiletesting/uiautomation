package testcase;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import base.BaseTest;


public class LoginTest extends BaseTest {
	@Test (dataProvider = "testdata")
	public static void UILoginTest(String username, String password) {
		  driver.manage().window().maximize();
		  driver.findElement(By.id(loginprop.getProperty("username_field")));
		  driver.findElement(By.cssSelector(loginprop.getProperty("username_input_field"))).sendKeys(username);
		  driver.findElement(By.cssSelector(loginprop.getProperty("password_input_field"))).sendKeys(password);
		  driver.findElement(By.cssSelector(loginprop.getProperty("login_button"))).click();
		  
		  driver.findElement(By.cssSelector(loginprop.getProperty("logo"))).click();
		  AssertJUnit.assertEquals(driver.findElement(By.cssSelector(loginprop.getProperty("logo"))).getText(), "Swag Labs");
	}
	

	@DataProvider(name = "testdata")
	public Object[][] loginData() {
	 return new Object[][] {
	   { "standard_user", "secret_sauce" },
	   { "locked_out_user", "secret_sauce" },
	   { "problem_user", "secret_sauce" },
	   { "performance_glitch_user", "secret_sauce" }
	 };
	}

}
