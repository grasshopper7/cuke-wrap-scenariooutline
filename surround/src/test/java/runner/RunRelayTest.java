package runner;

import cucumber.api.SnippetType;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@Relay" }, snippets = SnippetType.CAMELCASE, glue = { "stepdef" },
		features = { "src/test/resources/features/relay.feature" })
public class RunRelayTest
{
}
