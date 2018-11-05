package qa.lesson.one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiSelectDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.jqueryfaqs.com/demos/112/");
		
		//To click on the dropdownLIt
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > button > span")).click();
		
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > ul > li:nth-child(4) > a > label")).click();
		driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div > div > div.col-xs-12.col-md-9.left-section > span > div > ul > li:nth-child(2) > a > label")).click();
		
		driver.findElement(By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(1)")).click();
		
		
		
	}

}
