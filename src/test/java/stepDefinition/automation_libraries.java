package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class automation_libraries {
	
	public static WebDriver SelDriverInit(String browser) {
		
		WebDriver dr = null;
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows XP");
			caps.setCapability("version", "66.0");
			dr =new ChromeDriver(); // Initialize browser
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.marionette","src/test/resources/geckodriver.exe");
			dr = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
			ieCaps.setCapability("nativeEvents", true);
			ieCaps.setCapability("unexpectedAlertBehaviour", "accept");
			ieCaps.setCapability("ignoreProtectedModeSettings", true);
			ieCaps.setCapability("disable-popup-blocking", true);
			ieCaps.setCapability("enablePersistentHover", true);
			ieCaps.setCapability("ignoreZoomSetting", true);
			ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://www.bing.com/");
			
			dr = new InternetExplorerDriver();
			//Below is solution for IE bug: Currently focused window has been closed
			//https://stackoverflow.com/questions/47388733/selenium-org-openqa-selenium-nosuchwindowexception-currently-focused-window-ha
			//https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver#required-configuration
		}
		return dr;
	}
	
	//add section for IE
	
	//add section for Firefox
	
	
}
