package io.falu;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import io.falu.common.RangeFilteringOptions;
import io.falu.models.identity.MarketingListOptions;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme("https")
                .host("example.com")
                .addPathSegments("test");

        values.getQueryParameters(builder);

        HttpUrl httpUrl = builder.build();

        String url = httpUrl.toString();
        Assertions.assertEquals("https://example.com/test?ct=100&age.lt=40&count=100&created.gte=2021-03-10T19:41:25.0000000+03:00&sort=descending", url);
    }

    @Test
    public void test_BasicListOptionsWorks() {
        BasicListOptions opt = BasicListOptions.builder()
                .sorting("descending")
                .count(12)
                .created(null)
                .updated(null)
                .build();

        QueryValues query = new QueryValues();
        opt.populate(query);

        Assertions.assertFalse(query.getValues().isEmpty());
        Assertions.assertEquals(Arrays.toString(new String[]{"count", "sort"}), Arrays.toString(query.getKeys()));
        Assertions.assertEquals(Arrays.toString(new String[]{"12", "descending"}), Arrays.toString(query.getParams()));
    }
    
    @Test
    public void test_MarketingListOptionsWorks() {
        RangeFilteringOptions<Integer> filter = new RangeFilteringOptions<>(40, null, null, 29);

        MarketingListOptions opt = MarketingListOptions.builder()
                .sorting("descending")
                .count(12)
                .country("uga")
                .gender("female")
                .age(filter)
                .created(null)
                .updated(null)
                .build();

        QueryValues query = new QueryValues();
        opt.populate(query);

        Assertions.assertFalse(query.getValues().isEmpty());
        Assertions.assertEquals(Arrays.toString(new String[]{
                        "country", "gender", "age.lt", "count", "sort", "age.gte",}),
                Arrays.toString(query.getKeys())
        );
        Assertions.assertEquals(Arrays.toString(new String[]{
                        "uga", "female", "40", "12", "descending", "29",}),
                Arrays.toString(query.getParams())
        );
    }

    private Date toDate(String dateToConsider) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ssss");
        try {
            return formatter.parse(dateToConsider);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
