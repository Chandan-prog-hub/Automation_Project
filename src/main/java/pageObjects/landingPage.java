package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	WebDriver driver;
	public landingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement MyaccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginbutton;
	
	public WebElement MyaccountDropdown() {
		return MyaccountDropdown;
	}
	public WebElement loginbutton() {
		return loginbutton;
	}
	

}
