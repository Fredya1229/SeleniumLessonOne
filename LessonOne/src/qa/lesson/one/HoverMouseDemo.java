package qa.lesson.one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverMouseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		WebElement helloSingIn = driver.findElement(By.cssSelector("#nav-link-accountList"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(helloSingIn).build().perform();
		
		driver.findElement(By.linkText("Your Recommendations")).click();
		
		// needs to try couple time due Amazon Prod server.
		
		
		
		

	}

}
