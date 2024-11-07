package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
        features = {"src/test/java/features/login.feature"},
        dryRun = true,  // Check if all step definitions are present without running the tests
        glue = {"stepDefinition" , "hooks"},  // Path to the step definitions and hooks file
        monochrome = true,
        plugin = {
                "pretty",
                "html:reportss/cucumber/report.html",// Generates an HTML report
                "json:reportss/cucumber/report.json"  // Generates a JSON report for results
        },
        snippets = SnippetType.CAMELCASE,  // Sets snippet generation to camelCase
        tags = "@regression or @smoke"           // Run scenarios with @regression or @smoke tags
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
