package it.ryther.projectriot.API;

public enum Responses {
    _200 (200, "OK"),
    _400 (400, "Bad Request"),
    _401 (401, "Unauthorized"),
    _403 (403, "Forbidden"),
    _404 (404, "Data not found"),
    _405 (405, "Method not allowed"),
    _415 (415, "Unsupported media type"),
    _429 (429, "Rate limit exceeded"),
    _500 (500, "Internal server error"),
    _502 (502, "Bad gateway"),
    _503 (503, "Service unavailable"),
    _504 (504, "Gateway timeout");

    int key;
    String value;

    Responses(int key, String value) {
        this.key = key;
        this.value = value;
    }
}