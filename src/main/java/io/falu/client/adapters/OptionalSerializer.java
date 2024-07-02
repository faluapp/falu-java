package io.falu.client.adapters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.falu.common.Optional;

import java.io.IOException;

public class OptionalSerializer<T> extends JsonSerializer<Optional<T>> {

    @Override
    public void serialize(Optional<T> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value == null || !value.hasValue()) {
            gen.writeNull();
            return;
        }

        var inner = value.getValue();

        if (inner == null) {
            gen.writeNull();
            return;
        }

        gen.writeObject(value.getValue());
    }
}
