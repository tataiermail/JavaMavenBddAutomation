package stepDefinition;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class automation_libraries {
	
	public static WebDriver SelChromeDriverInit() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\tatai\\Dropbox\\Career\\Skills\\Java_misc\\chromedriver.exe");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows XP");
		caps.setCapability("version", "66.0");
		WebDriver driver=new ChromeDriver(); // Initialize browser
		return driver;
	}
	
	
}
