package io.falu.models.evaluations;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * [The evaluation object](https://docs.falu.io/api/#evaluations/evaluations/schema)
 * Represents a financial evaluation.
 */
@Getter
@SuperBuilder
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
    private String scope;

    /**
     * Represents the status of an evaluation
     */
    private String status;

    /**
     * Represents the scoring result for an evaluation.
     */
    Scoring scoring;
}
