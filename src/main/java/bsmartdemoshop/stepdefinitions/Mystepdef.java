package bsmartdemoshop.stepdefinitions;

import bsmartdemoshop.factory.DriverFactory;
import bsmartdemoshop.pages.LandingPage;
import bsmartdemoshop.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Mystepdef {

    @Given("I am on the demo store page")
    public void logintoApplication() throws IOException {
        System.out.println("Thread id:="+Thread.currentThread().getId()+ " "+ Thread.currentThread().getName());
        WebDriver driver = DriverFactory.initializeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        LandingPage landingPage = PageFactoryManager.getLandingPage(DriverFactory.getDriver());
        landingPage.login("planittest78@gmail.com","123456");
    }
}
