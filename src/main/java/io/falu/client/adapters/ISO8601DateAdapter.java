package io.falu.client.adapters;

import com.google.gson.*;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

public class ISO8601DateAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return ISO8601Utils.parse(jsonElement.getAsString(), new ParsePosition(0));

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(ISO8601Utils.format(src));
    }
}
