package sample.automation.reusableUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonFunctions {

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
	
	public static void waitForElement (WebDriver driver, WebElement elem) {
		Wait<WebDriver> wait= new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
/*			WebElement targetElem = wait.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver t) {
				return elem;
			}
		});*/
			elem = wait.until(ExpectedConditions.visibilityOf(elem));
	}
}
