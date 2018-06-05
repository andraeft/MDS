package com.payit.app.integration;

import com.payit.app.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
@ContextConfiguration(classes = App.class)
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
public class IntegrationTest {
    static ResponseResults latestResponse = null;

    static HttpStatus status;

    static ResponseEntity latestResponseE = null;

    static String cookie = null;

    @Autowired
    protected RestTemplate restTemplate;

    void executeGet(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (cookie != null) headers.add("Cookie", "PAYITSESSIONID=" + cookie);
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        HttpEntity requestEntity = new HttpEntity(null, headers);

        try {
            ResponseEntity response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    Object.class
            );
            status = response.getStatusCode();
            latestResponseE = response;
        } catch (HttpClientErrorException e) {
            status = e.getStatusCode();
        }
    }

    void executePost(String url, Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (cookie != null) headers.add("Cookie", "PAYITSESSIONID=" + cookie);
        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }
        HttpEntity requestEntity = new HttpEntity(body, headers);

        try {
            ResponseEntity response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    requestEntity,
                    Object.class
            );
            status = response.getStatusCode();
            latestResponseE = response;
        } catch (HttpClientErrorException e) {
            status = e.getStatusCode();
        }
    }

    void executeUrlPost(String url, Map<String, String> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        if (restTemplate == null) {
            restTemplate = new RestTemplate();
        }

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        params.forEach(map::add);


        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<Object> response;
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, entity, Object.class);
            status = response.getStatusCode();
            latestResponseE = response;
            extractCookieValue(response.getHeaders().get("Set-Cookie").get(0));
        } catch (HttpClientErrorException e) {
            status = e.getStatusCode();
        }
    }

    private class ResponseResultErrorHandler implements ResponseErrorHandler {
        private ResponseResults results = null;
        private Boolean hadError = false;

        private ResponseResults getResults() {
            return results;
        }

        @Override
        public boolean hasError(ClientHttpResponse response) throws IOException {
            hadError = response.getRawStatusCode() >= 400;
            return hadError;
        }

        @Override
        public void handleError(ClientHttpResponse response) throws IOException {
            results = new ResponseResults(response);
        }
    }

    private void extractCookieValue(String val) {
        if (val == null) return;
        Pattern pattern = Pattern.compile("PAYITSESSIONID=(.*); Path=/; HttpOnly");
        Matcher matcher = pattern.matcher(val);
        if (matcher.matches()) {
            cookie = matcher.group(1);
        }
    }
}
