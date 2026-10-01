package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
// locator create krna 
	@FindBy(xpath="//input[@id='input-email']") WebElement txtusername;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbutton;
	// create action methods 
	public void Setusername(String name){
txtusername.sendKeys(name);
}
	public void setpassword(String pwd){
		txtpassword.sendKeys(pwd);
	}
	
	public void clickonlogin(){
		loginbutton.click();
	}
	
}