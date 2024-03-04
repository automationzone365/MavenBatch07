package bsmartdemoshop.hooks;

import bsmartdemoshop.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BeforeAfterHook {

    public WebDriver driver;

    @Before
    public void before(Scenario scenario) throws IOException {
        System.out.println("Before Thread id: "+Thread.currentThread().getId() +" "+Thread.currentThread().getName()
        +", "+ "Scenario name :" +scenario.getName());

        driver= DriverFactory.initializeDriver();
    }

    @After
    public void after(Scenario scenario){

        driver.quit();
    }

    @AfterStep
    public void afterSteps(Scenario scenario){
        if(scenario.isFailed()){
         final byte[] screenshot=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
         scenario.attach(screenshot,"image/png","image");
        }
    }
}
