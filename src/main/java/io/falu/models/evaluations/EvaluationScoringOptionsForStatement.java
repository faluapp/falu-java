package io.falu.models.evaluations;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Evaluation scoring options for using statements.
 */
@Getter
@Setter
@SuperBuilder()
public class EvaluationScoringOptionsForStatement {

    /**
     * The allowed providers
     * Users will only be allowed to upload documents from these providers.
     */
    private String[] allowed;
}
