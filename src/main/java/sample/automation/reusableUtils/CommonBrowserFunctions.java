package sample.automation.reusableUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface CommonBrowserFunctions {

	/**
	 * Common Browser functions will be implemented from here
	 */
	public abstract void clickWebElement();

	public abstract void writeOnTextField();

	public abstract void selectDropDownByID();

	public abstract void selectDropDownByVisibleText(WebDriver driver, WebElement elem, String searchParam);

	public abstract void selectDropDownByIndex();
}
