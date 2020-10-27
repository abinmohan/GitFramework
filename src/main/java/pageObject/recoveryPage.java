package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class recoveryPage {
	
public WebDriver driver;
	
	By recovery =By.xpath("//a[@class='_97w4']");
	 

	public recoveryPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement recoveryclick()
	{
		return driver.findElement(recovery);
	}

}
