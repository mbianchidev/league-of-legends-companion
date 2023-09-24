package it.ryther.projectriot.API.WhatIsMyMMR;

import it.ryther.projectriot.API.Interfaces.CallInterface;
import it.ryther.projectriot.API.Interfaces.PathVarInterface;
import it.ryther.projectriot.API.Interfaces.QueryParamInterface;
import it.ryther.projectriot.API.SummonerV4.Summoner;
import it.ryther.projectriot.Application;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class MyMMRCall implements CallInterface {

    public enum QueryParams implements QueryParamInterface {
        NAME ("name");

        private String key;

        QueryParams(String key) {
            this.key = key;
        }

        @Override
        public String getKey() {
            return this.name();
        }

        @Override
        public String getValue() {
            return this.key;
        }
    }

    private static final String API_PATH = "/api/v1/summoner";
    private String fullApiPath = API_PATH;
    private HashMap<QueryParamInterface, String> queryParamsValues = new HashMap<>();

    @Override
    public String getApiPath() {
        return MyMMRCall.API_PATH;
    }

    @Override
    public MyMMRCall setQueryParamValue(QueryParamInterface key, String value) {
        this.queryParamsValues.put(key, value);
        return this;
    }

    @Override
    public MyMMRCall setPathVarValue(PathVarInterface key, String value) { return this; }

    @Override
    public String getFullApiPath() {
        if (!queryParamsValues.isEmpty()) {
            fullApiPath += "?";
            QueryParams[] values = QueryParams.values();
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    fullApiPath += "&";
                }
                QueryParamInterface key = values[i];
                String value = this.queryParamsValues.get(key);
                fullApiPath += key.getValue() + "=" + value;
            }
        }
        return fullApiPath;
    }

    public MyMMR run(String baseUrl, String userAgent) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", userAgent + ":it.ryther.projectriot:v0.0.1");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        return restTemplate.exchange(baseUrl + this.getFullApiPath(), HttpMethod.GET, entity, MyMMR.class).getBody();
    }
}
