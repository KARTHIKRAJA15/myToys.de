package myToys.de.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import myToys.de.resource.CommonActions;

public class Hooks extends CommonActions{
	CommonActions ca = new CommonActions();
	@Before
	public void beforeLaunch() {
		System.out.println("browser launched");
	}
	@After
	public void afterLaunch(Scenario scenario) {
		//driver.quit();
		System.out.println("brower quit");
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");	
		}else {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");	
		}
		
	}
}
