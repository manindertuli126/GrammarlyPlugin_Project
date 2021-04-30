package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class screenShots extends launchBrowser{
	
	public static void takeScreenshot(String SSname) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		
		FileUtils.copyFile(scrFile, new File(userData.extentReportScreenshotFolder+SSname+".png")); 
		imgeHtmlPath=logger.addScreenCapture(userData.extentReportScreenshotFolder+SSname+".png").replace(userData.extentReportScreenshotFolder, "Screenshots\\").replace("file:///", "").replace("<img", "<img width=\"150\" height=\"70\"");                                
               
      
	} catch (IOException e) {
		throw new java.lang.RuntimeException("RUNTIME_ERROR : : Exception occur during take ScreenShot: "+SSname);
	}
}

}
