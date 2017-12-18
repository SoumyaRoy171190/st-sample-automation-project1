package com.zumro.demo.reusablePageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sample.automation.reusableUtils.Constants;

public class DemoZumroLogin {

	private WebDriver driver;
	
	public DemoZumroLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.ID,using="LoginForm_username")
	WebElement zumroLoginUserName;
	@FindBy(how=How.ID,using="LoginForm_password")
	WebElement zumroLoginPassword;
	@FindBy(id="Login")
	WebElement zumroLoginBtn;
	
	public void loginDemoZumro() {
		try {
			
			zumroLoginUserName.sendKeys(Constants.Login_User_Name_ZUMRO);
			zumroLoginPassword.sendKeys(Constants.Login_Password_ZUMRO);
			zumroLoginBtn.click();
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
