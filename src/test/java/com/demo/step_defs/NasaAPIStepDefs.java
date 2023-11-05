package com.demo.step_defs;

import com.demo.utils.ConfigurationReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.given;

public class NasaAPIStepDefs {

    Response response;

    @When("User user sends get request to given {string}")
    public void userUserSendsGetRequestToEndPoint(String endPoint) {

        String url = ConfigurationReader.getProperty(endPoint);

        response = given().accept(ContentType.JSON)
                .when().queryParam("api_key", "DEMO_KEY")
                .and().queryParam("sol", 1)
                .and().queryParam("page",1)
                .and().get(url);
    }

    @When("User asserts the response returns {int}")
    public void userAssertsTheResponseReturns(int statusCode)  {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, actualStatusCode);

        System.out.println("actualStatusCode = " + actualStatusCode);

        JsonPath jsonPath = response.jsonPath();

        List<String> anInt = jsonPath.getList("photos.earth_date");

        //List<String> lisId= jsonPath.get("findAll {photos.id}");
        System.out.println("lisId = " + anInt.size());

    }
}
