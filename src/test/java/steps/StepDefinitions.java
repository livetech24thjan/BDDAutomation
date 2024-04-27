package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.datatable.DataTable;
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


@When("user enter details in registaration form")
public void user_enter_details_in_registaration_form(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
    
	
	//List<String> dataList=dataTable.asList();
	
	List<List<String>> dataList=dataTable.asLists();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataList.get(0).get(0));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataList.get(0).get(1));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(dataList.get(0).get(2));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(dataList.get(0).get(3));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(dataList.get(0).get(4));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(dataList.get(0).get(5));
	
}

@When("user enter details in registaration form using datatable")
public void user_enter_details_in_registaration_form_using_datatable(DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.
	
	List<Map<String, String>>  dataMap=dataTable.asMaps();
	
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys(dataMap.get(0).get("username"));
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(dataMap.get(0).get("password"));
	driver.findElement(By.xpath("//input[@name='re_password']")).sendKeys(dataMap.get(0).get("confirm password"));
	driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(dataMap.get(0).get("full name"));
	driver.findElement(By.xpath("//input[@name='email_add']")).sendKeys(dataMap.get(0).get("email address"));
	driver.findElement(By.xpath("//input[@name='captcha']")).sendKeys(dataMap.get(0).get("captcha"));
	
	
   
}


}
