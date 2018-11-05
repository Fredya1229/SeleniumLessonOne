package qa.lesson.one;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OpeningNewTabManual {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.qa.jpay.com");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.open()");
		
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		driver.get("https://www.dev2.jpay.com");
				
		driver.quit();
		
	}
	
}
