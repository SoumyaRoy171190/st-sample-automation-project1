package com.zumro.demo.reusablePageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;
import sample.automation.reusableUtils.CommonFunctions;
import sample.automation.reusableUtils.Constants;
import sample.automation.reusableUtils.DropDownFunctions;

public class CreateModifyDemoZumro {

	private WebDriver driver;

	public CreateModifyDemoZumro(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//ul[@id='ShortcutsMenu']/li/a")
	WebElement createBtnLink;

	@FindBy(how = How.XPATH, using = "//ul[@id='ShortcutsMenu']//a/span[contains(text(),'Account')]")
	WebElement createAccountDropDownLink;

	@FindBy(id = "Account_name")
	WebElement registerAccountNameTextBoxLink;

	@FindBy(id = "Account_officePhone")
	WebElement registerOfficePhoneTextBoxLink;

	@FindBy(id = "Account_industry_value")
	WebElement registerAccountIndustryDropDown;

	@FindBy(id = "Account_officeFax")
	WebElement registerAccountOfficeFax;

	@FindBy(id = "Account_annualRevenue")
	WebElement registerAccountAnnualRevenueTextBox;

	@FindBy(id = "Account_type_value")
	WebElement registerAccountTypeValue;

	@FindBy(id = "Account_billingAddress_street1")
	WebElement registerAccountBillingAddStreet1TextBox;

	@FindBy(id = "Account_billingAddress_city")
	WebElement registerAccountBillingAddCityTextBox;

	@FindBy(id = "Account_billingAddress_state")
	WebElement registerAccountBillingAddState;

	@FindBy(id = "Account_billingAddress_postalCode")
	WebElement registerAccountBillingAddPostalCodeTextBox;

	@FindBy(id = "Account_billingAddress_country")
	WebElement registerAccountBillingAddCountryTextBox;

	// --------Shipping Address Section-------------

	@FindBy(id = "Account_shippingAddress_street1")
	WebElement registerAccountShippingAddStreet1TextBox;

	@FindBy(id = "Account_shippingAddress_city")
	WebElement registerAccountShippingAddCityTextBox;

	@FindBy(id = "Account_shippingAddress_state")
	WebElement registerAccountShippingAddState;

	@FindBy(id = "Account_shippingAddress_postalCode")
	WebElement registerAccountShippingAddPostalCodeTextBox;

	@FindBy(id = "Account_shippingAddress_country")
	WebElement registerAccountShippingAddCountryTextBox;

	@FindBy(id = "Account_description")
	WebElement registerAccountDescriptionTextBox;

	@FindBy(name = "save")
	WebElement registerAccountSaveBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='AccountDetailsAndRelationsView']/div[2]//li[@class='juiportlet-widget AccountDetailsPortletView type-accounts']//h3")
	WebElement accountOwnerNameSection;

	/**
	 * Modify Account Part
	 */

	@FindBy(how = How.ID, using = "corp-logo")
	WebElement corporateLogoLink;

	@FindBy(id = "accounts")
	WebElement accountLink;

	@FindBy(how = How.ID, using = "AccountsSearchForm_anyMixedAttributes")
	WebElement searchAccountTextBoxLink;

	@FindBy(how = How.XPATH, using = "//li[contains(@id,'AccountDetailsAndRelationsView_1')]/div[1]//a/span[contains(text(),'Options')]")
	WebElement editProfileOptionsLink;

	@FindBy(xpath = "//li[@id='EditLinkActionElement']/a")
	WebElement editAccountListLink;

	@FindBy(xpath = "//a[contains(@id,'saveyt')]")
	WebElement editAccountSaveBtn;

	public void createAccount() {

		try {
			Actions action = new Actions(driver);
			CommonFunctions.waitForElement(driver, createBtnLink);
			action.moveToElement(createBtnLink).build().perform();
			/* CommonFunctions.waitForElement(driver, createAccountDropDownLink); */
			createAccountDropDownLink.click();
			registerAccountNameTextBoxLink.sendKeys(Constants.Register_Acc_Name);
			registerOfficePhoneTextBoxLink.sendKeys(Constants.Ofc_Phone_Register_Acc);
			new DropDownFunctions().selectDropDownByVisibleText(driver, registerAccountIndustryDropDown,
					Constants.Industry_Type_Register_Acc);
			registerAccountOfficeFax.sendKeys(Constants.Office_Fax_Register_Acc);
			registerAccountAnnualRevenueTextBox.sendKeys(Constants.Ann_Rev_Register_Acc);
			new DropDownFunctions().selectDropDownByVisibleText(driver, registerAccountTypeValue,
					Constants.Acc_Type_Register_Acc);
			registerAccountBillingAddStreet1TextBox.sendKeys(Constants.Addr__Register_Acc);
			registerAccountBillingAddCityTextBox.sendKeys(Constants.City_Register_Acc);
			registerAccountBillingAddState.sendKeys(Constants.State_Register_Acc);
			registerAccountBillingAddPostalCodeTextBox.sendKeys(Constants.Postal_Code_Register_Acc);
			registerAccountBillingAddCountryTextBox.sendKeys(Constants.Country_Register_Acc);

			registerAccountShippingAddStreet1TextBox.sendKeys(Constants.Addr__Register_Acc);
			registerAccountShippingAddCityTextBox.sendKeys(Constants.City_Register_Acc);
			registerAccountShippingAddState.sendKeys(Constants.State_Register_Acc);
			registerAccountShippingAddPostalCodeTextBox.sendKeys(Constants.Postal_Code_Register_Acc);
			registerAccountShippingAddCountryTextBox.sendKeys(Constants.Country_Register_Acc);

			registerAccountSaveBtn.click();

			CommonFunctions.waitForElement(driver, accountOwnerNameSection);
			System.out.println("Account Owners Name :" + accountOwnerNameSection.getText());
			Assert.assertEquals(Constants.Account_Creation_Success_Message, Constants.Register_Acc_Name + "w",
					accountOwnerNameSection.getText());
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

	public void modifyAccount(String accoutName, String editedContent, String changeType) {

		try {
			corporateLogoLink.click();
			accountLink.click();
			searchAccountTextBoxLink.sendKeys(accoutName);
			searchAccountTextBoxLink.sendKeys(Keys.ENTER);
			CommonFunctions.clickSearchElementFromTable(driver, accoutName);
			Actions action = new Actions(driver);
			action.moveToElement(editProfileOptionsLink).build().perform();
			editAccountListLink.click();
			registerAccountAnnualRevenueTextBox.sendKeys(editedContent);
			System.out.println("Content edited to :" + editedContent);
			editAccountSaveBtn.click();
			Assert.assertEquals(Constants.Edit_Failure_Msg, editedContent,
					CommonFunctions.editedItemCheck(driver, changeType));

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
