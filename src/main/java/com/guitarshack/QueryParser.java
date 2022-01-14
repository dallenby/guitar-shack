package com.guitarshack;

import java.util.HashMap;
import java.util.Map;

public class QueryParser {
    public Map<String, String> parse(String query) {
        Map<String, String> result = new HashMap<>();
        String[] queryParameters = query.split("&");
        for(String parameter : queryParameters){
            String[] parameters = parameter.split("=");
            if(parameters.length > 1){
                result.put(parameters[0], parameters[1]);
            }else{
                result.put(parameters[0], "");
            }
        }
        return result;
    }
}
