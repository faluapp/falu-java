package io.falu.models.evaluations;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Options for scoring an evaluation
 */
@Getter
@Setter
@SuperBuilder()
public class EvaluationScoringOptions {
    /**
     * Scope for the evaluation
     */
    private String scope;

    /**
     * Options for using the statement
     */
    private EvaluationScoringOptionsForStatement statement;
}
