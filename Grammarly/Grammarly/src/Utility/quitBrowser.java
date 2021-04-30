package Utility;

import org.openqa.selenium.By;

public class quitBrowser extends launchBrowser{
	
	public static void quitChromeBrowser() {

		extent.endTest(logger);
		extent.flush();
		
		driver.get(userData.extendReportLoc);
		driver.findElement(By.xpath("//nav/ul/li[@class='theme-selector']")).click();
	}

}
