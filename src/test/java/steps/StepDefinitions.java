package steps;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import exceptions.InvalidBrowserException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

	WebDriver driver;

	@Given("user starts {string} browser")
	public void user_starts_browser(String browserName) {
		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();

			break;
		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "edge":
			driver = new EdgeDriver();

			break;

		default:
			try {
				throw new InvalidBrowserException();
			} catch (InvalidBrowserException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	@Given("user lauch app using url {string}")
	public void user_lauch_app_using_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@When("user enters text {string} in textbox using xpath {string}")
	public void user_enters_text_in_textbox_using_xpath(String text, String xpath) {

		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	@When("user clicks button using xpath {string}")
	public void user_clicks_button_using_xpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	@Then("user validates the profilepicture using xpath {string}")
	public void user_validates_the_profilepicture_using_xpath(String xpath) {
		Assert.assertTrue(driver.findElement(By.xpath(xpath)).isDisplayed());
	}

	@Then("user validates Title to be {string}")
	public void user_validates_title_to_be(String exptitle) {
		assertTrue("Titles Matched", driver.getTitle().equals(exptitle));
	}

	@When("user clicks on the link using xpath {string}")
	public void user_clicks_on_the_link_using_xpath(String xpath) {
	    driver.findElement(By.xpath(xpath)).click();
	}
	
	@When("user enter captcha manually")
	public void user_enter_captcha_manually() {
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Pauses the test for 30 seconds
	}
	@When("user clicks on the checkbox by using xpath {string}")
	public void user_clicks_on_the_checkbox_by_using_xpath(String xpath) {
	   driver.findElement(By.xpath(xpath)).click();
	}

	
	@When("user enters details in new user registration form")
	public void user_enters_details_in_new_user_registration_form(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> allData=dataTable.asLists();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get(0));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get(1));
		driver.findElement(By.xpath("//input[@id='re_password']")).sendKeys(allData.get(0).get(2));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get(3));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get(4));
	}

	
	@When("user enters details in new user registration form using mapping")
	public void user_enters_details_in_new_user_registration_form_using_mapping(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String, String>> allData=dataTable.asMaps(); 
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(allData.get(0).get("Username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(allData.get(0).get("Password"));
		driver.findElement(By.xpath("//input[@id='re_password']")).sendKeys(allData.get(0).get("Confirm Password"));
		driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(allData.get(0).get("Full Name"));
		driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(allData.get(0).get("Email ID"));
	}

	@Then("user waiting some seconds")
	public void user_waiting_some_seconds() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	// hooks
	@After
	public void tearDown() {
		driver.quit();
	}
}
