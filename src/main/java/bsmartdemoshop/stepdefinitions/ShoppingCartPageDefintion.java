package bsmartdemoshop.stepdefinitions;

import bsmartdemoshop.factory.DriverFactory;
import bsmartdemoshop.pages.LandingPage;
import bsmartdemoshop.pages.PageFactoryManager;
import bsmartdemoshop.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ShoppingCartPageDefintion {
    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartPageDefintion(){

        driver= DriverFactory.getDriver();
        shoppingCartPage= PageFactoryManager.getShoppingCartPage(driver);
    }

    @When("I add a product \"(.*)\" with quantity \"(.*)\" to the cart$")
    public void addProduct(String product, String qty) throws InterruptedException {
       if(!shoppingCartPage.getCartQty().equals("(0)")){
        System.out.println("The shopping is not empty");
        shoppingCartPage.navToShoppingCart();
        shoppingCartPage.clearCart();
        Assert.assertEquals(shoppingCartPage.getEmptymsg(),"Your Shopping Cart is empty!");

       }
        shoppingCartPage.navToProductMainCategory("Computers");
        shoppingCartPage.navToProductSubCategory("Desktops");
        shoppingCartPage.selProduct(product);
        shoppingCartPage.setQuantity(qty);
        shoppingCartPage.addToCart();

    }

    @Then("I should see {string}")
    public void iShouldSee(String successMsg) {
        Assert.assertEquals(shoppingCartPage.getNotification().trim(),successMsg.trim());
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        shoppingCartPage.clsNotification();
        shoppingCartPage.navToShoppingCart();
        shoppingCartPage.agreeWithTerms();
        shoppingCartPage.checkOut();
    }
}
