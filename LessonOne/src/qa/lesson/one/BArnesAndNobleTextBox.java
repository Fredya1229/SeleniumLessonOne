package qa.lesson.one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BArnesAndNobleTextBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.barnesandnoble.com/");
		
		
		//driver.findElement(By.cssSelector("#bx-element-822425-mVFWu2h > button:nth-child(1)")).click();
		
	 //  if(driver.findElement(By.id("#bx-element-822425-mVFWu2h > button:nth-child(1)")).size() !=0)
		
		//driver.findElement(By.xpath("/html/body/div[20]/div[3]/div/div/div/div[1]/form/div[3]/div[2]/button")).click();
		
		driver.findElement(By.id("signInLink")).click();
		

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Switch the focus in the iframe
		WebElement dialoBox = driver.findElement(By.cssSelector(".modal__dialog > iframe:nth-child(1)"));
		driver.switchTo().frame(dialoBox);
		
		driver.findElement(By.id("email")).sendKeys("fre@jpay.com");
		
	}
	
}