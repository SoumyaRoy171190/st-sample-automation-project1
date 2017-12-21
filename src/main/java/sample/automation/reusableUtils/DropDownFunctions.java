package sample.automation.reusableUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownFunctions implements CommonBrowserFunctions{

	@Override
	public void clickWebElement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeOnTextField() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectDropDownByID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectDropDownByIndex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectDropDownByVisibleText(WebDriver driver, WebElement elem, String searchParam) {
		Select sel = new Select(elem);
		sel.selectByVisibleText(searchParam);
	}

}
