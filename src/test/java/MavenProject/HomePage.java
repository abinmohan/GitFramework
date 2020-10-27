package MavenProject; 
import java.io.IOException; 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 
import pageObject.LandingPage;
import pageObject.recoveryPage;
import resources.base;

public class HomePage extends base {
	public   WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= InitializerDriver();
	}
	
	@Test(dataProvider="getdata")
	public void basePageNavigation (String username,String Password) throws IOException
	{
		 
		driver.get(pro.getProperty("url"));
		LandingPage L = new LandingPage(driver);
		L.Email().sendKeys(username);
		L.Password().sendKeys("Password");
		L.LogIn().click();
		recoveryPage rp= new recoveryPage(driver);
		rp.recoveryclick().click();
		log.info("Test done");
		
	}
	
	@DataProvider
	public Object[][] getdata()
	{
	 // Row stands for how many different data types test should run
	 //coloumn stands for how many values per each test
		
	// Array size is 2
	// 0,1
	//Object[][] data = new Object[2][2]; 
	Object[][] data = new Object[1][2]; 
	data[0][0]="facebook";
	data[0][1]="Password";
	
	//data[1][0]="facebook2";
	//data[1][1]="password2";
	 
	return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
