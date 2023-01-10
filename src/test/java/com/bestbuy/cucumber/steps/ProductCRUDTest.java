package com.bestbuy.cucumber.steps;

import com.bestbuy.bestbuyinfo.ProductSteps;
import com.bestbuy.constants.Path;
import com.bestbuy.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.BeforeClass;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ProductCRUDTest {
    static ValidatableResponse response;
    static int productID;
    static String type;
    static String name;
    //static String name=null;
    @BeforeClass
    public static void endPath() {
        RestAssured.basePath = Path.PRODUCTS;
    }
    @Steps
    ProductSteps productSteps;

    @Given("^I am on homepage of products endpoint$")
    public void iAmOnHomepageOfProductsEndpoint() {
    }

    @When("^I send GET request to the product endpoint$")
    public void iSendGETRequestToTheProductEndpoint() {
        response = productSteps.getAllProducts();
    }

    @Then("^I must get valid response code 200$")
    public void iMustGetValidResponseCode() {
        response.statusCode(200);
    }


    @When("^I create a new product by providing information name\"([^\"]*)\"type\"([^\"]*)\"price\"([^\"]*)\"shipping\"([^\"]*)\"upc\"([^\"]*)\"description\"([^\"]*)\"manufacturer\"([^\"]*)\"model\"([^\"]*)\"url\"([^\"]*)\"image\"([^\"]*)\"$")
    public void iCreateANewProductByProvidingInformationNameTypePriceShippingUpcDescriptionManufacturerModelUrlImage(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image) {

        ValidatableResponse response = productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image);
        response.log().all().statusCode(201);
        productID = response.log().all().extract().path("id");
    }

    @Then("^I verify that the product is created with \"([^\"]*)\"$")
    public void iVerifyThatTheProductIsCreatedWith(String name)  {
        HashMap<String, Object> productMap = productSteps.getProductInfoAddedByName(productID);
        Assert.assertThat(productMap, hasValue(name));
    }

    @Given("^Product Information is running$")
    public void productInformationIsRunning() {
    }

    @And("^I update the product with information productID \"([^\"]*)\"  name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacture \"([^\"]*)\" model \"([^\"]*)\" url\"([^\"]*)\" image \"([^\"]*)\"$")
    public void iUpdateTheProductWithInformationProductIDNameTypePriceShippingUpcDescriptionManufactureModelUrlImage(int productID, String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image)  {
      name=name+"_updated";
      response=productSteps.updateProduct(productID,name,type,price,shipping,upc,description,manufacturer,model,url,image);
    }

    @And("^The product with productID \"([^\"]*)\" is updated successfully$")
    public void theProductWithProductIDIsUpdatedSuccessfully(String name)  {
        HashMap<String,Object> studentMap = productSteps.getProductInfoByname(name);
        Assert.assertThat(studentMap, hasValue(name));
    }

    @And("^I delete the product that created with productID \"([^\"]*)\"$")
    public void iDeleteTheProductThatCreatedWithProductID(String name)  {
        response = productSteps.deleteProduct(productID);
    }

    @Then("^The product deleted successfully from the product information$")
    public void theProductDeletedSuccessfullyFromTheProductInformation() {
        response.statusCode(204);
        productSteps.getProductById(productID).statusCode(404);
    }
}
