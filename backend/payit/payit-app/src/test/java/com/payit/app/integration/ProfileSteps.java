package com.payit.app.integration;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProfileSteps extends IntegrationTest {
    private String username;
    private String password;

    @When("^the user has valid credentials$")
    public void theUserHasValidCredentials() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        username = "user2";
        password = "parola";
    }

    @And("^the user logs in$")
    public void theUserLogsIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        Map<String, String> params = new LinkedHashMap<>();
        params.put("username", username);
        params.put("password", password);

        this.executeUrlPost("http://localhost:8080/login", params);
    }

    @Then("^the user can query his profile$")
    public void theUserCanQueryHisProfile() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.executeGet("http://localhost:8080/user/me");
    }

    @And("^the user has queried his profile$")
    public void theUserHasQueriedHisProfile() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.executeGet("http://localhost:8080/user/me");
    }

    @SuppressWarnings("unchecked")
    @And("^see the changes$")
    public void seeTheChanges() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertNotNull(IntegrationTest.latestResponseE.getBody());
        Map<String, Object> resp = (Map<String, Object>)IntegrationTest.latestResponseE.getBody();
        String newFn = (String)resp.get("firstName");
        assertEquals(newFn, newFirstname);
    }

    private String newFirstname;

    @Then("^the user can edit his profile$")
    public void theUserCanEditHisProfile() throws Throwable {
        newFirstname = "new Firstname";

        Map<String, String> map = new HashMap<>();
        map.put("firstName", newFirstname);
        executePost("http://localhost:8080/user/3", map);
    }
}
