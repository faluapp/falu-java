package io.falu.client.adapters;

import com.google.gson.*;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

public class ISO8601DateAdapter extends ISO8601Utils implements JsonDeserializer<Date>, JsonSerializer<Date> {
    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            return parse(jsonElement.getAsString(), new ParsePosition(0));

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(format(src));
    }
}
