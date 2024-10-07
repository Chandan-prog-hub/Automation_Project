package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement EmailField;
	
	@FindBy(id="input-password")
	private WebElement PasswordField;
	
	@FindBy(xpath  = "//input[@value='Login']")
	private WebElement LoginButton;
	
	public WebElement EmailField() {
		return EmailField;
	}
	
	public WebElement PasswordField() {
		return PasswordField;
	}
	
	public WebElement LoginButton() {
		return LoginButton;
	}

}
