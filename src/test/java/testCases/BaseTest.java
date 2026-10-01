package testCases;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.internal.ReporterConfig.Property;

public class BaseTest {
	WebDriver driver;
	public Logger logger;
	public Properties p;
	
	 @BeforeClass
	    public void setup() throws IOException {
		 FileReader file= new FileReader(".//src//test//resouces//config.properties");
		 p= new Properties();
		p.load(file);
	        driver = new ChromeDriver();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/");
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
	    public String captureScreen(String tname) throws IOException {
	        // 1. Create a timestamp
	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        
	        // 2. Capture the screenshot using TakesScreenshot interface
	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	        
	        // 3. Define the destination path
	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	        File targetFile = new File(targetFilePath);
	        
	        // 4. Copy source file to destination
	        sourceFile.renameTo(targetFile);
	        
	        return targetFilePath; // Return path to attach it to the Extent Report later
	    }


}
