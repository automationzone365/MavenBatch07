package bsmartdemoshop.pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    @FindBy(css="span.cart-qty")
    private WebElement cartQuantitySpan;

    @FindBy(css="li#topcartlink a")
    private WebElement shoppingCartLink;

    @FindBy(css="[name=removefromcart]")
    private List<WebElement> removeCartitemsChkbxLst;

    @FindBy(css="input[name=updatecart]")
    private WebElement updateShoppingCartBtn;

    @FindBy(css="#bar-notification")
    private WebElement notificationMsg;

    @FindBy(css=".order-summary-content")
    private WebElement emptyCart;

    @FindBy(css="ul.top-menu>li:nth-child(2)>a")
    private WebElement productCompCategory;

    @FindBy(xpath="//input[@id=\"addtocart_74_EnteredQuantity\"]")
    private WebElement prodQtyInputcls;

    @FindBy(css="input.add-to-cart-button")
    private WebElement addToCartBtn;
    //ul.top-menu>li:nth-child(2)>a
    //ul[@class='top-menu']//a[@href="/computers"]
    //ul[@class='top-menu']//a[contains(text(),"computers")]
    //ul[@class='top-menu']//a[contains(text(),"Desktops")]

    @FindBy(css="#bar-notification>span")
    private WebElement notifySpan;

    @FindBy(css="input#termsofservice")
    private WebElement termsOfServiceChk;

    @FindBy(css="button#checkout")
    private WebElement chkOutBtn;
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clearCart(){
       List<WebElement>cartitems= waitForVisibilityofAllElements(removeCartitemsChkbxLst);
       for(WebElement chk: cartitems){
           waitForWebElementToClickable(chk);
           chk.click();
       }
       waitForWebElementToClickable(updateShoppingCartBtn);
       updateShoppingCartBtn.click();
       return this;
    }

    public String getCartQty(){
        waitForWebElementToAppear(cartQuantitySpan);
        return cartQuantitySpan.getText();
    }

    public void navToShoppingCart(){
        waitForWebElementToClickable(shoppingCartLink);
        shoppingCartLink.click();
    }

    public String getNotification(){
        waitForWebElementToAppear(notificationMsg);
        return notificationMsg.getText();
    }

    public String getEmptymsg(){
        waitForWebElementToAppear(emptyCart);
        return emptyCart.getText();
    }

    public void navToProductMainCategory(String mainCategory){
        String mainCtgxp="//ul[@class='top-menu']//a[contains(text(),'"+mainCategory+"')]";
        By mainCtg= By.xpath(mainCtgxp);
        WebElement mainCtgele=waitForWebElementToAppear(mainCtg);
        Actions act= new Actions(driver);
        act.moveToElement(mainCtgele);
        act.build().perform();
    }
    public void navToProductSubCategory(String subCategory){
        String mainCtgxp="//ul[@class='top-menu']//a[contains(text(),'"+subCategory+"')]";
        By mainCtg= By.xpath(mainCtgxp);
        WebElement mainCtgele=waitForWebElementToAppear(mainCtg);
        Actions act= new Actions(driver);
        act.moveToElement(mainCtgele);
        act.click().build().perform();
    }

     public void selProduct(String productName){
        String product="img[alt='Picture of "+productName+"']";
        By prodImgbtn= By.cssSelector(product);
        WebElement ele=waitForWebElementToClickable(prodImgbtn);
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",ele);
         ele.click();
     }

     public void setQuantity(String qty){
        waitForWebElementToAppear(prodQtyInputcls);
        Actions act = new Actions(driver);
        act.moveToElement(prodQtyInputcls);
        prodQtyInputcls.click();
        prodQtyInputcls.clear();
        waitForWebElementToClickable(prodQtyInputcls);
        prodQtyInputcls.click();
        act.sendKeys(qty).build().perform();
     }

     public void addToCart(){
        waitForWebElementToClickable(addToCartBtn);
         ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",addToCartBtn);
         addToCartBtn.click();
     }

     public void clsNotification(){
        waitForWebElementToClickable(notifySpan);
        notifySpan.click();
     }

     public void agreeWithTerms(){
        waitForWebElementToClickable(termsOfServiceChk);
        termsOfServiceChk.click();
     }

     public void checkOut(){
        waitForWebElementToClickable(chkOutBtn);
        chkOutBtn.click();
     }

//    public void navToProductSubCategory(String subCategory){
//        String subCtgxp="//ul[@class='top-menu']//a[contains(text(),'"+subCategory+"')]";
//        By subCtg= By.xpath(subCtgxp);
//        WebElement subCtgele=waitForWebElementToAppear(subCtg);
//        Actions act= new Actions(driver);
//        act.moveToElement(subCtgele);
//        act.click().build().perform();
//    }


}
