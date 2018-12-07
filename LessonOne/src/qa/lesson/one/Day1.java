package qa.lesson.one;


import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.util.SystemTimeUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import Lib.DateTimeLib;
import Lib.ExcelDataConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
//import okio.Timeout;

public class Day1 {
	
	static WebDriver driver;
	
	public void invokeBrowser(){
		
		try {
			//System.setProperty("webdriver.chrome.dirver","C:\\ToolsQA\\chromedriver_win32\\chromedriver.exe");
			System.setProperty("webdriver.gecko.driver","C:\\ToolsQA\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			//driver = new ChromeDriver();
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.dev1.jpay.com");
			
			//Navigate functions
			//driver.navigate().to("https://www.qa.jpay.com");
			//driver.navigate().back();
			//driver .navigate().forward();
			//driver.navigate().refresh();
			

			
			//testing git 
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void login(){
		try {
			Thread.sleep(9000);
			//driver.findElement(By.id("logo")).click();
			//driver.findElement(By.name("q")).click();
			
			
					
			//driver.manage().window().maximize();
		//WebElement element =	driver.findElement(By.name("btnK"));
		//clickByActions(element);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("not found");
		}
		
	}
	
	public static void clickByActions(WebElement element){
		Actions builder = new Actions(driver);
		Action click = builder.click(element).build();
		click.perform();
	}

	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day1 myObj = new Day1();
		myObj.invokeBrowser();
		
		try {
			
			
//            driver.get("test");
//			
		
			
			//double decimals = 2 / 3d ;							
			//System.out.println("decimales " + decimals);
			
			ExcelDataConfig excel = new ExcelDataConfig("C:\\ToolsQA\\ExcelData\\TestData.xlsx");
			System.out.println(excel.getData(0, 0, 0));
			System.out.println(excel.getData(0, 0, 1));
			
			// to Write in EXCEl the results
			File src= new File("C:\\ToolsQA\\ExcelData\\TestData.xlsx");
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook   wb=new XSSFWorkbook  (fis);
			XSSFSheet sheet2=wb.getSheetAt(0);
			
			FileWriter fr=new FileWriter("C:\\ToolsQA\\ExcelData\\data.txt");
			BufferedWriter br=new BufferedWriter(fr);
			
			/*
			sheet2.getRow(0).createCell(2).setCellValue("Pass the test case");
			sheet2.getRow(1).createCell(2).setCellValue("Fail all test cases");
			*/
			
		//	FileOutputStream fout=new FileOutputStream(src);
			//wb.write(fout);
			//wb.close();
			
			
			
			
		//	excel.getData(0, 0, 0).setCellValue("Pass");
			
			
			// To get Total of rows
			System.out.println(excel.getTotalRows(0));
			
			
			//driver.findElement(By.id("uh-search-box")).sendKeys("test");
			//driver.findElement(By.className("LoginButton")).click();
			Thread.sleep(6000);
			//int account=2;
			for(int account=0;account<=excel.getTotalRows(0);account++)
			{
				
			FileOutputStream fout=new FileOutputStream(src);
			
			driver.findElement(By.id("newHeader_TopRightNavButton_LoginButtonPanel")).click();
			Thread.sleep(6000);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			//driver.findElement(By.id("uclLoginFirstTime_txtUserId")).sendKeys("marin123@jpay.com");
			
			driver.findElement(By.id("uclLoginFirstTime_txtUserId")).sendKeys(excel.getData(0, account, 0));
			
			//driver.findElement(By.name("uclLoginFirstTime$txtUserId")).sendKeys(Keys.RETURN);
			//driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys("123456");
			
			driver.findElement(By.id("uclLoginFirstTime_txtPassword")).sendKeys(excel.getData(0, 0, 1));
			
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
			
			
		// Count total inmates from the dropdownlist
		Select selectDropdown = new Select(driver.findElement(By.id("inmatesDropDownList")));
		List<WebElement> listOptionDropdown = selectDropdown.getOptions();	
		int dropdownCount = listOptionDropdown.size();
		System.out.println("Total Number of item count in dropdown list = "  + dropdownCount);  
		
		//String SendMOney = driver.findElement(By.name("btn_Start")).getText();
		//String SendMOney = driver.findElement(By.id("labelSec1")).getText();
		//System.out.println(SendMOney);
		
		
		
	
		/*if(SendMOney != "Next")
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("NO");
		}*/
		
		//K is the number ot repetitions for each account
		for (int k=0;k<100;k++)
		//{
		for(int i=0;i<dropdownCount;i++)
		{
			Select selectDropdown1 = new Select(driver.findElement(By.name("inmatesDropDownList")));
			selectDropdown1.selectByIndex(i);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
			
			
				
			
			String SendMOney = driver.findElement(By.id("labelSec1")).getText();
			System.out.println(SendMOney);
			
			if(SendMOney != "Nextt")
				
			{
				System.out.println("yes you can send money FREDY");
				// Click NEXT boutton
				driver.findElement(By.name("btn_Start")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
				
				//Step1
				driver.findElement(By.id("uclSelectInmate_btnContinue")).click();
				
				System.out.println("CVV entering");
				
//				WebElement cvv = driver.findElement(By.cssSelector("#CardTokenData_Cvv"));
//				cvv.sendKeys("123");
				
				
				// Random number for Amount
				Random rg = new Random();
				double randomInt = rg.nextInt(800);
				System.out.println("Generated : " + randomInt);
				
				//Adding decimals to the number
				double decimal = i / 2.73d + 2;							
				System.out.println("decimales " + decimal);
				
				randomInt = randomInt + decimal;
				
				driver.findElement(By.id("uclPaymentMethod_ed_Amount")).sendKeys(Double.toString(randomInt));
				
				driver.switchTo().defaultContent(); 
				driver.switchTo().frame("secureServer");
				driver.findElement(By.id("CardTokenData_Cvv")).sendKeys("123");
				driver.switchTo().defaultContent();
				
				driver.findElement(By.id("btnContinue")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
				
				driver.findElement(By.id("chkTerms")).click();
				driver.findElement(By.id("btnContinue")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

				//Start To Verify if the transation was successful 
				
				String ConfirmSuccess = driver.findElement(By.id("MyDataListPaymentStatus_ctl00_lblStatus")).getText();
				System.out.println(ConfirmSuccess);
				
				
				if (ConfirmSuccess == "Success"){
					i++;
					//System.out.println("Transaction " + ConfirmSuccess);
					// Click HOME boutton
					//driver.findElement(By.xpath("id(\"StateCountyHeader1_NavTable\")/tbody[1]/tr[1]/td[1]/a[1]")).click();
					driver.findElement(By.className("HeaderNavLinkInactive")).click();
					driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
					System.out.println("Transaction Fail due a Dupplicate");
					break;
					
				}
				else
				{
					System.out.println("Transaction PASS");
				String confirmationNumber;
				confirmationNumber = driver.findElement(By.id("MyDataListPaymentStatus_ctl00_lblTransferID")).getText();
				System.out.println(confirmationNumber);
				
				// Click HOME boutton
				//driver.findElement(By.xpath("id(\"StateCountyHeader1_NavTable\")/tbody[1]/tr[1]/td[1]/a[1]")).click();
				driver.findElement(By.className("HeaderNavLinkInactive")).click();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
				}
				//End To Verify if the transation was successful
			}
			else
			{
				System.out.println("NO Money");
				//driver.findElement(By.xpath("id(\"StateCountyHeader1_NavTable\")/tbody[1]/tr[1]/td[1]/a[1]")).click();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;	
			}	
								
			System.out.println(i);
		// }
		
		System.out.println(k);
	   
			
			//sheet2.getRow(account).createCell(2).setCellValue("Pass the test case by Fredy  " + excel.getData(0, account, 0));
		//	wb.write(fout);
			//wb.close();
		
		} // this FOR each account
		
		//wb.close();	
		System.out.println("Pass the test case by Fredy screen  "  + excel.getData(0, account, 0));
		// to write into the file
		//br.write("Pass the test case by Fredy screen  "  + excel.getData(0, account, 0));
		//br.newLine();
		System.out.println(account);
		driver.findElement(By.id("myheader_TopRightNavButton_LogoutButtonPanel")).click();
		
		}	
				 
		 driver.quit();// ("https://www.qa.jpay.com");
		 br.close();
		 wb.close();
	
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

// Is working for all accounts in xls file, 
//Write the results to TXT file. 2018-09-13 16:00
