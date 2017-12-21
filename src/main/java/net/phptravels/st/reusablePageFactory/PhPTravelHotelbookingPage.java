package net.phptravels.st.reusablePageFactory;

import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import sample.automation.reusableUtils.Constants;

public class PhPTravelHotelbookingPage {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//body/nav[1]//li[2]/a")
	WebElement hotelsLink;

	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[3]//div[6]//span[contains(text(),'Modify')]")
	WebElement modifySearchLink;

	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[3]//div[4]//span[contains(text(),'Filter')]")
	WebElement filterSearchLink;

	@FindBy(how = How.ID, using = "1")
	WebElement oneStarHotelRatingRadioBtnFilter;

	@FindBy(how = How.ID, using = "2")
	WebElement twoStarHotelRatingRadioBtnFilter;

	@FindBy(how = How.ID, using = "3")
	WebElement threeStarHotelRatingRadioBtnFilter;

	@FindBy(how = How.ID, using = "4")
	WebElement fourStarHotelRatingRadioBtnFilter;

	@FindBy(how = How.ID, using = "5")
	WebElement fiveStarHotelRatingRadioBtnFilter;

	@FindBy(how = How.XPATH, using = "//form[@autocomplete='off']/div[1]/div/div[2]/input")
	WebElement locationSearchInputBox;

	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']/ul/li/ul/li[1]")
	WebElement autoCompleteSearchLink;

	@FindBy(how = How.NAME, using = "checkin")
	WebElement checkInField;

	@FindBy(how = How.NAME, using = "checkout")
	WebElement checkOutField;

	@FindBy(how = How.NAME, using = "travellers")
	WebElement noOfTravellerField;

	// @FindBy(how=How.XPATH,using="//div[@id='collapse3']//input[@id='Hotel']")
	@FindBy(how = How.ID, using = "Hotel")
	WebElement hotelCheckBoxFilter;

	@FindBy(how = How.ID, using = "searchform")
	WebElement seachFilterFormLink;

	@FindBy(how = How.XPATH, using = "//div[@id='dpd2']/following-sibling::div//button[contains(text(),'Search')]")
	WebElement hotelSearchBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[7]//table[@class='bgwhite table table-striped']/tbody/tr[1]//h4/a")
	WebElement firstHotelSearchResultLink;

	@FindBy(how = How.XPATH, using = "//section[@id='ROOMS']//table/tbody/tr[1]//button[@type='submit'][contains(text(),'Book')]")
	WebElement firstSearchRoomBookNowBtn;

	@FindBy(how = How.ID, using = "username")
	WebElement userNameTextBoxRoomBooking;

	@FindBy(how = How.ID, using = "password")
	WebElement passwordTextBoxRoomBooking;

	@FindBy(how = How.XPATH, using = "//span[@id='waiting']/following-sibling::button[contains(text(),'CONFIRM')]")
	WebElement bookingConfirmBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[2]//div[@class='acc_section']//li[2]/a")
	WebElement bookingConfirmSignInLink;

	@FindBy(how = How.XPATH, using = "//div[@id='body-section']/div[1]/div/div[3]//button[1]")
	WebElement payOnArrivalBtn;

	public PhPTravelHotelbookingPage(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * public static String hotelRatingXpathPrefix =
	 * "//div[@class='rating']//input[@id='"; public static String
	 * hotelRatingXpathSuffix = "']";
	 */

	/**
	 * @author SoumyaRoy Booking a Hotel on the basis of Filter Section
	 */
	public void bookHotelByFilterSection(String star) {

		try {
			hotelsLink.click(); // clicking on Hotel link
			filterSearchLink.click(); // clicking on filter icon

			/**
			 * clicking on the hotel star cltegory checkbox
			 */
			switch (star) {
			case "1":
				oneStarHotelRatingRadioBtnFilter.click();
				break;
			case "2":
				twoStarHotelRatingRadioBtnFilter.click();
				break;
			case "3":
				threeStarHotelRatingRadioBtnFilter.click();
				break;
			case "4":
				fourStarHotelRatingRadioBtnFilter.click();
				break;
			case "5":
				fiveStarHotelRatingRadioBtnFilter.click();
				break;
			}

			hotelCheckBoxFilter.click(); // clicking on the Hotel check box
			seachFilterFormLink.click(); // clicking on search btn from form Filter
			hotelSearchBtn.click(); // clicking on Search Btn
			firstHotelSearchResultLink.click(); // clicking on first hotel from the search list
			firstSearchRoomBookNowBtn.click(); // clicking on first room from the search list
			bookingConfirmSignInLink.click(); // clicking on SignIn link
			userNameTextBoxRoomBooking.sendKeys(Constants.UserName);
			; // typing userName
			passwordTextBoxRoomBooking.sendKeys(Constants.Password); // typing Password
			bookingConfirmBtn.click(); // clicking on booking confirm btn
			payOnArrivalBtn.click(); // confirming payOnBtn

			driver.switchTo().alert().accept(); // accepting the alert coming
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
