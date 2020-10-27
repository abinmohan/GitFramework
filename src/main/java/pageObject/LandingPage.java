package pageObject; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
public WebDriver driver;
	
private By username =By.id("email");
private By password = By.id("pass");
private By go=By.xpath("//button[@type='submit']"); 
	
	By Name=By.xpath("//a[contains(normalize-space(),'Gmail')]");
	 
	public LandingPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement Email()
	{
		return driver.findElement(username);
	}
	
	public WebElement Password()
	{
		return driver.findElement(password);
	}
	
	public WebElement LogIn()
	{
		return driver.findElement(go);
	}
	
	public WebElement Name()
	{
		return driver.findElement(Name);
	}

}
