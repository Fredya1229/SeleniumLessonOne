package DDT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JpayLogin {
	
	WebDriver driver;
	
	@Test(dataProvider="loginwww")
	public void loginWWW(String username,String password) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver .get("https://www.dev2.jpay.com/login.aspx");
		
		driver.findElement(By.id("uclLoginFirstTime_txtUserId")).sendKeys(username);
		driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys(password);
		//driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("/html/body/form/div[3]/div[4]/section/div/div/div[2]/div/div/div[1]/div/div/div/div/table/tbody/tr[1]/td[4]/a/div")).click();
		Thread.sleep(5000);
		
		//System.out.println(driver.getTitle());	
		
		Assert.assertTrue(driver.getTitle().contains("JPay | Home"),"User was NOT able to login");
		
		System.out.println("The user was able to login successfully");
		
			
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	
	
    @DataProvider(name="loginwww")
	public Object[][] passCredentials()
	{
		
		Object[][] data=new Object[3][2];
		
		data[0][0]="dev2123@jpay.com";
		data[0][1]="123456";
		
		data[1][0]="wa@jpay.com";
		data[1][1]="43534534";
		
		data[2][0]="van123@jpay.com";
		data[2][1]	="123456";
		
		return data;
	}
	
}
