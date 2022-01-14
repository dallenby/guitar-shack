package com.guitarshack.unit;

import com.guitarshack.MessageBuilder;
import com.guitarshack.Product;
import com.guitarshack.QueryParser;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class QueryParsingTest {
    private Map<String, String> queryParameters;

    @Before
    public void setup() {
        QueryParser queryParser = new QueryParser();
        String query = "productId=123&quantity=12&blank=";
         queryParameters = queryParser.parse(query);
    }

    @Test
    public void QueryParserReturnsCorrectNumberOfParameters(){
        assertThat(queryParameters.size(), equalTo(3));
    }

    @Test
    public void QueryParserReturnsCorrectParameters(){
        assertThat(queryParameters.get("productId"), equalTo("123"));
        assertThat(queryParameters.get("quantity"), equalTo("12"));
        assertThat(queryParameters.get("blank"), equalTo(""));
    }

}
