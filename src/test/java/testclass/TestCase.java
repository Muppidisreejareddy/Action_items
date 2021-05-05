package testclass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseclass.BaseClass;
import baseclass.Browser;


public class TestCase extends Browser
{
	@Test
	public void testCase()
	{
		try
		{
			logger = report.createTest("Trip Advisor");
			
			//PageBaseClass baseClass=new PageBaseClass();
			invokeBrowser("chrome");
			BaseClass pageBase = new BaseClass(driver, logger);
			PageFactory.initElements(driver, pageBase);
			landingpage=pageBase.getUrl();
			landingpage.click_HolidayHomes();
			landingpage.enterDestination();
			Thread.sleep(3000);
			nairobi_Search_Results_Page=landingpage.choose_Nairobi();
			nairobi_Search_Results_Page.choose_checkin();
			nairobi_Search_Results_Page.choose_checkout();
			nairobi_Search_Results_Page.choose_number_of_guests();
			Thread.sleep(4000);
			nairobi_Search_Results_Page.chooseSortBy();
			Thread.sleep(4000);
			nairobi_Search_Results_Page.clickAmenitiesMoreOptions();
			nairobi_Search_Results_Page.checkElevatorLiftAccess();
			Thread.sleep(4000);
			nairobi_Search_Results_Page.WriteHotelDetailsToExcel();
			nairobi_Search_Results_Page.clickThreeHotelLinks();
			cruises_page=nairobi_Search_Results_Page.clickCruises();
			cruises_page.click_cruiseLine();
			cruises_page.choose_cruise_line();
			cruises_page.click_cruiseShip();
			cruises_page.choose_cruise_ship();
			cruises_page.clickSearchButton();
			Thread.sleep(3000);
			//flushReports();
			pageBase.closeBrowser();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
