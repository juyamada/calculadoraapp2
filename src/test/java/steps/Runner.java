package steps;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"},
    monochrome = true,
    dryRun = false
)
public class Runner {
}
