package io.falu.models.evaluations;

import lombok.Getter;

/**
 * The last error encountered in the evaluation scoring process.
 */
@Getter
public class EvaluationLastError {
    /**
     * A short machine-readable string giving the reason for evaluation or user-session failure.
     */
    private String code;

    /**
     * A human-readable message that explains the reason for evaluation or user-session failure.
     * These message can be shown to your user.
     */
    private String description;
}
