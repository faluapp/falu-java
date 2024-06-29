package io.falu.client.adapters;


import com.google.gson.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

public class OptionalAdapter<T> implements JsonDeserializer<Optional<T>>, JsonSerializer<Optional<T>> {
    @Override
    public Optional<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonNull()) {
            return Optional.empty();
        } else {
            T value = context.deserialize(json, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]);
            return Optional.ofNullable(value);
        }
    }

    @Override
    public JsonElement serialize(Optional<T> src, Type typeOfSrc, JsonSerializationContext context) {
        if (src.isPresent()) {
            return context.serialize(src.get());
        } else {
            return JsonNull.INSTANCE;
        }
    }
}
