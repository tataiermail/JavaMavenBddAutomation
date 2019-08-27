package stepDefinition;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;


public class automation_libraries {
	
	public static WebDriver SelDriverInit(String browser) {
		
		WebDriver dr = null;
		String hubURL = "http://192.168.99.100:4444/wd/hub";
		
		if (browser.equalsIgnoreCase("Grid-Win-Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			//caps.setCapability("platform", "Windows XP");
	        DesiredCapabilities caps = DesiredCapabilities.chrome();
	        caps.setBrowserName("chrome");
	        //caps.setCapability("version", "66.0");
	        caps.setPlatform(Platform.WIN10);
	        try {
				dr = new RemoteWebDriver(new URL(hubURL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("Grid-Linux-Firefox")) {
			//System.setProperty("webdriver.firefox.marionette","src/test/resources/geckodriver.exe");
	        DesiredCapabilities caps = DesiredCapabilities.firefox();
	        caps.setCapability("acceptInsecureCerts", false);
	        caps.setBrowserName("firefox");
	        //caps.setCapability("version", "44.0.2");
	        caps.setPlatform(Platform.LINUX);
			try {
				dr = new RemoteWebDriver(new URL(hubURL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("Grid-Linux-Chrome")) {
	        DesiredCapabilities caps = DesiredCapabilities.chrome();
	        caps.setBrowserName("chrome");
	        //caps.setCapability("version", "66.0");
	        caps.setPlatform(Platform.LINUX);
			try {
				dr = new RemoteWebDriver(new URL(hubURL), caps);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows XP");
			caps.setCapability("version", "66.0");
			dr =new ChromeDriver(); // Initialize browser
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.firefox.marionette","src/test/resources/geckodriver.exe"); //for Older version of Firefox
			System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe"); 	//correct for FF version 53 and up on Selenium 3.5 or higher
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true"); 		//Reduce Console logs
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");  		//Reduce Console logs
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

	
	
}
