package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	
	//locators
	@FindBy(xpath="//h2[text()='My Account']") WebElement MsgHeading;
	@FindBy(xpath="//div[@class='list-group']//a[text()='logout']")
	WebElement lnkLogout;
	
	// action methods
	public boolean isHeaderMyaccount(){
		try{
		return(MsgHeading.isDisplayed());
	}
		catch(Exception e){
		return false;
		}
	
		
	}
	public void clicklogout()
	{
	lnkLogout.click();
	}}


	
