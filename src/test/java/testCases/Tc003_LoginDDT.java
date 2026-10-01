package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class Tc003_LoginDDT extends BaseTest {
	@Test(dataProvider="LoginData" ,dataProviderClass=DataProviders.class)
	public void verifylogintest(String email, String password, String exp){
		
		HomePage hp= new HomePage(driver);
		hp.clickLoginMyAccount();
		hp.clickLogin();
		LoginPage lp=new LoginPage(driver);
			lp.Setusername(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clickonlogin();
			
		MyAccountPage ap= new MyAccountPage(driver);
		Boolean targetpage=ap.isHeaderMyaccount();
		if(exp.equalsIgnoreCase("Valid")){
			if(targetpage==true){
				ap.clicklogout();
				Assert.assertTrue(true);
			}
		}else{
			Assert.assertTrue(false);
		}
		
		

	
	if(exp.equalsIgnoreCase("InValid")){
		if(targetpage==true){
			ap.clicklogout();
			Assert.assertTrue(false);	}
	}
	else{
		Assert.assertTrue(true);
	}
	

}}
