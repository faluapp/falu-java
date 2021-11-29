package io.falu.models.evaluations;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;
import lombok.Getter;

import java.util.Date;

/**
 * [The evaluation object](https://docs.falu.io/api/#evaluations/evaluations/schema)
 * Represents a financial evaluation.
 */
@Getter
public class Evaluation extends FaluModel {
    /**
     * Unique identifier of the evaluation.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Represents the scope within which an evaluation is generated.
     * This can also be considered the purpose of the evaluation.
     */
    private EvaluationScope scope;

    /**
     * Time at which the object was created.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date created;

    /**
     * Represents the status of an evaluation
     */
    private EvaluationStatus status;

    /**
     * Represents the scoring result for an evaluation.
     */
    Scoring scoring;
}
