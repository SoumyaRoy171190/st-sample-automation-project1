package st.phptravels.net.reusablePageFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhPLoginPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='navbar navbar-static-top navbar-default ']//li[@id='li_myaccount']")
	WebElement myAcctLink;

	@FindBy(xpath = "//div[@class='navbar navbar-static-top navbar-default ']//li[@id='li_myaccount']//a[contains(text(),'Login')]")
	WebElement loginLink;

	@FindBy(name = "username")
	WebElement userNameLink;

	@FindBy(name = "password")
	WebElement pwdLink;

	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Login')]")
	WebElement loginBtnLink;

	public PhPLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginPhpTraverls(String uID, String pwd) {
		try {
			myAcctLink.click();
			loginLink.click();
			userNameLink.sendKeys(uID);
			pwdLink.sendKeys(pwd);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			loginBtnLink.click();

			System.out.println("Login Successful");

		} catch (NoSuchElementException e) {
			System.out.println("Exception occurred :" + e.getMessage());
		} catch (ElementNotVisibleException e) {
			System.out.println("Exception occurred :" + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Exception occurred :" + e.getMessage());
		} catch (WebDriverException e) {
			System.out.println("Exception occurred :" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception occurred :" + e.getMessage());
		}
	}
}
