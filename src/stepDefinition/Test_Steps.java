package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Given("^I have launched a Firefox Browser$")
	public void i_have_launched_a_Firefox_Browser(){
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver = new FirefoxDriver(); // launch browser
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Launch the Online Store Website
        driver.get("http://www.store.demoqa.com"); // navigate to site
		
	}

	@Given("^I have added an item to my cart$")

	public void i_have_added_an_item_to_my_cart() throws Throwable {

	    // Write code here that turns the phrase above into concrete actions

	    //throw new PendingException();


	//CJM 03/10/2015

	// I would want to pass in the text component for item selection as an argument / parameter for data variance

	// or, in the context of this structure, perhaps a step definition for each data item, calling a central method for item selection based on a submitted parameter

	driver.findElement(By.xpath("//a[contains(text(),'All Product')]")).click();	
		
	driver.findElement(By.xpath("//div[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div/span/input")).click();


	//driver.findElement(By.xpath("//input[@name='Buy'])[2]")).click();


	driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]")).click();




	}



	@When("^I view the contents of my cart$")

	public void i_view_the_contents_of_my_cart() throws Throwable {

	    // Write code here that turns the phrase above into concrete actions

	    //throw new PendingException();


	driver.findElement(By.xpath("//div[@id='header_cart']/a/em[2]")).click(); // click the cart icon


	}



	@Then("^I should see the contents of the cart include the item$")

	public void i_should_see_the_contents_of_the_cart_include_the_item() throws Throwable {

	    // Write code here that turns the phrase above into concrete actions

	    //throw new PendingException();


	//again, I'd want the expected result parameter (in this case, the item text) passed into a central method for verifying the presence of link text

	//in order to support conditions for multiple datasets (i.e. select an iphone4, pass condition = iphone4 link in cart.


	driver.findElement(By.xpath("//a[contains(text(),'iPhone 5')]")).isDisplayed();

	driver.quit(); //cleanup after running scenario in case subsequent scenarios are pending.


	}

}