package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class launchBrowser {
	
	protected static WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest logger;
	public static String imgeHtmlPath;
	
	public static void chromeBrowser(String url) throws Exception {
		extent = new ExtentReports (Utility.userData.extendReportLoc, true);
		System.setProperty("webdriver.chrome.driver",Utility.userData.chromeBrowserDriver);
		driver= new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
}
