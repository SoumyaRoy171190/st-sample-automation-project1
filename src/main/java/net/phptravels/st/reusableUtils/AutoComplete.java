package net.phptravels.st.reusableUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutoComplete {

	public static void autoCompleteLocationSearch(WebDriver driver, String xpathOfListXpath,  String actualSearchString) {
		
		List<WebElement> locationLists = driver.findElements(By.xpath(xpathOfListXpath));
		for(int i = 1; i<= locationLists.size(); i++) {
			if (driver.findElement(By.xpath(xpathOfListXpath+"["+i+"]//span")).getText().equalsIgnoreCase(actualSearchString)) {
				driver.findElement(By.xpath(xpathOfListXpath+"["+i+"]")).click();
				break;
			}else {
				System.out.println("No Search Result for given Location String");
			}
		}
	}
}
