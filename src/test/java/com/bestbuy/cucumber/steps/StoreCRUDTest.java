package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.StoresSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StoreCRUDTest {
    static  String name;
    static int storeID;
    static ValidatableResponse response;

    @Steps
    StoresSteps storesSteps;

    @When("^User sends a Get request to store endpoint$")
    public void userSendsAGetRequestToStoreEndpoint() {
        response=storesSteps.getAllStores();

    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I create a new store by providing information name \"([^\"]*)\" type \"([^\"]*)\"address \"([^\"]*)\" address(\\d+) \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat\"([^\"]*)\" lng \"([^\"]*)\"hours\"([^\"]*)\"$")
    public void iCreateANewStoreByProvidingInformationNameTypeAddressAddressCityStateZipLatLngHours(String name, String type, String address, String address2, String city, String state, String zip, double lat, double lng,String hours) {
        response = storesSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours);
    }
    @Then("^I verify that the store is created with \"([^\"]*)\"$")
    public void iVerifyThatTheStoreIsCreatedWith(String name)  {
        HashMap<String, Object> productMap = storesSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(productMap, hasValue(name));
    }



    @Given("^Store Information is running$")
    public void storeInformationIsRunning() {
    }


    @And("^I update the store with information storeID \"([^\"]*)\" \"([^\"]*)\" type \"([^\"]*)\"address \"([^\"]*)\" address(\\d+) \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat\"([^\"]*)\" lng \"([^\"]*)\"hours\"([^\"]*)\"$")
    public void iUpdateTheStoreWithInformationStoreIDTypeAddressAddressCityStateZipLatLngHours(String _name, String type, String address, String address2, String city, String state, String zip, double lat, double lng,String hours )  {
      name=name+"_updated";
      response=storesSteps.updateStore(storeID,name,type,address,address2,city,state,zip,lat,lng,hours);
    }

    @And("^The store with storeID \"([^\"]*)\" is updated successfully$")
    public void theStoreWithStoreIDIsUpdatedSuccessfully(String _name)  {
        HashMap<String,Object> studentMap = storesSteps.getStoreInfoByStoreID(storeID);
        Assert.assertThat(studentMap, hasValue(name));
    }

    @And("^I delete the store that created with storeID \"([^\"]*)\"$")
    public void iDeleteTheStoreThatCreatedWithStoreID(String name)  {
      response=storesSteps.deleteStoreByID(storeID);
    }

    @Then("^The store deleted successfully from the store information$")
    public void theStoreDeletedSuccessfullyFromTheStoreInformation() {
        response.statusCode(204);
        storesSteps.getStoreById(storeID).statusCode(404);
    }
}
