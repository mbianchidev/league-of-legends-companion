package it.ryther.projectriot.API.Interfaces;

public interface CallInterface<T> {
    String getApiPath();
    T setQueryParamValue(QueryParamInterface key, String value);
    T setPathVarValue(PathVarInterface key, String value);
    String getFullApiPath();
}
