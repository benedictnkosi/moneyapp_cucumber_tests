package MoneyAppTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@login_feature",
        features = "Feature"
        ,glue={"stepDefinition"}
)

public class TestRunner {
}
