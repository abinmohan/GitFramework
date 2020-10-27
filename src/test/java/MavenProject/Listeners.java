package MavenProject; 
import java.io.IOException;
 
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult; 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsDemo;
import resources.base;
 



public class Listeners extends base implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReportsDemo.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		  test= extent.createTest(result.getMethod().getMethodName());
		  extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 //test.log(Status.PASS,"Test Passed");// for sequential execution 
		extentTest.get().log(Status.PASS, "Test Passed");// for parallel  execution
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//To get Screenshot on the Extent Report
		extentTest.get().fail(result.getThrowable());
		 //test.fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		try 
		{
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch  (Exception e)
		{ }  
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* to get the screen shot on the folder
		 * WebDriver driver =null; String testMethodName
		 * =result.getMethod().getMethodName(); try { driver
		 * =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
		 * get(result.getInstance()); } catch (Exception e) { } try {
		 * getScreenShotPath(testMethodName,driver); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
 
	 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		 extent.flush();
	}

}
