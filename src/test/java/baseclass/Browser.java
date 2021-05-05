package baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import baseclass.BaseClass;
import pageclasses.CruisesPage;
import pageclasses.DeckPage;
import pageclasses.LandingPage;
import pageclasses.NairobiSearchResultsPage;
import utils.ExtentReportManager;


public class Browser
{
	public WebDriver driver;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	
	public LandingPage landingpage;
	public NairobiSearchResultsPage nairobi_Search_Results_Page;
	public CruisesPage cruises_page;
	public DeckPage deck_page;
	
	public void invokeBrowser(String browserName)
	{
		try
		{
			if(browserName.equalsIgnoreCase("chrome"))
			{
				String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver();
				
				logger.log(Status.PASS,"Chrome Browser Successfully Launched");
				
				BaseClass.BaseClass(driver,logger);
				
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				String driverPath = System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", driverPath);
				driver = new EdgeDriver();
				
				logger.log(Status.PASS,"Edge Browser Successfully Launched");
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				String driverPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", driverPath);
				driver =  new FirefoxDriver();
				
				logger.log(Status.PASS,"Fiefox Browser Successfully Launched");
			}
			
			else
			{
				System.out.println("Invalid choice of browser");
			}
		}
		catch(Exception e)
		{
			logger.log(Status.FAIL,e.getMessage());
		}
	}
	
	@AfterTest
	public void flushReports() 
	{
		report.flush();
	}
	
	//Close the Driver
	public void tearDown()
	{
		driver.close();
	}
	
	//Quit the Driver
	@AfterTest
	public void closeBrowser() 
	{
		driver.quit();
	} 
}
