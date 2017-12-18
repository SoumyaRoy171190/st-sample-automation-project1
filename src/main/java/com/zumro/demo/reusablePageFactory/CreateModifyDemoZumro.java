package com.zumro.demo.reusablePageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sample.automation.reusableUtils.CommonFunctions;

public class CreateModifyDemoZumro {

	private WebDriver driver;
	public CreateModifyDemoZumro(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//ul[@id='ShortcutsMenu']/li/a")
	WebElement createBtnLink;
	
	@FindBy(how=How.XPATH,using="//ul[@id='ShortcutsMenu']//a/span[contains(text(),'Account')]")
	WebElement createAccountDropDownLink;
	
	@FindBy(id="Account_name")
	WebElement registerAccountNameTextBoxLink;
	
	@FindBy(id="Account_officePhone")
	WebElement registerOfficePhoneTextBoxLink;
	
	@FindBy(id="Account_industry_value")
	WebElement registerAccountIndustryDropDown;
	
	@FindBy(id="Account_officeFax")
	WebElement registerAccountOfficeFax;
	
	@FindBy(id="Account_annualRevenue")
	WebElement registerAccountAnnualRevenueTextBox;
	
	@FindBy(id="Account_type_value")
	WebElement registerAccountTypeValue;
	
	@FindBy(id="Account_billingAddress_street1")
	WebElement registerAccountBillingAddStreet1TextBox;
	
	@FindBy(id="Account_billingAddress_city")
	WebElement registerAccountBillingAddCityTextBox;
	
	@FindBy(id="Account_billingAddress_state")
	WebElement registerAccountBillingAddState;
	
	@FindBy(id="Account_billingAddress_postalCode")
	WebElement registerAccountBillingAddPostalCodeTextBox;
	
	@FindBy(id="Account_billingAddress_country")
	WebElement registerAccountBillingAddCountryTextBox;
//---------------------	
	@FindBy(id="Account_shippingAddress_street1")
	WebElement registerAccountShippingAddStreet1TextBox;
	
	@FindBy(id="Account_shippingAddress_city")
	WebElement registerAccountShippingAddCityTextBox;
	
	@FindBy(id="Account_shippingAddress_state")
	WebElement registerAccountShippingAddState;
	
	@FindBy(id="Account_shippingAddress_postalCode")
	WebElement registerAccountShippingAddPostalCodeTextBox;
	
	@FindBy(id="Account_shippingAddress_country")
	WebElement registerAccountShippingAddCountryTextBox;
	
	@FindBy(id="Account_description")
	WebElement registerAccountDescriptionTextBox;
	
	@FindBy(name="save")
	WebElement registerAccountSaveBtn;
	
	public void createAccount() {
	
		Actions action = new Actions(driver);
		CommonFunctions.waitForElement(driver, createBtnLink);
		action.moveToElement(createBtnLink).build().perform();
		CommonFunctions.waitForElement(driver, createAccountDropDownLink);
		createAccountDropDownLink.click();
		
	}
}
