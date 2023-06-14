package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        features = {"src/test/resources/features/logout/logout.feature"},
        glue = "stepdefinition.logout",
        plugin = {"pretty", "html:target/cucumber-reports_logout.html"}
)
public class LogoutTestRunner {
}
