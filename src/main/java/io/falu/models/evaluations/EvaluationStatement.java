package io.falu.models.evaluations;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.Period;
import lombok.Getter;

import java.util.Date;

/**
 * Represents details about the statement used for an evaluation.
 */
@Getter
public class EvaluationStatement {
    /**
     * Represents the kind of provider used for a statement in an evaluation.
     */
    StatementProvider provider;

    /**
     * Email found in the statement.
     */
    String email;

    /**
     * Name found in the statement
     */
    String name;

    /**
     * Phone number found in the statement.
     */
    String phone;

    /**
     * Time at which the statement was generated by the provider.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    Date generated;

    /**
     * The period of the statement
     */
    Period period;
}
