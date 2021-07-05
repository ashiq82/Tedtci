package Mytest;

import org.testng.TestNG;

public class Runner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("Execution Started....!");
		Location.Configutaion();
		TestNG testds = new TestNG();
		testds.setXmlSuites(Testngcreate.testngt());
		testds.setListenerClasses(Testngcreate.list);
		
		testds.run();
		

	}

}
