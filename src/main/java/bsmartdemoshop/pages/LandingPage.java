package bsmartdemoshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{

   // private WebDriver driver;
    @FindBy(css="a.ico-login")
    private WebElement loginLnk ;

    @FindBy(css="input#Email")
    private WebElement emailTbx;

    @FindBy(css="input#Password")
    private WebElement passwdTbx;

    @FindBy(css="input.login-button")
    private WebElement loginBtn;
    private Logger log=null;

    public LandingPage(WebDriver driver){
        super(driver);
        log= LogManager.getLogger(LandingPage.class);
    }

    public void login(String email, String password){
        waitForWebElementToClickable(loginLnk);
        loginLnk.click();
        log.info("Login clicked successfully" +Thread.currentThread().getId() + Thread.currentThread().getName());

        waitForWebElementToAppear(emailTbx);
        emailTbx.sendKeys(email);
        log.info("Email entered successfully" +email +" "+Thread.currentThread().getId() + Thread.currentThread().getName());
        waitForWebElementToAppear(passwdTbx);
        passwdTbx.sendKeys(password);

        waitForWebElementToClickable(loginBtn);
        log.error("Login button is not clicked");
        loginBtn.click();
    }
}
