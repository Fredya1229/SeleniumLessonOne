package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb; 
	XSSFSheet sheet1;
	
	public ExcelDataConfig(String excelPath)
	{
       
		try
		{
			File src= new File(excelPath);
			
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook  (fis);
			
			
		}  
		catch (IOException e) {
		    System.out.println(e.getMessage());	
		}
		
	}


public String getData(int sheetNumber,int row,int colunm)
	{

	
	sheet1=wb.getSheetAt(sheetNumber);	
	String data=sheet1.getRow(row).getCell(colunm).getStringCellValue();
	return data;

	}


public int getTotalRows(int sheetNumber)
{
	int rowcount=sheet1.getLastRowNum();
	return rowcount;
}





}
