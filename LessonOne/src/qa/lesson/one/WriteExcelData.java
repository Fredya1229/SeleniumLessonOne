package qa.lesson.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.Test;

public class WriteExcelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File src= new File("C:\\ToolsQA\\ExcelData\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook   wb=new XSSFWorkbook  (fis);
		
		XSSFSheet sheet2=wb.getSheetAt(0);
		
		sheet2.getRow(0).createCell(2).setCellValue("Pass");
		sheet2.getRow(1).createCell(2).setCellValue("Fail");
		
		FileOutputStream fout=new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		
	}

}
