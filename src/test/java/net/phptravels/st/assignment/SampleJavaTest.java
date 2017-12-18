package net.phptravels.st.assignment;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SampleJavaTest {

	@Test
	public void checkTryCatch() {
		System.out.println(this.sampleMethod());
	}
	
	public static String sampleMethod() throws ArithmeticException{
		
		try {
			WebElement myAccLink;
			/*int i =( 6/1);
			System.out.println(i);*/
			return "5";
		}
		catch(Exception e){
			return "6";
		}
		finally {
			//return "7";
		}
	}
}
