package io.falu.models.evaluations;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import lombok.Getter;

import java.util.Date;

/**
 * Outputs of scoring done in an evaluation.
 */
@Getter
public class EvaluationScoringOutputs {
    /**
     * Provider used for scoring document.
     */
    private String statementProvider;

    /**
     * Name found in the document.
     */
    private String name;

    /**
     * Email found in the document.
     */
    private String email;

    /**
     * Phone found in document
     */
    private String phone;

    /**
     * Time at which the document was generated by the provider.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date generated;

    /**
     * Risk probability. The higher the value, the higher the risk
     */
    private Float risk;

    /**
     * Limit advised for lending in the smallest currency unit.
     */
    private Float limit;

    /**
     * Time till when the score is deemed valid.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date expires;
}
