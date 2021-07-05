package Mytest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Datec {

	public static String date() {
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy-MM-dd HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   return dtf.format(now);

	}

}
