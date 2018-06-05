package com.payit.app.integration;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginSteps extends IntegrationTest {
    private String username;
    private String password;

    @When("^the client has credentials$")
    public void theClientHasCredentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        username = "user2";
        password = "parola";
    }

    @And("^the client calls log in$")
    public void theClientCallsLogIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(username);
        System.out.println(password);

        Map<String, String> params = new LinkedHashMap<>();
        params.put("username", username);
        params.put("password", password);

        this.executeUrlPost("http://localhost:8080/login", params);
    }

    @Then("^the response code is (\\d+)$")
    public void theResponseCodeIs(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(status.value(), arg0);
    }

    @And("^the cookie is set$")
    public void theCookieIsSet() {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(cookie);
    }

    @When("^the client has invalid credentials$")
    public void theClientHasInvalidCredentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        username = "invalid";
        password = "invalid";
    }
}
