package bsmartdemoshop.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue={"bsmartdemoshop.stepdefinitions","bsmartdemoshop.hooks"},
        features="src\\test\\resources\\features",
        plugin={"html:target/Bsmartcc.html","rerun:target/failedrerun.txt"}
)
public class BsmartTestngrunnerTest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
