package tests;

import java.io.IOException;
import java.sql.Time;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.Loginpage;
import pageObjects.landingPage;
import resources.Base;

public class LoginTest extends Base {
	WebDriver driver;
	
	@Test(dataProvider = "getlogindata")
	public void login(String email, String password, String expectedresult) throws IOException, InterruptedException {
		
		landingPage  lpage= new landingPage(driver);
		lpage.MyaccountDropdown().click();
		lpage.loginbutton().click();
		
		Loginpage lpg= new Loginpage(driver);
		Thread.sleep(3000);
		lpg.EmailField().sendKeys(email);
		Thread.sleep(3000);
		lpg.PasswordField().sendKeys(password);
		Thread.sleep(3000);
		lpg.LoginButton().click();
		Thread.sleep(3000);
		
		AccountPage accountpage= new AccountPage(driver);
		
		String actualresult=null;
		try {
			if(accountpage.Edityouraccountinformation().isDisplayed()) {
				actualresult="success";
			}
			}catch(Exception e) {
				actualresult="Fail";
			
		}
	
		Assert.assertEquals(actualresult, expectedresult);
	
		
	}
	@BeforeMethod
	public void lunchbrowser() throws IOException {
		 driver = InitializeDriver();
			driver.get(prop.getProperty("URL"));
		
	}
	
	
	@AfterMethod
	public void closure() {
		driver.close();
	}
	@DataProvider
	public Object[][] getlogindata() {
		
		Object [][] data= {{"chandanjena03@gmail.com", "Chandan.123", "success"},{"dummy@gmail.com", "Test.123", "Fail"}};
		return data;
	}

		
		
		
		
	

}
