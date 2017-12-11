package com.sampleautomationpractice.st.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automationpractice.st.reusablePageFactory.CasualDressBookingPage;
import com.automationpractice.st.reusablePageFactory.SampleAutomationPracticeLoginPage;

import sample.automation.reusableUtils.Constants;

public class AutomatedGoodsByingApp {
	
	WebDriver driver;
	
	@Test
	public void openBrowser() {
		driver = new FirefoxDriver();
		driver.navigate().to(Constants.SampleAutomationPracticeUrl);
	}
	
	@Test(dependsOnMethods={"openBrowser"})
	public void loginToWebSite() {
		SampleAutomationPracticeLoginPage login_Page = PageFactory.initElements(driver, SampleAutomationPracticeLoginPage.class);
		login_Page.logInSampleAutomationPracticePage();
	}
	
	@Test(dependsOnMethods="loginToWebSite")
	public void buyClothes() {
		CasualDressBookingPage dressBookPage = PageFactory.initElements(driver, CasualDressBookingPage.class);
		dressBookPage.buyCasualDresses();
	}
}
