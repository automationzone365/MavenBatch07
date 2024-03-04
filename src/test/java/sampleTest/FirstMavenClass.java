package sampleTest;

import bsmartdemoshop.factory.DriverFactory;
import bsmartdemoshop.pages.LandingPage;
import bsmartdemoshop.pages.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class FirstMavenClass {

    @Test
    public  void firstTest() throws IOException {
        System.out.println("Thread id:="+Thread.currentThread().getId()+ " "+ Thread.currentThread().getName());
        WebDriver driver = DriverFactory.initializeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        LandingPage landingPage = PageFactoryManager.getLandingPage(DriverFactory.getDriver());
        landingPage.login("planittest78@gmail.com","123456");
        driver.quit();
    }


}
