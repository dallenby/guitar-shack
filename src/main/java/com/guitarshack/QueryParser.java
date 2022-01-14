package com.guitarshack;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {
    public Map<String, String> parse(String query) {
        Map<String, String> result = new HashMap<>();
        String[] queryParameters = query.split("&");
        for(String parameter : queryParameters){
            String[] parameters = parameter.split("=");
            result.put(parameters[0], parameters[1]);
        }
        return result;
    }
}
