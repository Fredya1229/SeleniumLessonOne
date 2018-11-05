package qa.lesson.one;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File src= new File("C:\\ToolsQA\\ExcelData\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook   wb=new XSSFWorkbook  (fis);
		
		XSSFSheet sheet1=wb.getSheetAt(0);
		/*
		String data0=sheet1.getRow(0).getCell(0).getStringCellValue();
		System.out.println("this is the username " +data0);
		String data1=sheet1.getRow(0).getCell(1).getStringCellValue();
		System.out.println("this is the password " +data1);
		*/
		
		int rowcount=sheet1.getLastRowNum();
		System.out.println(rowcount);
		
		for(int i=0;i<=rowcount;i++)
		{
			String data0=sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println("this is the username " +data0);
			String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
			System.out.println("this is the password " +data1);
			
		}
		
		wb.close();
		
	}

}
