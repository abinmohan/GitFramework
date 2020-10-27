package MavenProject; 
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; 
import pageObject.LandingPage; 
import resources.base;

public class ValidateTitle extends base
{
	public   WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= InitializerDriver();
		log.info("Driver is initialized");
		driver.get("http://www.google.com/"); 
	}
	
	@Test 
	public void textValidation() throws IOException
	{ 
		LandingPage L = new LandingPage(driver);
		Assert.assertEquals(L.Name().getText(),"Gmail1"); 
		log.info("Sucessfully Validated Text Message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}	
 

}
