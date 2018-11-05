package qa.lesson.one;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyTitle {
public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.qa.jpay.com");
		
//		driver.navigate().to("https://www.qa.jpay.com/login.aspx");
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
		
		String expectedTitle = "JPay | Your Home For Corrections Services";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			
			System.out.println("Test Case Passed ");
		}
		else {
			
			System.out.println("Testa Case Failed ");
		}
		
		driver.close();
}
}
