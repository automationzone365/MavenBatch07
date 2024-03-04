package bsmartdemoshop.stepdefinitions;

import bsmartdemoshop.factory.DriverFactory;
import bsmartdemoshop.pages.LandingPage;
import bsmartdemoshop.pages.PageFactoryManager;
import bsmartdemoshop.utils.ConfigLoader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPageDefinitions {

    private WebDriver driver;
    private LandingPage landingPage;
    private Logger log=null;

    public LandingPageDefinitions(){

        driver= DriverFactory.getDriver();
        log= LogManager.getLogger(LandingPageDefinitions.class);
    }
    @Given("I'm a user on the Demo web shop home page")
    public void landToDemoShopHomePage(DataTable creds){
        landingPage=PageFactoryManager.getLandingPage(driver);
        landingPage.load(ConfigLoader.getInstance().getBaseURL());
        log.info("Demo web site loaded successfully" +Thread.currentThread().getId() + Thread.currentThread().getName());
        landingPage.login(creds.asLists().get(0).get(0),creds.asLists().get(0).get(1));
        log.info("Inside the Landing page Definition" +Thread.currentThread().getId() + Thread.currentThread().getName());
    }
}
