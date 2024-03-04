package bsmartdemoshop.stepdefinitions;

import bsmartdemoshop.factory.DriverFactory;
import bsmartdemoshop.pages.CheckOutPage;
import bsmartdemoshop.pages.PageFactoryManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CheckOutStepDefinition {
    private CheckOutPage checkOutPage;
    private WebDriver driver;

    public CheckOutStepDefinition(){
        driver= DriverFactory.getDriver();
        checkOutPage= PageFactoryManager.getCheckoutPage(driver);
    }

    @When("I provide billing details")
    public void providingBillingDetails(DataTable billingDetailsTable){
        List<Map<String,String>> billingAddress=billingDetailsTable.asMaps(String.class,String.class);
        checkOutPage.selectBillingAddress("New Address");
        checkOutPage.enterBillingFirstName(billingAddress.get(0).get("firstname"));
        checkOutPage.enterBillingLastName(billingAddress.get(0).get("lastname"));
        checkOutPage.enterEmailid(billingAddress.get(0).get("email"));
        checkOutPage.enterCompanyID(billingAddress.get(0).get("company"));
        checkOutPage.selCountry(billingAddress.get(0).get("country"));
        checkOutPage.enterCityID(billingAddress.get(0).get("city"));
        checkOutPage.enterBillingAddress1(billingAddress.get(0).get("Address1"));
        checkOutPage.enterBillingAddress2(billingAddress.get(0).get("Address2"));
        checkOutPage.enterBillingZipCode(billingAddress.get(0).get("zip"));
        checkOutPage.enterBillingPhone(billingAddress.get(0).get("Phone"));
        checkOutPage.navToShippingAddress();

    }
}
