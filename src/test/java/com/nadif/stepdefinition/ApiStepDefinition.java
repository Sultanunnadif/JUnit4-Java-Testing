package com.nadif.stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.ReqresApiPages;

public class ApiStepDefinition {
    ReqresApiPages reqresApiPages = new ReqresApiPages();
    String requestBody;
    Response response;

    @Given("set GET request for end point {string}")
    public void setupGetEndPoint(String endpoint){
        reqresApiPages.setEndpoint(endpoint);
    }
    @Given("set POST request for endpoint {string}")
    public void setupPOSTEndPoint(String endpoint) {
        reqresApiPages.setEndpoint(endpoint);
    }

    @When("send GET request")
    public void sendGetRequest(){
        response = reqresApiPages.sendGetRequest();
        System.out.println(response.getBody().asString());
    }

    @Then("response code should be {int}")
    public void verifyRespondCode(int expectedrespondcode){
        int actualResponseCode = response.getStatusCode();
        System.out.println("Actual Respond Code :" + actualResponseCode);
        Assert.assertEquals(expectedrespondcode,actualResponseCode);
    }

    @Then("response should contain {string}")
    public void verifyRespondContainsText (String text){
        String respondBody = response.getBody().asString();
        Assert.assertTrue(respondBody.contains((text)));
    }

    @Given("request body :")
    public void requestBody(String requestBody) { //karena ada string setelahnya di feature
        this.requestBody = requestBody;
    }

    @When("send Post request")
    public void sendPostRequest() {
        response = reqresApiPages.sendPOSTRequest(this.requestBody);
        System.out.println(response.getBody().asString());
    }
}
