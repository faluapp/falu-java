package io.falu;

import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import io.falu.common.RangeFilteringOptions;
import io.falu.models.payments.PaymentsListOptions;
import okhttp3.HttpUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class QueryValueTests {

    @Test
    public void test_QueryIsGenerated() {
        Map<String, String[]> params = new HashMap<>();
        params.put("sort", new String[]{"descending"});
        params.put("count", new String[]{"100"});
        params.put("ct", new String[]{"100"});
        params.put("age.lt", new String[]{"40"});
        params.put("created.gte", new String[]{"2021-03-10T19:41:25.0000000+03:00"});

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
                .sorting(new String[]{"descending"})
                .count(12)
                .created(null)
                .updated(null)
                .build();

        QueryValues query = new QueryValues();
        opt.populate(query);

        Assertions.assertFalse(query.getValues().isEmpty());
        Assertions.assertEquals(Arrays.toString(new String[]{"count", "sort"}), Arrays.toString(query.getKeys()));
    }

    @Test
    public void test_MultipleQueryValuesWorks() {
        Map<String, String[]> params = new HashMap<>();

        QueryValues values = new QueryValues(params);
        values.add("sort", new String[]{"desc"});
        values.add("count", new String[]{String.valueOf(100)});
        values.add("type", new String[]{"transfer.created", "transfer.failed", "transfer.succeeded"});

        HttpUrl.Builder builder = new HttpUrl.Builder()
                .scheme("https")
                .host("example.com")
                .addPathSegments("events");

        values.getQueryParameters(builder);

        HttpUrl httpUrl = builder.build();

        String url = httpUrl.toString();
        Assertions.assertEquals("https://example.com/events?count=100&sort=desc&type=transfer.created&type=transfer.failed&type=transfer.succeeded", url);
    }

    @Test
    public void test_PopulatingPaymentListOptions() {
        LocalDate startDate = LocalDate.parse("2018-05-05");
        LocalDate endDate = LocalDate.parse("2018-05-07");

        RangeFilteringOptions<Date> createdRangeFilter = RangeFilteringOptions.<Date>builder()
                .greaterThan(Date.from(startDate.atStartOfDay().toInstant(ZoneOffset.MIN)))
                .lessThan(Date.from(endDate.atStartOfDay().toInstant(ZoneOffset.MIN)))
                .build();

        PaymentsListOptions options = PaymentsListOptions.builder()
                .created(createdRangeFilter)
                .build();

        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme("https");
        builder.host("example.com");
        builder.addPathSegments("payments");

        QueryValues values = new QueryValues();
        options.populate(values);
        values.getQueryParameters(builder);

        HttpUrl url = builder.build();
        String expectation = "https://example.com/payments?created.gt=2018-05-05T18:00:00Z&created.lt=2018-05-07T18:00:00Z";
        Assertions.assertEquals(expectation, url.url().toString());
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
