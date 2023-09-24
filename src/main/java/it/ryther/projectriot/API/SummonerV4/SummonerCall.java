package it.ryther.projectriot.API.SummonerV4;

import it.ryther.projectriot.API.Interfaces.CallInterface;
import it.ryther.projectriot.API.Interfaces.PathVarInterface;
import it.ryther.projectriot.API.Interfaces.QueryParamInterface;
import it.ryther.projectriot.Application;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class SummonerCall implements CallInterface {
    public enum PathVars implements PathVarInterface {
        SUMMONER_NAME ("{summonerName}");

        private String placeholder;

        PathVars(String placeholder) {
            this.placeholder = placeholder;
        }

        @Override
        public String getKey() {
            return this.name();
        }

        @Override
        public String getValue() {
            return this.placeholder;
        }
    }

    public enum QueryParams implements QueryParamInterface {
        API_KEY ("api_key");

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

    private static final String API_PATH = "/lol/summoner/v4/summoners/by-name/" + PathVars.SUMMONER_NAME.placeholder;
    private String fullApiPath = API_PATH;
    private HashMap<PathVarInterface, String> pathVarsValues = new HashMap<>();
    private HashMap<QueryParamInterface, String> queryParamsValues = new HashMap<>();

    @Override
    public String getApiPath() {
        return SummonerCall.API_PATH;
    }

    @Override
    public SummonerCall setQueryParamValue(QueryParamInterface key, String value) {
        this.queryParamsValues.put(key, value);
        return this;
    }

    @Override
    public SummonerCall setPathVarValue(PathVarInterface key, String value) {
        this.pathVarsValues.put(key, value);
        return this;
    }

    @Override
    public String getFullApiPath() {
        if (!pathVarsValues.isEmpty()) {
            for (PathVarInterface key : PathVars.values()) {
                String keyValue = key.getValue();
                String value = this.pathVarsValues.get(key);
                this.fullApiPath = this.fullApiPath.replace(keyValue, value);
            }
        }
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

    public Summoner run(String baseUrl, String apiKey) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Riot-Token", apiKey);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        return restTemplate.exchange(baseUrl + this.getFullApiPath(), HttpMethod.GET, entity, Summoner.class).getBody();
    }
}
