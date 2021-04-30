package CommonFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import com.relevantcodes.extentreports.LogStatus;

import Utility.launchBrowser;
import Utility.screenShots;

public class commanMethods extends launchBrowser{
	
	public static void verifyExtensionEnabled() throws SikuliException{
		
		driver.get("chrome://extensions/");
		logger.log(LogStatus.INFO, "Loaded extension screen to verify chrome extensions");

		Screen extensionScreen = new Screen();
		Pattern extensionImg = new Pattern(Utility.userData.extensionEnabledImg);
		try {
			extensionScreen.find(extensionImg);
			logger.log(LogStatus.PASS, "Grammarly extension added successfully and in enabled state.");
		}catch(Exception e) {
			logger.log(LogStatus.FAIL, "No extension added or unable to find.");
			screenShots.takeScreenshot("ScreenShort TC1");
			logger.log(LogStatus.INFO, "Screenshort :" + imgeHtmlPath);
		}
	}
	
	public static void correctingText() throws Exception {
		
		String enteredText = "responsibiliti";
		String expectedText = "responsibility";
		driver.get("https://www.rapidtables.com/tools/notepad.html");
		logger.log(LogStatus.INFO, "Loaded online notepad to enter text");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='area']")).sendKeys(enteredText);
		logger.log(LogStatus.INFO, "Entered '"+enteredText+"' incorrect text.");
		Thread.sleep(10000);

	    Actions act=new Actions(driver);							
        act.moveByOffset(90, 164).build().perform();
        logger.log(LogStatus.INFO, "Clicked on the incorrect text to load the drop down.");
        Thread.sleep(2000);
        Actions act2=new Actions(driver);
        act2.moveByOffset(90, 20).click().build().perform();
        logger.log(LogStatus.INFO, "Clicked on the correct spellings.");

		WebElement text = driver.findElement(By.xpath("//textarea[@id='area']"));
		logger.log(LogStatus.INFO, "Getting text corrected by Grammarly.");
	    String actualText = text.getAttribute("value");
		 if(actualText.equals(expectedText)) {
			 logger.log(LogStatus.PASS, "Incorrect text '"+enteredText+"' is corrected to '"+expectedText+"'");
		 }else {
			 logger.log(LogStatus.FAIL, "Text was not corrected properly Expected: "+expectedText+" and Actual: "+actualText+".");
			 screenShots.takeScreenshot("ScreenShort TC2");
			logger.log(LogStatus.INFO, "Screenshort :" + imgeHtmlPath);
		 }
	}
	
public static void invalidText() throws Exception {
		
		String invalidText = "Maninder123";
		driver.get("https://www.rapidtables.com/tools/notepad.html");
		logger.log(LogStatus.INFO, "Loaded online notepad to enter text");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='area']")).clear();
		driver.findElement(By.xpath("//textarea[@id='area']")).sendKeys(invalidText);
		logger.log(LogStatus.INFO, "Entered '"+invalidText+"' incorrect text.");
		Thread.sleep(10000);

	    Actions act=new Actions(driver);							
        act.moveByOffset(90, 164).click().build().perform();
        logger.log(LogStatus.INFO, "Clicked on the invalid text.");
        Thread.sleep(2000);
        
        Screen Screen = new Screen();
		Pattern Img = new Pattern(Utility.userData.verificationImg);
		try {
			Screen.find(Img);
			logger.log(LogStatus.FAIL, "There is suggestion drop down to correct the text.");
		}catch(Exception e) {
			logger.log(LogStatus.PASS, "There is no drop down to correct the invalid text.");
			screenShots.takeScreenshot("ScreenShort TC3");
			logger.log(LogStatus.INFO, "Screenshort :" + imgeHtmlPath);
		}

		WebElement text = driver.findElement(By.xpath("//textarea[@id='area']"));
		logger.log(LogStatus.INFO, "Getting text from notepad.");
	    String expectedText = text.getAttribute("value");
		 if(expectedText.equals(invalidText)) {
			 logger.log(LogStatus.PASS, "Invalid text '"+invalidText+"' is same as entered");
		 }else {
			 logger.log(LogStatus.FAIL, "Something went incorrect.");
			 screenShots.takeScreenshot("ScreenShort TC3.1");
				logger.log(LogStatus.INFO, "Screenshort :" + imgeHtmlPath);
		 }
	}

}
