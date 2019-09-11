package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
	public static void readExcelData(String filePath) throws IOException{
		FileInputStream inputStream=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(1);
		
		int rowCount=sheet.getLastRowNum();
		int columnCount=row.getLastCellNum();
		System.out.println("Total rows: "+ rowCount +" columns:" +columnCount);
		
		for(int rows=1; rows<=rowCount; rows++){
			for(int columns=0; columns<columnCount; columns++){
				String cellData=sheet.getRow(rows).getCell(columns).getStringCellValue();
				System.out.print(cellData + " | ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) throws IOException {
		readExcelData(Util.getProjectDirectory()+"\\src\\main\\java\\TestData\\DataSheet.xlsx");
		
	}
}
