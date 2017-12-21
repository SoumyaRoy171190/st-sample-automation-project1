package com.demo.zumro.st.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.zumro.demo.reusablePageFactory.CreateModifyDemoZumro;
import com.zumro.demo.reusablePageFactory.DemoZumroLogin;

import sample.automation.reusableUtils.Constants;

public class CreateAndModifySampleUser {

	WebDriver driver;

	@Test
	void openBrowser() {
		driver = new FirefoxDriver();
		driver.get(Constants.ZumroUrl);
	}

	@Test(dependsOnMethods = { "openBrowser" })
	void loginZumro() {
		DemoZumroLogin login_Zumro_Page = PageFactory.initElements(driver, DemoZumroLogin.class);
		login_Zumro_Page.loginDemoZumro();
	}

	@Test(dependsOnMethods = { "loginZumro" })
	void createModifyAccount() {
		CreateModifyDemoZumro sample_Zumro_Page = PageFactory.initElements(driver, CreateModifyDemoZumro.class);
		sample_Zumro_Page.createAccount();
		sample_Zumro_Page.modifyAccount(Constants.Register_Acc_Name, Constants.edited_Content, Constants.edited_Type);
	}
}
