package io.falu.common;

import com.google.gson.internal.bind.util.ISO8601Utils;
import okhttp3.HttpUrl;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Helper for handling query parameters
 */
public class QueryValues {
    private final Map<String, String> values;

    /***/
    public QueryValues(Map<String, String> values) {
        this.values = values;
    }

    public QueryValues() {
        this.values = new HashMap<>();
    }

    /***/
    public QueryValues add(String key, String value) {
        if (value != null && !value.isEmpty()) {
            values.put(key, value);
        }
        return this;
    }

    /***/
    public QueryValues remove(String key) {
        values.remove(key);
        return this;
    }

    /***/
    public QueryValues add(String key, Object value) {
        if (value == null) return this;

        if (value instanceof Boolean) {
            add(key, value.toString().toLowerCase(Locale.ROOT));
        } else if (value instanceof Date) {
            add(key, ISO8601Utils.format((Date) value));
        } else if (value instanceof Integer) {
            add(key, String.valueOf(value));
        } else if (value instanceof Long) {
            add(key, String.valueOf(value));
        }

        return this;
    }

    /***/
    public QueryValues add(String key, String[] values) {
        String value = values == null ? "" : String.join(",", values);
        add(key, value);
        return this;
    }

    /***/
    public QueryValues add(String property, QueryValues other) {
        if (other == null) return this;

        if (property == null || property.isEmpty()) {
            return this;
        }
        
        for (Map.Entry<String, String> entry : other.values.entrySet()) {
            add(property + "." + entry.getKey(), entry.getValue());
        }
        return this;
    }

    /***/
    public <T> QueryValues fromRange(RangeFilteringOptions<T> options) {
        if (options != null) {
            add("lt", options.lessThan());
            add("lte", options.lessThanOrEqualTo());
            add("gt", options.greaterThan());
            add("gte", options.greaterThanOrEqualTo());
        }
        return this;
    }

    /***/
    public HttpUrl.Builder getQueryParameters() {
        HttpUrl.Builder builder = new HttpUrl.Builder();

        for (Map.Entry<String, String> entry : values.entrySet()) {
            builder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
        }
        return builder;
    }

    public String[] getKeys() {
        return values.keySet().toArray(new String[0]);
    }

    public String[] getParams() {
        return values.values().toArray(new String[0]);
    }

    public Map<String, String> getValues() {
        return values;
    }
}
