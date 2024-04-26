package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class StepDefinitions {
	
	WebDriver driver;

@Given("user is starts {string} browser")
public void user_is_starts_browser(String browserName) {
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		driver=new FirefoxDriver();
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver=new EdgeDriver();
	}
    
}

@Given("user launch app using url {string}")
public void user_launch_app_using_url(String url) {
	
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    
}

@When("user enters text {string} into textbox using xpath {string}")
public void user_enters_text_into_textbox_using_xpath(String text, String xpath) {
   
	driver.findElement(By.xpath(xpath)).sendKeys(text);
}

@When("user clicks on button using xpath {string}")
public void user_clicks_on_button_using_xpath(String xpath) {
	
	driver.findElement(By.xpath(xpath)).click();
   
}

@Then("user verifies the title to be {string}")
public void user_verifies_the_title_to_be(String expTitle) {
   
	Assert.assertEquals(expTitle, driver.getTitle());
	
		
}

@After
public void teardown()
{
	driver.quit();
}
	
@When("user clicks on link using xpath {string}")
public void user_clicks_on_link_using_xpath(String xpath) {
    
	driver.findElement(By.xpath(xpath)).click();
}


}
