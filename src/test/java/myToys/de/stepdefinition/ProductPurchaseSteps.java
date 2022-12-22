package myToys.de.stepdefinition;

import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import myToys.de.repository.ProductPurchasePage;
import myToys.de.resource.CommonActions;

public class ProductPurchaseSteps extends ProductPurchasePage{
	CommonActions ca = new CommonActions();

	
	@Given("user launch url")
	public void user_launch_url() {
		try {
	  ca.chromelaunch("https://www.mytoys.de/");
	  Thread.sleep(5000);
	  WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		cookies.click();
		}catch(Exception e) {
			System.out.println(e);
		}
	  
	}
	ProductPurchasePage ppp = new ProductPurchasePage();
	@When("user search product")
	public void user_search_product() {
		try {
		WebElement productList = driver.findElement(By.xpath("//span[@data-wt-name='top.spielzeug']"));
		productList.click();
		}catch(Exception e) {
			System.out.println(e);
			
		}
	}

	@When("user select product")
	public void user_select_product() {
		try {
		WebElement scrollElement = driver.findElement(By.xpath("(//div[class='view-options view-options--top']|//div[@class='sort'])[1]"));
		ca.scrollup(scrollElement, 0);
		WebElement selectProduct = driver.findElement(By.xpath("(//a[@class='prod-tile__link js-prodlink'])[1]"));
		selectProduct.click();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Then("user add in the cart")
	public void user_add_in_the_cart() {
		try {
		String parentWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		for(String x : childWindow) {
			if(!parentWindow.equals(x)) {
			driver.switchTo().window(x);
		}
		}
		Thread.sleep(5000);
		WebElement element4 = driver.findElement((By) ppp.getToTheCart());
		ca.click(element4);
		ca.screenshot("C:\\Users\\rakar\\OneDrive\\Desktop");
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}
