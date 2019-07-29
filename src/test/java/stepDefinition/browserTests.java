package stepDefinition;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.*;

public class browserTests {

	WebDriver wd = automation_libraries.SelChromeDriverInit();
	
	@Given("^I have opened the website$")
	public void i_have_opened_the_website() throws Exception {
		System.out.println("In Given");
		//Initialize the driver as Global above...
		wd.get("https://www.booking.com"); // Open URL
		wd.manage().window().maximize();
		Thread.sleep(2500);
		wd.findElement(By.xpath("//span[text()='Sign in']")).click();
		//relative Xpath explanation: //type[property='value' or/and <repeat..>]
		
	}
	
	
	@When("^I provide my Username & Password and click Login$")
	public void i_provide_my_username_password_click_login() throws Exception {
		System.out.println("In When");
		String usr = "susmitaghosh.kol@gmail.com";
		String pw  = "Test@123";
		wd.findElement(By.id("username")).sendKeys(usr);
		wd.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2500); //wait few sec till next page to provide password is loaded
		wd.findElement(By.id("password")).sendKeys(pw);
		wd.findElement(By.xpath("//span[text()='Sign in']")).click();
	}
	
	
	@Then("^I am able to access my Homepage$")
	public void i_am_able_to_access_my_homepage() throws Exception {
		System.out.println("In Then");
		Thread.sleep(3500); //wait few sec till next page to provide password is loaded
		//wd.findElement(By.xpath("//span[text()='Sign in']")).click();
		//String bodyText = wd.findElement(By.tagName("body")).getText();
		String bodyText = wd.findElement(By.xpath("//span[contains(@class, 'user_firstname')]")).getText();
		System.out.println(bodyText);
		Assert.assertTrue("First Name not found!", bodyText.contains("Susmita1"));
		wd.close();
	}
	
}
