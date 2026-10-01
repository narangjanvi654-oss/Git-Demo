
	package utilities;

	import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseTest;

//import BaseTest.BaseClass;

	public class ExtentReportManager implements ITestListener {
	    public ExtentSparkReporter sparkReporter;
	    public ExtentReports extent;
	    public ExtentTest test;

	    String repName;

	    public void onStart(ITestContext testContext) {
	        // 1. Setup TimeStamp for unique report names
	        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        repName = "Test-Report-" + timeStamp + ".html";

	        // 2. Configure Report Path and UI
	        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
	        sparkReporter.config().setDocumentTitle("opencart Automation Report"); 
	        sparkReporter.config().setReportName("opencart Functional Testing");
	        sparkReporter.config().setTheme(Theme.DARK);

	        // 3. Set System Information
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Application", "opencart");
	        extent.setSystemInfo("Module", "Admin");
	        extent.setSystemInfo("Sub Module", "Customers");
	        extent.setSystemInfo("User Name", System.getProperty("user.name"));
	        extent.setSystemInfo("Environment", "QA");
	    }

	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName()); // Create entry
	        test.assignCategory(result.getMethod().getGroups()); // Displays groups (Sanity/Regression)
	        test.log(Status.PASS, result.getName() + " got successfully executed");
	    }

	    public void onTestFailure(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        
	        test.log(Status.FAIL, result.getName() + " got failed");
	        test.log(Status.INFO, result.getThrowable().getMessage());

	        try {
	            // Logic to capture screenshot from the BaseClass
	            String imgPath = new BaseTest().captureScreen(result.getName());
	            test.addScreenCaptureFromPath(imgPath);
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
	    }

	    public void onTestSkipped(ITestResult result) {
	        test = extent.createTest(result.getTestClass().getName());
	        test.assignCategory(result.getMethod().getGroups());
	        test.log(Status.SKIP, result.getName() + " got skipped");
	        test.log(Status.INFO, result.getThrowable().getMessage());
	    }

	    public void onFinish(ITestContext testContext) {
	        extent.flush(); // Crucial: Writes all data to the file
	    }
	}

