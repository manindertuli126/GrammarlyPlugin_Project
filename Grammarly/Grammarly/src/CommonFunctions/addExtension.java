package CommonFunctions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.relevantcodes.extentreports.LogStatus;

import Utility.launchBrowser;

public class addExtension extends launchBrowser{
	
	public static void addChromeExtension() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpaths.addToChromeBtn)).click();
		logger.log(LogStatus.INFO, "Clicked on the 'Add to Chrome' button to add the extension.");
		Thread.sleep(3000);
		
		Screen screen = new Screen();
		Pattern pattern = new Pattern(Utility.userData.addExtensionBtnImg);
		screen.click(pattern);
		logger.log(LogStatus.INFO, "Clicked on the 'Add Extension' button.");
		Thread.sleep(20000);
		logger.log(LogStatus.INFO, "Waiting for Grammarly home page to load.");
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    logger.log(LogStatus.INFO, "Closed extra tabs and moved back to default tab.");
	}

}
