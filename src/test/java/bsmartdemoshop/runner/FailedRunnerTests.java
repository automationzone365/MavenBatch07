package bsmartdemoshop.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        glue={"bsmartdemoshop.stepdefinitions","bsmartdemoshop.hooks"},
        features="@target/failedrerun.txt",
        plugin={"html:target/Bsmartcc.html"}
)
public class FailedRunnerTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
