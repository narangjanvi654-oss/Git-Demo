package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Tc002_loginTestcase extends BaseTest {
@Test

	public void LoginTest(){
		
	logger.info("Starting my test case");	
	try{
	HomePage hp= new HomePage(driver);
	hp.clickLoginMyAccount();
	hp.clickLogin();
	LoginPage lp=new LoginPage(driver);
		lp.Setusername(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickonlogin();
		
	MyAccountPage ap= new MyAccountPage(driver);
	Assert.assertEquals(ap.isHeaderMyaccount(), true);
}
catch(Exception e){
	Assert.fail();
	logger.info("finished");
}
	
	
	
	
	
}}
