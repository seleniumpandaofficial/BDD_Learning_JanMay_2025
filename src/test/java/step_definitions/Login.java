package step_definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	public WebDriver driver;
	
	@Before
	public void loginSetup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	
	@Given("User navigates to LoginPage")
	public void user_navigates_to_loginPage() {
		Assert.assertTrue(driver.findElement(By.cssSelector("input.btn.btn-primary")).isDisplayed());
	}
	
	@When("^User enters valid email (.+) into email textBox$")
	public void user_enters_valid_email(String emailText) {
		driver.findElement(By.id("input-email")).sendKeys(emailText);
	}
	
	 @And("^User enters valid password (.+) into password textBox$")
	 public void user_enters_valid_password(String passwordText) {
		 driver.findElement(By.id("input-password")).sendKeys(passwordText); 
	 }
	 
	 @And("User enters invalid password {int} into password textBox")
	 public void user_enters_invalid_password_in_integer(Integer passwordInt) {
		 driver.findElement(By.id("input-password")).sendKeys(passwordInt.toString()); 
	 }
	 
	 @And("User clicks on Login button")
	 public void user_clicks_on_login_button() {
		 driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	 }
	 
	 @Then("User is re-directed to AccountPage")
	 public void user_is_redirected_to_accountPage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Logout"))));
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	 }
	 
	 @When("User enters invalid email {string}")
	 public void user_enters_invalid_email(String invalidEmailText) {
		 driver.findElement(By.id("input-email")).sendKeys(invalidEmailText); 
	 }
	 
	 @And("User enters invalid password {string}")
	 public void user_enters_invalid_password(String invalidPasswordText) {
		 driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText); 
	 }
	 
	 @Then("User gets warning message about credentials mismatch")
	 public void user_gets_warning_message_about_credentials_mismatch() {
		 String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, ' alert-dismissible')]")).getText();
		 String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		 Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	 }
	 
	 @After
	 public void teardown() {
		 driver.quit();
	 }

}
