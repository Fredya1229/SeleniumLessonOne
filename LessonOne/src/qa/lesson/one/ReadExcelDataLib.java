package qa.lesson.one;

import Lib.ExcelDataConfig;

public class ReadExcelDataLib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExcelDataConfig excel = new ExcelDataConfig("C:\\ToolsQA\\ExcelData\\TestData.xlsx");
		System.out.println(excel.getData(0, 0, 0));
		System.out.println(excel.getData(0, 0, 1));
		System.out.println(excel.getTotalRows(0));

	}

}
