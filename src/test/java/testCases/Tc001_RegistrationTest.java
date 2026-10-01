package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import pageObjects.AccountResgister;
import pageObjects.HomePage;

public class Tc001_RegistrationTest<AccountRegistration> { // Class name standard: CamelCase
    
    public WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
    }

    @Test
    public void testRegistration() {
        HomePage hp = new HomePage(driver);
        hp.clickLoginMyAccount();
        hp.clickRegisterAccount();

        AccountResgister account = new AccountResgister(driver);
        
        account.setFirstname("janvi");
        account.setLastname("narang");
        
        // Random email generation
        account.setEmail(randomString() + "@gmail.com");
        account.setTelephone(randomNumber());

        // Password matching logic
        String password = randomAlphaNumeric();
        account.setPassword(password);
        account.setConfirmPassword(password); // Wahi password confirm mein jayega

        account.setPrivacyPolicy();
        account.clickContinue();
        
        // Validation (Pavan's step)
        String confMsg = account.getConfirmationMsg();
        //
       // Assert.assertEquals(confMsg, "Your Account Has Been Created!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    // Helper methods for dynamic data
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        String str = RandomStringUtils.randomAlphabetic(3);
        String num = RandomStringUtils.randomNumeric(3);
        return (str + "@" + num);
    }
}