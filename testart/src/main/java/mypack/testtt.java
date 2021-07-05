package mypack;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Mytest.Location;

public class testtt {

	public static HashMap<String, String> map;
	public static ArrayList<String> l;
	public static String name;
	public static int cnt;
	public static String Testdatasheet;
	public static FileInputStream fis;
	public static String Testscript;
	
	
	public static String getname() throws IOException {
		
		//test
		//hgd

		File f = new File(Location.TestSuite + ".xlsx");
		 fis = new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();
		Row fr = rows.next();
		Iterator<Cell> ce = fr.cellIterator();
		int ki = 0;
		int col = 0;
		while (ce.hasNext()) {

			if (ce.next().getStringCellValue().equalsIgnoreCase("Yes/No")) {

				ki++;
				col = ki;
			}
		}

		int l = 0;

		while (rows.hasNext()) {
			Row r = rows.next();

			if (r.getCell(col).getStringCellValue().equalsIgnoreCase("Yes")) {
				l = l + 1;
				name = r.getCell(col - 1).getStringCellValue();
			}
		}

		return name;
	}

	public static HashMap<String, String> getdata(String tcname) throws IOException {

		String[] arr = new String[50];
		String[] arrb = new String[50];

		map = new HashMap<String, String>();
		File f = new File(Location.Testdatasheet + ".xlsx");

		 fis = new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(Location.Testsheet);
		Iterator<Row> rows = sheet.iterator();
		Row fr = rows.next();
		Iterator<Cell> ce = fr.cellIterator();
		int k = 0;

		while (ce.hasNext()) {
			String value = ce.next().getStringCellValue();
			arr[k] = value;
			k++;
		}

		while (rows.hasNext()) {
			Row r = rows.next();

			if (r.getCell(0).getStringCellValue().equals(tcname)) {

				Iterator<Cell> cell = r.cellIterator();
				int y = 0;
				while (cell.hasNext()) {
					String data = cell.next().getStringCellValue();

					arrb[y] = data;
					y++;

				}

			}
		}

		for (int po = 0; po < k; po++) {
			map.put(arr[po], arrb[po]);
		}

		return map;

	}

	public static HashMap<String, String> cons() throws IOException {

		String name1 = testtt.getname();
		return testtt.getdata(name1);
	}

	public static ArrayList<String> allname() throws IOException {

		l = new ArrayList<String>();
		File f = new File(Location.Testscript + ".xlsx");

		 fis = new FileInputStream(f);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Iterator<Row> rows = sheet.iterator();

		while (rows.hasNext()) {
			Row fr = rows.next();

			Iterator<Cell> cd = fr.cellIterator();

			if (fr.getCell(0).getStringCellValue().equalsIgnoreCase(testtt.getname())) {
				int x = 0;
				while (cd.hasNext()) {
					if (x > 0) {
						l.add(cd.next().getStringCellValue());
					}
					x++;
				}
			}
		}

		for (int h = 0; h < l.size(); h++) {
			if (l.get(h).equalsIgnoreCase(testtt.getname())) {
				l.remove(h);
			}
		}

		cnt = l.size();
		
		return l;

	}
}
