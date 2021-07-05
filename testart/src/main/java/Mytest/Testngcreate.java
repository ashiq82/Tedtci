package Mytest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import mypack.testtt;

public class Testngcreate {
	
	public static File f1;
	public static String tcname;
	public static ArrayList<Class<? extends ITestNGListener>> list;
	
public static List<XmlSuite> testngt() throws IOException, ClassNotFoundException {
		
		tcname = testtt.getname();
		String date =Datec.date();
		
		f1= new File(Location.TestResult+"Result "+tcname+" "+date);
		f1.mkdir();
		File f = new File(f1+"\\Result "+tcname+date+".xml");
		
		
		BufferedWriter br = new BufferedWriter(new FileWriter(f));
		
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Suite");
		suite.setThreadCount(1);
		
		XmlTest test = new XmlTest(suite);
		test.setName(tcname);
		
		ArrayList<String> k =testtt.allname();
		int count =k.size();
		List<XmlClass> li = new ArrayList<XmlClass>();
		List<XmlSuite> suli = new ArrayList<XmlSuite>();
		list =new ArrayList<Class<? extends ITestNGListener>>();
		
		for(int i=0;i<count;i++)
		{
			String name =k.get(i);
			XmlClass cls = new XmlClass("Mytest."+name);
			li.add(cls);
			
		}
		list.add(Listener.class);
		test.setXmlClasses(li);
		br.write(suite.toXml());
		br.close();
		suli.add(suite);
		
		System.out.println("Testng xml successfully created..!");
		return suli;
		
		
	   
	}





}
