package com.automationpractice.st.reusablePageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import sample.automation.reusableUtils.Constants;

public class CasualDressBookingPage {

	private WebDriver driver;
	public CasualDressBookingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	@FindBy(how=How.XPATH,using="//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']")
	WebElement dressesLink;
	
	@FindBy(how=How.XPATH,using="//div[@id='categories_block_left']//li[1]/a")
	WebElement casualDressLink;
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']/ul/li[1]//div[1]/a/img")
	WebElement firstAvailableCasualDress;
	
	@FindBy(how=How.XPATH,using="//p[@id='add_to_cart']/button")
	WebElement addToCartBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='layer_cart']//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutPoPUpBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutLink;
	
	@FindBy(how=How.NAME,using="processAddress")
	WebElement proceesAddressBtn;
	
	@FindBy(how=How.ID,using="cgv")
	WebElement termsOfServiceCheckBox;
	
	@FindBy(how=How.NAME,using="processCarrier")
	WebElement processCarrierBtn;
	
	@FindBy(how=How.XPATH,using="//a[@title='Pay by check.']")
	WebElement payByCheckLinks;
	
	@FindBy(how=How.XPATH,using="//p[@id='cart_navigation']/button")
	WebElement confirmOrderBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='center_column']/p[1]")
	WebElement confirmationMessagePath;
	
	public void buyCasualDresses() {
	/*	Actions builder = new Actions(driver);
		Action mouseOverDresses = builder.moveToElement(dressesLink).build();
		mouseOverDresses.perform();*/
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		dressesLink.click();
		casualDressLink.click();
		firstAvailableCasualDress.click();
		addToCartBtn.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		proceedToCheckOutPoPUpBtn = wait.until(ExpectedConditions.visibilityOf(proceedToCheckOutPoPUpBtn));
		proceedToCheckOutPoPUpBtn.click();
		proceedToCheckOutLink.click();
		proceesAddressBtn.click();
		termsOfServiceCheckBox.click();
		processCarrierBtn.click();
		payByCheckLinks.click();
		confirmOrderBtn.click();
		confirmationMessagePath = wait.until(ExpectedConditions.visibilityOf(confirmationMessagePath));
		Assert.assertEquals(confirmationMessagePath.getText(), Constants.Expected_Order_Confirmation_Message, "Order Successfully placed");
	}	
}
