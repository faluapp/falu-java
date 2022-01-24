package io.falu;

import io.falu.common.QueryValues;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class QueryValueTests {

    @Test
    public void test_QueryIsGenerated() {
        Map<String, String> params = new HashMap<>();
        params.put("sort", "descending");
        params.put("count", "100");
        params.put("ct", "100");
        params.put("age.lt", "40");
        params.put("created.gte", "2021-03-10T19:41:25.0000000+03:00");

        QueryValues values = new QueryValues(params);

        HttpUrl httpUrl = values.getQueryParameters()
                .scheme("https")
                .host("example.com")
                .addPathSegments("test")
                .build();

        String url = httpUrl.toString();
        Assertions.assertEquals("https://example.com/test?ct=100&age.lt=40&count=100&created.gte=2021-03-10T19:41:25.0000000+03:00&sort=descending", url);
    }
}
