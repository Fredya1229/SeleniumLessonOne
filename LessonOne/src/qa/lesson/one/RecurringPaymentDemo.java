package qa.lesson.one;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.util.SystemTimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecurringPaymentDemo {

	
	
	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		//driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.qa.jpay.com");
		//driver.get("https://www.qa.jpay.com/FirstTime.aspx?Search=000012&State=WY");
		//driver.findElement(By.id("uclInmateResultPanel_dgResults_ctl03_lnkInmateName")).click();
		
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.id("newHeader_TopRightNavButton_LoginButtonPanel")).click();
		//Thread.sleep(6000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//driver.findElement(By.id("uclLoginFirstTime_txtUserId")).sendKeys("marin123@jpay.com");
		
		driver.findElement(By.id("uclLoginFirstTime_txtUserId")).sendKeys("rp123@jpay.com");
		
		//driver.findElement(By.name("uclLoginFirstTime$txtUserId")).sendKeys(Keys.RETURN);
		//driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys("123456");
		
		driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys("123456");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		
		// Explicit Wait start, 10 is the value in seconds.
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.LoginButton")));
		// Explicit wait end
		
		// in case i need to click Return after entering the password.
		//driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.cssSelector("div.LoginButton")).click();
		
		
		// To confirm the account entered is Valid start
		String expectedMessage ="* Please enter valid login id and password";
		String actualMessage = driver.findElement(By.cssSelector("#uclLoginFirstTime_CustomValidator1")).getText();
		System.out.println(actualMessage);
		
	
		if(expectedMessage.equals(actualMessage)){
			System.out.println("Please enter Valid credentials");
			
		}
		else {
			System.out.println("Username and Password verified");
		}
		
		// To confirm the account entered is Valid end
		
		driver.findElement(By.id("LinkButton2")).click();
		driver.findElement(By.cssSelector("#btn_Initiate")).click();
		driver.findElement(By.cssSelector("#uclSelectInmate_btnContinue")).click();
		
		// Random number for Amount
		Random rg = new Random();
		double randomInt = rg.nextInt(300);
		System.out.println("Generated : " + randomInt);
		
		double decimal = 5 / 2.3d + 2;							
		System.out.println("decimales " + decimal);
		randomInt = randomInt + decimal;
				
		driver.findElement(By.id("uclPaymentMethod_ed_Amount")).sendKeys(Double.toString(randomInt));
		
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_MONTH); 
		
				
		//WebElement commingDay = driver.findElement(By.xpath("//*[@id='StartDateCalendar']/tbody"));
		WebElement commingDay = driver.findElement(By.cssSelector("#StartDateCalendar > tbody"));
		
		
		List<WebElement> colunms = commingDay.findElements(By.tagName("td"));
		
		// to convert number to string 
		String days =  Integer.toString(dayOfWeek);
		
		for(WebElement t : colunms){
			
			if(t.getText().equals(days)) {
				t.click();
				driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS) ;
				break;
			}
			
		}	
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	//	System.out.println(colunms);
		
		System.out.println("today is " + dayOfWeek);
		
		
		driver.findElement(By.cssSelector("#rdoInterval_0")).click();
		
		driver.findElement(By.xpath("//*[@id='btnContinue']")).click();
		
		driver.findElement(By.xpath("//*[@id='chkTerms']")).click();
		
		driver.findElement(By.cssSelector("#btnContinue")).click();
		
		driver.findElement(By.id("myheader_TopRightNavButton_LogoutButtonPanel")).click();
		
		
		 boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
			try {
			    if (isDebug)
			        Runtime.getRuntime().exec("taskkill  /F /IM geckodriver.exe");
			        Runtime.getRuntime().exec("taskkill  /F /IM conhost.exe");
			        Runtime.getRuntime().exec("taskkill  /F /IM chromedriver.exe");
			        Runtime.getRuntime().exec("taskkill  /F /IM IEDriverServer.exe");
			} catch (IOException e) {
			    e.printStackTrace();
			}
			
			driver.quit();
	}
		

	
		
		
}


