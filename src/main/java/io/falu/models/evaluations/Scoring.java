package io.falu.models.evaluations;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import lombok.Getter;

import java.util.Date;

/**
 * Represents the scoring result for an evaluation.
 */
@Getter
public class Scoring {
    /**
     * Risk probability. The higher the value, the higher the risk
     */
    Float risk;

    /**
     * Limit advised for lending in the smallest currency unit.
     */
    Float limit;

    /**
     * Risk probability. The higher the value, the higher the risk
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date expires;
}
