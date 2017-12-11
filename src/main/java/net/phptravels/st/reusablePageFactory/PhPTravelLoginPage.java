package net.phptravels.st.reusablePageFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;
import sample.automation.reusableUtils.Constants;

public class PhPTravelLoginPage {

	private WebDriver driver;

	
	@FindBy(xpath = "//body/div[3]//div[2]//ul[@class='nav navbar-nav']")
	WebElement languageTypeLink;
	
	@FindBy(how=How.XPATH,using="//body/div[3]//div[2]//ul[@class='nav navbar-nav']/li//li[1]/a[@id='en']")
	WebElement listEnglishLanguageLink;
	
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


	public PhPTravelLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginPhpTraverls(String uID, String pwd) {
		try {
			languageTypeLink.click();
			listEnglishLanguageLink.click();
			myAcctLink.click();
			loginLink.click();
			userNameLink.sendKeys(uID);
			pwdLink.sendKeys(pwd);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			loginBtnLink.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Assert.assertEquals("Login Successful", Constants.Login_Title, driver.getTitle());

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
