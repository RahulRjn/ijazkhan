package Cucumber.demotest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SeleniumCucudemo1 {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^Launch the AUT in the browser$")
	public void beforeTest() throws Throwable {
		driver=UtilityDriver.openBrowser("Chrome");
		driver.get("http://demoaut.com/");
	}
	
	@When("^Enter the credentials and perform login$")
	public void doLogin() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
	}
	
	@Then("^Test if login works correctly$")
	public void afterTest() throws Throwable {
		wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
		System.out.println("logged in successfully !!");
		driver.close();
	}

}
