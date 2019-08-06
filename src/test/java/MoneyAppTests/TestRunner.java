package MoneyAppTests;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@config_feature",
        features = "Feature"
        ,glue={"stepDefinition"}
)

public class TestRunner {
}
