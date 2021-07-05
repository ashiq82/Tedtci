package Mytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

public class Pdfreport {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		HtmlConverter.convertToPdf(new FileInputStream("E:\\Result\\Result TS3 2021-03-30 16-30-10\\dashboard.html"), 
	            new FileOutputStream("E:\\Result\\fr.pdf"));

	        System.out.println( "PDF Created!" );

}
}
