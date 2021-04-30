package Utility;

public interface userData {

	String URL = "https://chrome.google.com/webstore/detail/grammarly-for-chrome/kbfnbcaeplbcioakkpcpgfkobkghlhen?hl=en";
	String chromeBrowserDriver = System.getProperty("user.dir")+"\\browserDriver\\chromedriver.exe";
	String extendReportLoc = System.getProperty("user.dir") +"\\ExtentReport\\Output\\Report.html";
	String extensionEnabledImg = System.getProperty("user.dir")+"\\icons\\enableBtn.png";
	String addExtensionBtnImg = System.getProperty("user.dir")+"\\icons\\addExtensionBtn.png";
	String verificationImg = System.getProperty("user.dir")+"\\icons\\verifyImg.png";
	String extentReportScreenshotFolder = System.getProperty("user.dir") + "\\ExtentReport\\Output\\Screenshots\\";
}
