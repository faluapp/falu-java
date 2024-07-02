package io.falu;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.falu.client.adapters.OptionalSerializer;
import io.falu.common.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class MergePatchTests {
    @Test
    public void test_DeserializationWorks() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Optional.class, new OptionalSerializer());
        objectMapper.registerModule(module);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // no properties
        var json = "{}";
        TestUpdateOptions updateOptions = objectMapper.readValue(json, TestUpdateOptions.class);
        Assertions.assertNull(updateOptions.currency);
        Assertions.assertNull(updateOptions.paid);

        // only one property
        json = "{\"currency\":\"USD\"}";
        updateOptions = objectMapper.readValue(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.currency.hasValue());
        Assertions.assertFalse(updateOptions.currency.getValue().isEmpty());
        Assertions.assertNull(updateOptions.paid);

        // paid property
        json = "{\"paid\":\"true\"}";
        updateOptions = objectMapper.readValue(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.paid.hasValue());
        Assertions.assertNull(updateOptions.currency);

        // both properties
        json = "{\"currency\":\"USD\",\"paid\":\"true\"}";
        updateOptions = objectMapper.readValue(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.paid.hasValue());
        Assertions.assertTrue(updateOptions.currency.hasValue());
    }

    @Test
    public void test_SerializationWorks() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Optional.class, new OptionalSerializer());
        objectMapper.registerModule(module);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // no properties
        TestUpdateOptions updateOptions = new TestUpdateOptions();
        var expected = "{}";
        var actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);

        // only one property
        updateOptions = new TestUpdateOptions();
        updateOptions.setCurrency("USD");

        expected = "{\"currency\":\"USD\"}";
        actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);

        // paid property
        updateOptions = new TestUpdateOptions();
        updateOptions.setPaid(true);

        expected = "{\"paid\":true}";
        actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);

        // both properties
        updateOptions = new TestUpdateOptions();
        updateOptions.setPaid(true);
        updateOptions.setCurrency("USD");

        expected = "{\"currency\":\"USD\",\"paid\":true}";
        actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);

        // multiple properties
        HashMap<String, String> meta = new HashMap<>();
        meta.put("name", "falu");

        updateOptions = new TestUpdateOptions();
        updateOptions.setPaid(true);
        updateOptions.setCurrency("USD");
        updateOptions.setMetadata(meta);

        expected = "{\"currency\":\"USD\",\"paid\":true,\"metadata\":{\"name\":\"falu\"}}";
        actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);

        // multiple properties and null
        meta = new HashMap<>();
        meta.put("name", "falu");

        updateOptions = new TestUpdateOptions();
        updateOptions.setPaid(true);
        updateOptions.setCurrency(null);
        updateOptions.setMetadata(meta);

        expected = "{\"currency\":null,\"paid\":true,\"metadata\":{\"name\":\"falu\"}}";

        actual = objectMapper.writeValueAsString(updateOptions);
        Assertions.assertEquals(expected, actual);
    }

    private static class TestUpdateOptions {
        private Optional<String> currency;
        private Optional<Boolean> paid;
        private Optional<Map<String, String>> metadata;

        public Optional<String> getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = Optional.of(currency);
        }

        public Optional<Boolean> getPaid() {
            return paid;
        }

        public void setPaid(Boolean paid) {
            this.paid = Optional.of(paid);
        }

        public Optional<Map<String, String>> getMetadata() {
            return metadata;
        }

        public void setMetadata(Map<String, String> metadata) {
            this.metadata = Optional.of(metadata);
        }
    }
}
