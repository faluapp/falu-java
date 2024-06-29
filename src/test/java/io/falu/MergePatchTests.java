package io.falu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.falu.client.adapters.OptionalAdapter;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class MergePatchTests {

    private final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Optional.class, new OptionalAdapter<>())
        .create();

    private String makeJson(@Nullable Object o) {
        return gson.toJson(o);
    }

    @Test
    public void test_DeserializationWorks() {
        // no properties
        var json = "{}";
        TestUpdateOptions updateOptions = gson.fromJson(json, TestUpdateOptions.class);
        Assertions.assertNull(updateOptions.currency);
        Assertions.assertNull(updateOptions.paid);

        // only one property
        json = "{\"currency\":\"USD\"}";
        updateOptions = gson.fromJson(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.currency.isPresent());
        Assertions.assertFalse(updateOptions.currency.get().isEmpty());
        Assertions.assertNull(updateOptions.paid);

        // paid property
        json = "{\"paid\":\"true\"}";
        updateOptions = gson.fromJson(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.paid.isPresent());
        Assertions.assertNull(updateOptions.currency);

        // both properties
        json = "{\"currency\":\"USD\",\"paid\":\"true\"}";
        updateOptions = gson.fromJson(json, TestUpdateOptions.class);
        Assertions.assertTrue(updateOptions.paid.isPresent());
        Assertions.assertTrue(updateOptions.currency.isPresent());
    }

    @Test
    public void test_SerializationWorks() {
        // no properties
        TestUpdateOptions updateOptions = new TestUpdateOptions();
        var expected = "{}";
        var actual = makeJson(updateOptions);
        Assertions.assertEquals(expected, actual);

        // only one property
        updateOptions = new TestUpdateOptions();
        updateOptions.currency = Optional.of("USD");

        expected = "{\"currency\":\"USD\"}";
        actual = makeJson(updateOptions);
        Assertions.assertEquals(expected, actual);

        // paid property
        updateOptions = new TestUpdateOptions();
        updateOptions.paid = Optional.of(true);

        expected = "{\"paid\":true}";
        actual = makeJson(updateOptions);
        Assertions.assertEquals(expected, actual);

        // both properties
        updateOptions = new TestUpdateOptions();
        updateOptions.paid = Optional.of(true);
        updateOptions.currency = Optional.of("USD");

        expected = "{\"currency\":\"USD\",\"paid\":true}";
        actual = makeJson(updateOptions);
        Assertions.assertEquals(expected, actual);
    }

    private static class TestUpdateOptions {
        Optional<String> currency;

        Optional<Boolean> paid;
    }
}
