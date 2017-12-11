package com.automationpractice.st.reusablePageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sample.automation.reusableUtils.Constants;

public class SampleAutomationPracticeLoginPage {

	private WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//header[@id='header']/div[2]//a[contains(text(),'Sign')]")
	WebElement signInBtn;
	
	@FindBy(how=How.ID,using="email")
	WebElement userNameTextboxLink;
	
	@FindBy(how=How.NAME, using ="passwd")
	WebElement pwdTextboxLink;
	
	@FindBy(how=How.ID, using ="SubmitLogin")
	WebElement logInBtn;
	
	public SampleAutomationPracticeLoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	public void logInSampleAutomationPracticePage() {
		try {
			
			signInBtn.click();
			userNameTextboxLink.sendKeys(Constants.UserName);
			pwdTextboxLink.sendKeys(Constants.Password);
			logInBtn.click();
		}catch (NoSuchElementException e) {
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
