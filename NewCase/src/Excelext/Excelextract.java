package Excelext;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelextract {
	
	
	public static void main(String[] args) throws IOException {
		
		
		File f = new File("E:\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		int sheets =workbook.getNumberOfSheets();
		
		
	}
}
