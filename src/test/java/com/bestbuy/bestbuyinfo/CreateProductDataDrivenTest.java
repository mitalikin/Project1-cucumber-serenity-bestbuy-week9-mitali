package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/productinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreateProductDataDrivenTest extends TestBase {

    private String name;
    private String type;
    private Integer price;
    private Integer shipping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;
    @Steps
    ProductSteps productSteps;
    @Title("Data driven test for adding multiple products to the application")
    @Test
    public void createMultipleProducts(){
        productSteps.createProduct(name,type,price,shipping,upc,description,manufacturer,model,url,image).statusCode(201);
    }
}
