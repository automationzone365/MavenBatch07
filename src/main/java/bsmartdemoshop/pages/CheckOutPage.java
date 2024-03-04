package bsmartdemoshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
    @FindBy(id="billing-address-select")
    private WebElement billingAddressSel;
    @FindBy(id="BillingNewAddress_FirstName")
    private WebElement billingFirstnameID;
    @FindBy(id="BillingNewAddress_LastName")
    private WebElement billingLastNameID;
    @FindBy(id="BillingNewAddress_Email")
    private WebElement billingEmailID;
    @FindBy(id="BillingNewAddress_Company")
    private WebElement billingCompanyID;
    @FindBy(id="BillingNewAddress_CountryId")
    private WebElement billingCountrySel;
    @FindBy(id="BillingNewAddress_City")
    private WebElement billingCityID;
    @FindBy(id="BillingNewAddress_Address1")
    private WebElement billingAddressOneID;
    @FindBy(id="BillingNewAddress_Address2")
    private WebElement billingAddresstwoID;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    private WebElement billingZipCodeID;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    private WebElement billingPhoneID;

    @FindBy(css="#billing-buttons-container>input")
    private WebElement continueBtn;





    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public void selectBillingAddress(String billingAddress){
        waitForWebElementToAppear(billingAddressSel);
        Select select= new Select(billingAddressSel);
        select.selectByVisibleText(billingAddress);
    }

    public void enterBillingFirstName(String billingFirstName){
       WebElement ele= waitForWebElementToAppear(billingFirstnameID);
       ele.clear();
       ele.sendKeys(billingFirstName);
    }

    public void enterBillingLastName(String billingLastName){
        WebElement ele= waitForWebElementToAppear(billingLastNameID);
        ele.clear();
        ele.sendKeys(billingLastName);
    }

    public void enterEmailid(String billingemailID){
        WebElement ele= waitForWebElementToAppear(billingEmailID);
        ele.clear();
        ele.sendKeys(billingemailID);
    }

    public void enterCompanyID(String billingCompanyName){
        WebElement ele= waitForWebElementToAppear(billingCompanyID);
        ele.clear();
        ele.sendKeys(billingCompanyName);
    }

    public void selCountry(String billingCountryname){
        WebElement ele= waitForWebElementToAppear(billingCountrySel);
        Select select= new Select(billingCountrySel);
        select.selectByVisibleText(billingCountryname);
    }

    public void enterCityID(String billingCity){
        WebElement ele=waitForWebElementToAppear(billingCityID);
        ele.clear();
        ele.sendKeys(billingCity);
    }

    public void enterBillingAddress1(String billingAddress1){
        WebElement ele= waitForWebElementToAppear(billingAddressOneID);
        ele.clear();
        ele.sendKeys(billingAddress1);
    }

    public void enterBillingAddress2(String billingAddress2){
        WebElement ele= waitForWebElementToAppear(billingAddresstwoID);
        ele.clear();
        ele.sendKeys(billingAddress2);
    }

    public void enterBillingZipCode(String billingZipCode){
        WebElement ele= waitForWebElementToAppear(billingZipCodeID);
        ele.clear();
        ele.sendKeys(billingZipCode);
    }

    public void enterBillingPhone(String billingPhone){
        WebElement ele= waitForWebElementToAppear(billingPhoneID);
        ele.clear();
        ele.sendKeys(billingPhone);
    }
    public void navToShippingAddress(){
        waitForWebElementToClickable(continueBtn).click();
    }
}
