package io.falu.models;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import lombok.Getter;

import java.util.Date;

@Getter
public class Period {
    @JsonAdapter(ISO8601DateAdapter.class)
    Date start;
    @JsonAdapter(ISO8601DateAdapter.class)
    Date end;
}
