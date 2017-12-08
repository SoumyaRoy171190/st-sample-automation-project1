package net.phptravels.st.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import net.phptravels.st.reusablePageFactory.PhPTravelHotelbookingPage;
import net.phptravels.st.reusablePageFactory.PhPTravelLoginPage;
import net.phptravels.st.reusableUtils.Constants;


public class AutomatedHotelBookingApp {

	WebDriver driver = new FirefoxDriver();
	//WebDriver driver = new ChromeDriver();

	@Test
	public void openBrowser() {
		
		driver.get(Constants.TravelsUrl);
	}

	@Test(dependsOnMethods = {"openBrowser"})
	public void loginToWebsite() {

		PhPTravelLoginPage login_Page = PageFactory.initElements(driver, PhPTravelLoginPage.class);
		login_Page.loginPhpTraverls(Constants.UserName, Constants.Password);
	}

	@Test(dependsOnMethods = {"loginToWebsite"})
	public void bookHotel() {
		
		PhPTravelHotelbookingPage book_hotel = PageFactory.initElements(driver, PhPTravelHotelbookingPage.class);
		book_hotel.bookHotelByFilterSection(Constants.Hotel_Three_Star);
	}
}
