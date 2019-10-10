package Cucumber.demotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Cucumber.demotest.pages;

public class Logintest {
	WebDriver driver;
	@Given("^user is on the home page$")
	public void user_is_on_the_home_page() throws Throwable {
		driver = UtilityDriver.openBrowser("Chrome");
		driver.get("http://demoaut.com/");
		
	}

	@When("^User enter the valid credentials$")
	public void user_enter_the_valid_credentials() throws Throwable {
		pages page= new pages(driver);
		page.do_login("tutorial", "tutorial");
	}

	@Then("^user must in home page and display success message$")
	public void user_must_in_home_page_and_display_success_message() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully !!");
		driver.close();
	}


 }
