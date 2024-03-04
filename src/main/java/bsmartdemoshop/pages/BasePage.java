package bsmartdemoshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    WebDriverWait wait;
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
    }

    public void load(String endPoint){
        driver.get(endPoint);
    }

    public WebElement waitForWebElementToAppear(By findBy){
      return   wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public WebElement waitForWebElementToAppear(WebElement findBy){
        return wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public WebElement waitForWebElementToClickable(By findBy){
      return   wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }
    public WebElement waitForWebElementToClickable(WebElement findBy){
       return wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public List<WebElement> waitForVisibilityofAllElements(List<WebElement> lst){
       return wait.until(ExpectedConditions.visibilityOfAllElements(lst));
    }
}
