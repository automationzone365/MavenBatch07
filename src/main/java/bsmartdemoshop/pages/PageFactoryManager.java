package bsmartdemoshop.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    public static LandingPage getLandingPage(WebDriver driver){
        return new LandingPage(driver);
    }

    public static ShoppingCartPage getShoppingCartPage(WebDriver driver){
        return new ShoppingCartPage(driver);
    }

    public static CheckOutPage getCheckoutPage(WebDriver driver){
        return new CheckOutPage(driver);
    }
}
