package Cucumber.demotest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class pom {
WebDriver driver;
WebDriverWait wait;
By username=By.name("userName");
By password=By.name("paswword");
By loginbtn=By.name("login");
	@Given("^is on the home page$")
	public void is_on_the_home_page() throws Throwable {
	    driver=UtilityDriver.openBrowser("Chrome");
	    driver.get("http://demoaut.com/");
	    
	}

	@When("^enter the valid credentials$")
	public void enter_the_valid_credentials() throws Throwable {
		driver.findElement(username).sendKeys("tutorial");
		driver.findElement(password).sendKeys("tutorial");
		driver.findElement(loginbtn).click();
	   
	    
	}

	@Then("^must in home page and display success message$")
	public void must_in_home_page_and_display_success_message() throws Throwable {
		wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
		System.out.println("logged in successfully !!");
		driver.close();
	    
	}

}
