package it.ryther.projectriot.API.Queues;

import it.ryther.projectriot.API.Interfaces.CallInterface;
import it.ryther.projectriot.API.Interfaces.PathVarInterface;
import it.ryther.projectriot.API.Interfaces.QueryParamInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class QueuesCall implements CallInterface {

    private static final String API_PATH = "http://static.developer.riotgames.com/docs/lol/queues.json";

    @Override
    public String getApiPath() {
        return QueuesCall.API_PATH;
    }

    @Override
    public QueuesCall setQueryParamValue(QueryParamInterface key, String value) { return this; }

    @Override
    public QueuesCall setPathVarValue(PathVarInterface key, String value) { return this; }

    @Override
    public String getFullApiPath() {
        return this.getApiPath();
    }

    public static List<Queue> run() {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        HttpEntity<String> entity = new HttpEntity<>("body");

        return Arrays.asList(restTemplate.exchange(API_PATH, HttpMethod.GET, entity, Queue[].class).getBody().clone());
    }
}
