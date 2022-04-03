package co.com.yourlogo.webproject.test.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/cart.feature"},
        glue = {"co.com.yourlogo.webproject.test.stepdefinition"},
        publish = true
)
public class CartTestRunner {
}
