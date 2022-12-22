package myToys.de.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/FEATURE" 
,glue = {"myToys.de.stepdefinition","myToys.de.resource","myToys.de.repository"}
,plugin = {"html:target","json:target/reports.json"},monochrome = true,dryRun = false)

public class TestRunner {
	
}
