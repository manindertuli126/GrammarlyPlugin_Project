package TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.launchBrowser;

public class GM_Test_Cases extends launchBrowser{

	
	@BeforeTest
	public void loadBrowser () throws Exception {
		launchBrowser.chromeBrowser(Utility.userData.URL);
	}
	
	@Test(priority = 1)
	public void GM_TC_001() throws Exception {
		logger = extent.startTest("GM_TC_001","Verify the default state of Grammarly Plugin.");
		CommonFunctions.addExtension.addChromeExtension();
		CommonFunctions.commanMethods.verifyExtensionEnabled();
	}
	
	@Test(priority = 2)
	public void GM_TC_002() throws Exception {
		logger = extent.startTest("GM_TC_002","POSITIVE - Verify incorrect spellings are correctled by Grammarly.");
		CommonFunctions.commanMethods.correctingText();
		
	}
	
	@Test(priority = 3)
	public void GM_TC_003() throws Exception {
		logger = extent.startTest("GM_TC_003","NEGATIVE - Verify invalid entered text is not corrected by Grammarly.");
		CommonFunctions.commanMethods.invalidText();
	}
	
	@AfterClass
	public void report () {
		Utility.quitBrowser.quitChromeBrowser();
	}

}
