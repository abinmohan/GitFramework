package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public static WebDriver driver = null;
	public Properties pro = null;

	public WebDriver InitializerDriver() throws IOException {
		pro = new Properties();
		// FileInputStream File = new
		// FileInputStream("F:\\Java_Selenium\\ScratchFramework\\src\\main\\java\\resources\\data.properties");
		FileInputStream File = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		pro.load(File);
		// mvn test -Dbrowser=chrome

		String browsername = System.getProperty("browser"); // for maven
		// String browsername = pro.getProperty("browser"); 
		if (browsername.contains("chrome")) {
			// execute in chrome
			 //System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe"); 
			System.setProperty("webdriver.chrome.driver", "src\\main\\java\\resources\\chromedriver.exe");
			if (browsername.contains("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} 
			else
			{
				driver = new ChromeDriver();

			}
			// driver.manage().window().maximize();

		}
		if (browsername.equals("firefox")) {
			// System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		if (browsername.equals("IE")) {
			// System.setProperty("webdriver.ie.driver",
			// "C:\\Work\\MicrosoftWebDriver.exe");
			System.setProperty("webdriver.ie.driver", "src\\main\\java\\resources\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
		// String png= System.currentTimeMillis()+ ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// String destinationFile =
		// System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		String destinationFile = System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName+ formater.format(calendar.getTime()) + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;// use dis return for only extent report

	}
}
